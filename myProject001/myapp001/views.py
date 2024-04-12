from django.shortcuts import render
from django.views.decorators.csrf import csrf_exempt
from myapp001.models import Board


UPLOAD_DIR= 'C:\\Users\\it\\Desktop\\work\\after_4_month\\upload\\'



def write_form(request):
    return render(request, 'board/write.html')

#insert 추가
@csrf_exempt
def insert(request):
    fname=''
    fsize=0
    if 'file' in request.FILES:
        file= request.FILES['file']
        fname=file.name
        fsize= file.size

        fp=open('%s%s' %(UPLOAD_DIR, fname),'wb')

        for chunk in file.chunks():
            fp.write(chunk)
        fp.close()

    dto=Board(writer = request.POST['writer'],
              title = request.POST['title'],
              content = request.POST['content'],
              filename= fname,
              filesize= fsize
              )
    dto.save()
    return render(request, 'board/write.html')
    # print(request.POST['writer'])
    # return render(request,'board/write.html')


    
#list 전체 보기
def list(request):
    boardList=Board.objects.all()
    context={'boardlist' : boardList}


    return render(request, 'board/list.html', context)