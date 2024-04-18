from django.http import HttpResponse
from django.shortcuts import redirect, render
from django.http.response import JsonResponse
from django.views.decorators.csrf import csrf_exempt
from myapp01.models import Board, Comment
import urllib.parse
import math
# Create your views here.

# UPLOAD_DIR = 'D:/__2024JUNG/DjangoWork/upload/'
# UPLOAD_DIR = 'C:/Users/it/Desktop/work/after_4_month'
UPLOAD_DIR = 'C:/Users/it/Desktop/work/after_4_month/upload/'


#write_form
def write_form(request):
    return render(request, 'board/write.html')

#insert 추가
@csrf_exempt
def insert(request):
    fname = ''
    fsize = 0
    if 'file' in request.FILES:
        file = request.FILES['file']
        fname  = file.name
        fsize = file.size

        fp = open('%s%s' %(UPLOAD_DIR,fname),'wb')

        for chunk in file.chunks():
            fp.write(chunk)
        fp.close()    

    dto = Board(writer = request.POST['writer'],
                title = request.POST['title'],
                content = request.POST['content'],
                filename = fname,
                filesize = fsize
                )
    dto.save()
    # return render(request, '/list')
    return redirect('/list')

# #list 전체 보기
# def list(request):
#     return render(request, 'board/list.html')

#list 전체 보기
# def list(request):
#     boardList=Board.objects.all()
#     boardCount=Board.objects.all().count()
#     # print(boardList.query)
#     context={'boardList' : boardList, 
#              'boardCount' : boardCount}
    
#     return render(render, 'board/list.html', context)
    

def list(request):
    page=request.GET.get('page',1)
    #count
    boardCount=Board.objects.all().count()
    #page
    pageSize=5
    blockPage=3
    currentPage=int(page)

    totalPage= math.ceil(boardCount/pageSize)  #총페이지 수 : 7
    startPage=math.floor((currentPage-1)/blockPage)*pageSize+1
    endPage= startPage+blockPage-1   #7+3-1=9(현재페이지를 7로)
    if(endPage>totalPage):
        endPage=totalPage

    start=(currentPage-1)*pageSize
    boardList=Board.objects.all().order_by('-idx')[start:start+pageSize]   #내림차순 정렬이라면 '-'를 붙인다


    context={'boardList' : boardList,
             'boardCount' : boardCount,
              'startPage' : startPage,
              'blockPage' : blockPage,
              'endPage' : endPage,
              'totalPage' : totalPage,
              'range' : range(startPage, endPage+1),
              'currentPage' : currentPage}    #range쓰려면 render로 range를 넘겨야한다

    return render(request, 'board/list.html', context,)

def detail_idx(request):
    id=request.GET['idx']
    print('id : ', id)
    dto=Board.objects.get(idx=id)
    dto.hit_up()
    dto.save()

    return render(request, 'board/detail.html', {'dto': dto})

def detail(request, board_idx):
    dto=Board.objects.get(idx=board_idx)
    dto.hit_up()
    dto.save()
    
    return render(request, 'board/detail.html', {'dto': dto})


def delete(request, board_idx):
    Board.objects.get(idx=board_idx).delete()

    return redirect('/list/')

def delete_idx(request):
    board_idx=request.GET['idx']
    Board.objects.get(idx=board_idx).delete()

    return redirect('/list/')


def update_form(request, board_idx):
    # Board.objects.get(idx=board_idx).()

    return render(request, "board/update.html")


def update_form(request, board_idx):

    dto=Board.objects.get(idx=board_idx)
    return render(request, "board/update.html", {'dto':dto})


@csrf_exempt
def update(request):
    id=request.POST['idx']
    dto=Board.objects.get(idx=id)
    fname=dto.filename
    fsize=dto.filesize

    if 'file' in request.FILES:
        file=request.FILES['file']
        fsize=file.size
        fname=file.name

        fp = open('%s%s' %(UPLOAD_DIR,fname),'wb')

        for chunk in file.chunks():
            fp.write(chunk)
        fp.close()    

    dto_update=Board(id,
                        writer=request.POST['writer'],
                        title=request.POST['title'],
                        content=request.POST['content'],
                        filename=fname,
                        filesize=fsize,
                        )
    dto_update.save()
    
    return redirect('/list')


def download_count(request):
    id = request.GET['idx']
    dto = Board.objects.get(idx=id)
    dto.down_up()  # 다운로드 수 증가
    dto.save()
    count = dto.down  #다운로드 수 
    print('count : ' ,count )

    return JsonResponse({'idx' : id, 'count' : count})


def download(request):
    id=request.GET['idx']
    dto=Board.objects.get(idx=id)
    path=UPLOAD_DIR+dto.filename
    filename=urllib.parse.quote(dto.filename)


    with open(path, 'rb') as file:
        response=HttpResponse(file.read(),
                              contnet_type='application/octet-stream')
        response['Content-Disposition']="attachment;filename=UTF-8''{0}".format(filename)

    return response

# post타입일때는 csrf 어노테이션 써야함
@csrf_exempt
def comment_insert(request):
    id = request.POST['idx']

    cdto = Comment(
        board_idx =id,
        writer = 'aa',
        content = request.POST['content']
    )
    cdto.save()
    return redirect('/detail/'+id)
