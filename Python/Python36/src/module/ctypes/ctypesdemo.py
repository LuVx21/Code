# -*- coding:utf-8 -*-

import ctypes

# http://blog.csdn.net/taiyang1987912/article/details/44779719

ll = ctypes.cdll.LoadLibrary
lib = ll("/Users/renxie/Code/Python/Python36/src/module/ctypes/libpycall.so")
lib.foo(1, 3)
print('***finish***')

so = ctypes.cdll.LoadLibrary
lib = so("/Users/renxie/Code/Python/Python36/src/module/ctypes/libpycallclass.so")
print('display()')
lib.display()
print('display(100)')
lib.display_int(100)