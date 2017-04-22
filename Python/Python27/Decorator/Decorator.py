# coding=utf-8
from Utils.Utils import *


def A(D):
    def C(arg1, arg2):
        print "I got args! Look:", arg1, arg2
        D(arg1, arg2)
    return C


@A
def B(first_name, last_name):
    print "My name is", first_name, last_name
B("Peter", "Venkman")


print '---------------------------------'


def AA(CC):
    def wrapper(self, lie):
        return CC(self, lie)
    return wrapper

def AAA(BBB):
    """通用的装饰器，可以用于所有的方法或者函数，而不用考虑参数情况"""
    def CCC(*args, **kwargs):
        print "Do I have args?:"
        print args
        print kwargs
        BBB(*args, **kwargs)
    return CCC

class Lucy(object):

    def __init__(self):
        self.age = 32

    @AAA
    def BB(self, lie):
        print "I am %s, what did you think?" % (self.age + lie)
l = Lucy()
l.BB(-3)

print '---------------------------------'


