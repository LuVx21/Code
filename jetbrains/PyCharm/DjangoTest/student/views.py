# coding=utf-8

from django.shortcuts import *

# from django.http.response import *
from django.http import HttpResponse
import datetime


def studentSayHello(request):
    s = 'this is student. <br> Hello World!I am RenXie'
    current_time = datetime.datetime.now()
    html = '<html><head></head><body><h1> %s </h1><p> %s </p></body></html>' % (s, current_time)
    return HttpResponse(html)


def showPython(request):
    index = 'Python.html'
    return render_to_response(index)


def showStudents(request):
    list = [{id: 1, 'name': 'Jack'}, {id: 2, 'name': 'Rose'}]
    index = 'student.html'
    return render_to_response(index, {'students': list})


def current_datetime(request):
    # 计算当前日期和时间，并以 datetime.datetime 对象的形式保存为局部变量 now
    now = datetime.datetime.now()

    # 构建Html响应，使用now替换占位符%s
    html = "<html><body>It is now %s.</body></html>" % now

    # 返回一个包含所生成响应的HttpResponse对象
    return HttpResponse(html)
