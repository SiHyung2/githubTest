from django.http import JsonResponse, HttpResponse
from django.shortcuts import redirect, render
from django.views.decorators.csrf import csrf_exempt
from myapp02.models import Board
import urllib.parse

# def base(request):
#     return render(request, 'base.html')

UPLOAD_DIR = 'C:/Users/it/Desktop/work/after_4_month/upload2/'


def write_form(request):
    return render(request, 'board/insert.html')

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
    return redirect('/list')


def list(request):
    startpage=1
    endpage=5
    boardCount=Board.objects.all().count()
    boardList=Board.objects.all().order_by('-idx')

    context={'boardList' : boardList,
             'boardCount' : boardCount,
             'range' : range(startpage, endpage-1)
             }    #range쓰려면 render로 range를 넘겨야한다

    return render(request, 'board/list.html', context)

def detail(request, board_idx):
    # boardList=Board.objects.all().order_by('-idx')
    # context={'boardList' : boardList}  
    
    dto=Board.objects.get(idx=board_idx)
    dto.hit_up()
    dto.save()

    return render(request, 'board/detail.html', {'dto' : dto})
    

# 다운로드 카운트증가
def download_count(request):
    id = request.GET['id']
    dto = Board.objects.get(id=id)
    dto.down_up() # 다운로드 수 증가
    dto.save()

    count =dto.down  # 다운로드 수
    print('id : ', id)
    return JsonResponse ({'id' : id, 'count':count})


# def download_count2(request):
#     id = request.GET['id']
#     dto = Board.objects.get(idx=id)
#     dto.down_up()  # 다운로드 수 증가
#     dto.save()
#     count = dto.down  #다운로드 수 
#     print('count : ' ,count )

#     return JsonResponse({'idx' : id, 'count' : count})

# 다운로드
def download(request):
    id = request.GET['id']
    dto = Board.objects.get(id=id)
    path = UPLOAD_DIR + dto.filename
    
    filename = urllib.parse.quote(dto.filename)

    with open(path, 'rb') as file:
        response = HttpResponse(file.read(),
                                content_type='application/octet-stream')
        response['Content-Disposition']="attachment;filename*=UTF-8''{0}".format(filename)    

    return  response