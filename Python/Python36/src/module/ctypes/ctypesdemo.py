# -*- coding:utf-8 -*-
import ctypes
import os
import commands

# http://blog.csdn.net/taiyang1987912/article/details/44779719
'''
# Python调用C动态链接库
ll = ctypes.cdll.LoadLibrary
lib = ll("/Users/renxie/Code/Python/Python36/src/module/ctypes/libpycall.so")
result = lib.foo(1, 3)
print(result)
print('***finish***')

# Python调用C++(类)动态链接库 
so = ctypes.cdll.LoadLibrary
lib = so("/Users/renxie/Code/Python/Python36/src/module/ctypes/libpycallclass.so")
print('display()')
lib.display()
print('display(100)')
lib.display_int(100)
'''

# Python调用C/C++可执行程序
main = "/Users/renxie/Code/Python/Python36/src/module/ctypes/testmain"

if os.path.exists(main):
    rc, out = commands.getstatusoutput(main)
    print('rc = %d, \nout = %s' % (rc, out))

print('*' * 10)

f = os.popen(main)
data = f.readlines()
f.close()

print(data)

print('*' * 10)

os.system(main)

