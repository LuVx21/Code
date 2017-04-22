# coding=utf-8

def printLine():
    """打印一条分割线"""
    print('----------------分割线----------------')


def typeof(obj):
    """对象的数据类型"""
    print(type(obj))



"""
def add(a,b):
	z = a + b
	return z
res = add(3,7)
print res
"""
"""
def print_num():
	print num
num = 11
print_num()
print num
"""
"""
def pf_num():
	global num
	print num # 13
	num = 12
	print num #12
num = 13
pf_num()
print num #12
"""
"""
a = 5
b = 2
print a and b #2
print b and a #5
print a or b #5
print b or a #2
"""
"""
a = 5
b = 2
if (a>b):
	print a
elif a == b:
	print a==b
else:
	print b
"""
"""
count = 0
while count < 5:
	print (count,'is less than 5')
	count = count + 1
else:
	print (count,'is not less than 5')
"""
"""
for letter in 'Python':
	print letter
fruits = ['apple','banana','cat','dog']
for i in fruits:
	print i
"""
"""
from functools import reduce
import operator
str = ['hello','world','renxie','LuVx']
result = reduce(operator.add,str,'')
print result
"""
"""
word = 'renxieLuVx'
print word[0:5:1]   #renxi index=01234
print word[0:5:2]	#rni index=024
print word[0:5:3]	#rx index=03
print word[0:5:4]	#ri index=04
print word[0:5:5]	#r index=0
"""
"""
str1 = 'hello world!!'
print str1[0:3]
print str1[::2]
print str1[1::2]
"""
"""
sentence1 = 'qwertyui op,asadd,asd,fghjk lzxcvbnm'
print sentence1.split()
print sentence1.split(',',2)


sentence = "xinxingzhao said: 1, 2, 3, 4"
print sentence.split()
print sentence.split(",")
print sentence.split(",", 2)
"""
"""
str = 'aasa'
print id(str)
print id(str+'as')
"""
"""
import types
class UserInt(int):
    def __init__(self, val=0):
        self.val = int(val)
        print int
        print self
        print int(val)
        print self.val

i = 1
n = UserInt(2)
#print type(i) is type(n)
"""
'''
def calc(n1, n2):
    return n1 + n2, n1 * n2

add, sub = calc(5, 1)
print type(calc(5,1)) # tuple
print add, sub  # 6 4
'''
'''
aTuple = ('A','B','C')
a,b,c=aTuple
print a,b,c
'''
'''
def change(aList):
	"change"
	aList.append([1,2,3,4])
	print aList

aList = ['a','b','c']
change(aList)
print aList
'''
'''
def function(name='renxie',age=24):
	print name,age

function(age=50,name='renxie')
function(name='renxie')
function(age=28)
'''
'''
def funcation0(arg1, *vartuple):
	print 'result:'
	print arg1
	print '-----'
	print type(vartuple)
	print vartuple

funcation0(30,20,40,50)
funcation0('aa',20,40,50)

def funcation1(arg1, **vartuple):
	print 'result:'
	print arg1
	print '-----'
	print type(vartuple)
	print vartuple

funcation1('aa',x=12,y=34)
'''
'''
sum = lambda arg1,arg2:arg1 + arg2
print(sum(30,22))
print(type(sum))
'''
'''
a, b = 0, 1
while b < 1000:
    print(b, end=',')
    a, b = b, a + b
'''