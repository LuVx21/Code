# coding=utf-8

from django.shortcuts import render

# from django.http.response import *
from django.http import HttpResponse
import datetime


def sayHello(request):
    s = 'This is app1'
    current_time = datetime.datetime.now()
    html = '<html><head></head><body><h1> %s </h1><p> %s </p></body></html>' % (s, current_time)
    return HttpResponse(html)
