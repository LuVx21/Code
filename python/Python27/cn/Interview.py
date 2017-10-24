# coding=UTF-8
# Interview questions


class Parent(object):
    x = 1


class Child1(Parent):
    pass


class Child2(Parent):
    pass

print Parent.x, Child1.x, Child2.x  # 1 1 1

Child1.x = 2
print Parent.x, Child1.x, Child2.x  # 1 2 1

Parent.x = 3
print Parent.x, Child1.x, Child2.x  # 3 2 3

print '----------------------------------------------------'


def div1(x, y):
    print("%s/%s = %s" % (x, y, x / y))


def div2(x, y):
    print("%s//%s = %s" % (x, y, x // y))

div1(5, 2)
div1(5., 2)
div2(5, 2)
div2(5., 2.)

print '----------------------------------------------------'
list = ['a', 'b', 'c', 'd', 'e']
print list[10:]  # 试图访问一个列表的以超出列表成员数作为开始索引的切片将不会导致 IndexError，并且将仅仅返回一个空列表
print '----------------------------------------------------'


def multipliers():
    return [lambda x: i * x for i in range(4)]

print [m(2) for m in multipliers()]
"""
 Python 的闭包的后期绑定导致的 late binding，这意味着在闭包中的变量是在内部函数被调用的时候被查找。所以结果是，当任何 multipliers() 返回的函数被调用，在那时，i 的值是在它被调用时的周围作用域中查找，到那时，无论哪个返回的函数被调用，for 循环都已经完成了，i 最后的值是 3，因此，每个返回的函数 multiplies 的值都是 3。因此一个等于 2 的值被传递进以上代码，它们将返回一个值 6 （比如： 3 x 2）。

（顺便说下，正如在 The Hitchhiker’s Guide to Python 中指出的，这里有一点普遍的误解，是关于 lambda 表达式的一些东西。一个 lambda 表达式创建的函数不是特殊的，和使用一个普通的 def 创建的函数展示的表现是一样的。）

这里有两种方法解决这个问题。

最普遍的解决方案是创建一个闭包，通过使用默认参数立即绑定它的参数。例如：

def multipliers():
    return [lambda x, i=i : i * x for i in range(4)]

另外一个选择是，你可以使用 functools.partial 函数：

from functools import partial
from operator import mul
 
def multipliers():
    return [partial(mul, i) for i in range(4)]
"""
print '----------------------------------------------------'


def extendList(val, list=[]):
    list.append(val)
    return list

list1 = extendList(10)
list2 = extendList(123, [])
list3 = extendList('a')

print "list1 = %s" % list1
print "list2 = %s" % list2
print "list3 = %s" % list3

"""
许多人会错误的认为 list1 应该等于 [10] 以及 list3 应该等于 ['a']。认为 list 的参数会在 extendList 每次被调用的时候会被设置成它的默认值 []。

尽管如此，实际发生的事情是，新的默认列表仅仅只在函数被定义时创建一次。随后当 extendList 没有被指定的列表参数调用的时候，其使用的是同一个列表。这就是为什么当函数被定义的时候，表达式是用默认参数被计算，而不是它被调用的时候。

因此，list1 和 list3 是操作的相同的列表。而 list2是操作的它创建的独立的列表（通过传递它自己的空列表作为list 参数的值）。

extendList 函数的定义可以做如下修改，但，当没有新的 list 参数被指定的时候，会总是开始一个新列表，这更加可能是一直期望的行为。

def extendList(val, list=None):
    if list is None:
        list = []
    list.append(val)
    return list

使用这个改进的实现，输出将是：

list1 = [10]
list2 = [123]
list3 = ['a']
"""
