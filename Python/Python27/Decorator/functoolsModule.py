# coding=utf-8
from Utils.Utils import *

def bar(func):
    def wrapper():
        print "bar函数"
        return func()
    return wrapper


@bar
def foo():
    print "foo函数"

foo()
# print foo.__name__


print '-----------------------------------------------'
 
import functools
def bar(func):
    @functools.wraps(func)
    def wrapper():
        print "bar函数"
        return func()
    return wrapper
  
  
 
@bar
def foo():
    print "foo函数"
    
foo()
# print foo.__name__
