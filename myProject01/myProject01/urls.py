"""myProject01 URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/3.2/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path
from myapp01 import views

urlpatterns = [
    path('admin/', admin.site.urls),
    path('', views.write_form),
     path('write_form/', views.write_form),
    path('insert/', views.insert),
    path('list/', views.list),
    path('detail_idx/', views.detail_idx),
    path('detail/<int:board_idx>/', views.detail),
    path('delete/<int:board_idx>', views.delete),
    path('delete_idx/', views.delete_idx),
    path('update_form/<int:board_idx>', views.update_form),
    path('update/', views.update),
    path('download_count/',views.download_count),
    path('comment_insert/',views.comment_insert)
    
]
