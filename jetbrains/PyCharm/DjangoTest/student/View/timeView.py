# coding=utf-8

from django.http import HttpResponse
import datetime


def current_datetime(request):
    # 计算当前日期和时间，并以 datetime.datetime 对象的形式保存为局部变量 now
    now = datetime.datetime.now()

    # 构建Html响应，使用now替换占位符%s
    html = "<html><body>It is now %s.</body></html>" % now

    # 返回一个包含所生成响应的HttpResponse对象
    return HttpResponse(html)


def hours_ahead(request, offset):
    offset = int(offset)
    dt = datetime.datetime.now() + datetime.timedelta(hours=offset)
    html = "<html><body>In %s hour(s), it will be %s.</body></html>" % (offset, dt)
    return HttpResponse(html)
