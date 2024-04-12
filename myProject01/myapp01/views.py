from django.shortcuts import render
from django.views.decorators.csrf import csrf_exempt
from myapp01.models import Board

# Create your views here.

UPLOAD_DIR = 'D:/__2024JUNG/DjangoWork/upload/'

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
    return render(request, 'board/write.html')