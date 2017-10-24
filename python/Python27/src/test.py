# coding=UTF-8

from Utils.Utils import *

"""
var = 4
if var < 5:
    print '<5'
if var > 3:
    print '>3'


# 又满足则不会执行
if var < 5:
    print '<5'
elif var > 3:
    print '>3'
else:
    print '晚上'
    
    
# 集合(set)
a = set('asdfghdd')
b = set('zxdfvb')
print a & b  # 交集
print a | b  # 并集
print a - b  # 差集
print set(a)  # 去除重复元素


classmates = ['Michael', 'Bob', 'Tracy']
classmates.append('Adam')  # list是一个可变的有序表，可以往list中追加元素到末尾
print classmates[-1]  # 可以用-1做索引，直接获取最后一个元素
classmates.insert(1, 'Jack')  # 把元素插入到指定的位置，比如索引号为1的位置
classmates.pop(1)  # 要删除指定位置的元素，用pop(i)方法，其中i是索引位置

def reversed_cmp(x, y):
    # 反序排序(通常规定，对于两个元素x和y，如果认为x < y，则返回-1，如果认为x == y，则返回0，如果认为x > y，则返回1，这样，排序算法就不用关心具体的比较过程，而是根据比较结果直接排序)
    if x > y:
        return -1
    if x < y:
        return 1
    return 0

s = sorted(classmates, reversed_cmp)  # 排序sorted()函数是一个高阶函数，它还可以接收一个比较函数来实现自定义的排序
print s

# 列表过滤介绍
[elem for elem in s if elem != "Bob"]  # 过滤掉特殊值Bob，每次Bob出来过滤表达式都不成立
[elem for elem in s if s.count(elem) == 1]  # 过滤出出现一次的元素
print '----------------------------------------------'

# 切片
l = range(0, 100)  # 创建2-99的数列
# [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
print l[3:6]
print l[:6]  # 从下标0开始
print l[-5:-1]  # -1表示最后一个元素
print l[:10:2]  # 前10个数，每两个取一个
print l[::10]  # 每10个数取一个

#迭代
d = {'a': 1, 'b': 2, 'c': 3}
print d.itervalues()
for v in d.itervalues():               #迭代value
    print v

from collections import Iterable       #通过collections模块的Iterable类型判断一个对象是否可迭代
print isinstance('abc', Iterable)      # str是否可迭代
print isinstance([1,2,3], Iterable)    # list是否可迭代
print isinstance(123, Iterable)        # 整数是否可迭代


for i, value in enumerate(['A', 'B', 'C']):
    print i, value

# 定义类并创建实例
class Person(object):
    # 按照 Python 的编程习惯，类名以大写字母开头，紧接着是(object)，表示该类是从哪个类继承下来的
    pass
    print 'class'

p1 = Person()  # 有了Person类的定义，就可以创建出具体的p1,p2实例。创建实例语法 :类名()
p1.name = 'Bart'  # 由于Python是动态语言，对每一个实例，都可以直接给他们的属性赋值 
p1.gender = 'Male'

p2 = Person()
p2.name = 'Adam'
p2.age = 6

p3 = Person()
p3.name = 'Lisa'
p3.money = 454545

L1 = [p1, p2, p3]  # 创建包含两个Person类的实例的list
L2 = sorted(L1, lambda p1, p2: cmp(p1.name, p2.name))  # sorted() 是高阶函数，接受一个比较函数按照name进行排序。

print L2[0].name
print L2[1].name
print L2[2].name

class Student(object):

    def __init__(self, name, score):  # 初始化使用__init__() 方法的第一个参数必须是 self，后续参数则可以自由指定，和定义函数没有任何区别。相应地，创建实例时，就必须要提供除 self 以外的参数
        self.name = name                        
        self.score = score

    def print_score(self):  # 直接在Student类的内部定义访问数据的函数，实现数据封装。这些封装数据的函数是和Student类本身是关联起来的，我们称之为类的方法
        print '%s: %s' % (self.name, self.score)

    def get_grade(self):  # 封装的另一个好处是可以给Student类增加新的方法.可以直接在实例变量上调用，不需要知道内部实现细节
        if self.score >= 90:
            return 'A'
        elif self.score >= 60:
            return 'B'
        else:
            return 'C'

s = Student('Zhang', 100)
s.print_score()
print s.get_grade()

class Student(object):
    def __init__(self, name, score):
        self.__name = name  # 访问限制：如果一个属性由双下划线开头(__)，该属性就是private变量.但是，如果一个属性以"__xxx__"的形式定义，那它又可以被外部访问了
        self.__score = score

    def get_name(self):  # 如果外部代码要修改或获取私有变量可以使用set,get方法
        return self.__name

    def get_score(self):
        return self.__score

    def set_score(self, score):  # 可以对参数做检查，避免传入无效的参数
        if 0 <= score <= 100:
            self.__score = score
        else:
            raise ValueError('bad score')


s = Student('Zhang', 100)
s.set_score(90)
print s.get_name()
print s.get_score()

class Student(object):
    __slots__ = ('name', 'age', 'set_age')  # __slots__是指一个类允许的属性列表

    def __init__(self, name):
        self.name = name

    def __str__(self):
        # print内置特殊方法，默认 print s 返回地址（还有__len__,__cmp__等）
        # 类似于java中tostring方法,返回的是一个地址,可以根据需要重写
        return '(name:%s,age:%s)' % (self.name, self.age)


s = Student('Zhang')
s.age = 18  # 动态给实例绑定一个属性
print s  # 自动调用s.__str__()方法


def set_age(self, age):  # 定义一个外部函数作为实例方法
    self.age = age


from types import MethodType

s.set_age = MethodType(set_age, s, Student)  # MethodType给该实例绑定一个方法
# Student.set_age = MethodType(set_age, None, Student)      #给所有实例绑定一个方法
s.set_age(25)  # 调用实例方法
print s.age
"""
"""
# 定义函数
def temp_convert(var):
    try:
        return int(var)
    except ValueError, Argument:
        print "参数没有包含数字\n", Argument

# 调用函数
temp_convert("xyz");

def fib_direct(n):
    assert n > 0, 'n需要大于0'
    if n < 3:
        return n
    else:
        return fib_direct(n - 1) + fib_direct(n - 2)
"""
