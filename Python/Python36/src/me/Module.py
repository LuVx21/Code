# coding=utf-8

import sys
import math
import Utils.ModuleUtil
from Utils.ModuleUtil import typeOf, aLine

ModuleUtil = Utils.ModuleUtil

# sys.argv 是一个包含命令行参数的列表。
print(sys.argv)
# sys.path 包含了一个 Python 解释器自动查找所需模块的路径的列表。
print(sys.path)


typeOf(sys)

print(ModuleUtil.__name__)

# 每个模块都有一个__name__属性，当其值是'__main__'时，表明该模块自身在运行，否则是被引入
if __name__ == '__main__':
    print('yes')
else:
    print('No')

aLine()
# dir()函数
print(dir(ModuleUtil))
print(dir())
aLine()
# 输入与输出
# repr() 函数可以转义字符串中的特殊字符
# repr() 的参数可以是 Python 的任何对象
print(str('hello world\n'))
print(repr('hello world\n'))

# rjust()居右, ljust() 和 center(),参数表示填充后总长度
# zfill(),在数字的左边填充 0
for x in range(1, 3):
    print(repr(x).rjust(2, 'X'), repr(x * x).rjust(3, 'X'), end=' ')
    # 注意前一行 'end' 的使用
    print(repr(x * x * x).rjust(4, 'X'))

for x in range(1, 3):
    print('{0:2d} {1:3d} {2:4d}'.format(x, x * x, x * x * x))

print('{}网址:{}!'.format('菜鸟教程', 'www.runoob.com'))
print('{1}和 {0}'.format('Google', 'Runoob'))
print('{name}网址： {site}'.format(name='菜鸟教程', site='www.runoob.com'))
print('站点列表 {0}, {1}, 和 {other}'.format('Google', 'Runoob', other='Taobao'))
# '!a' (使用 ascii()), '!s' (使用 str()) 和 '!r' (使用 repr()) 可以用于在格式化某个值之前对其进行转化:
print('常量 PI 的值近似为 {}'.format(math.pi))
print('常量 PI 的值近似为 {!r}'.format(math.pi))
# 可选项 ':' 和格式标识符可以跟着字段名。 这就允许对值进行更好的格式化
print('常量 PI 的值近似为 {0:.3f}。'.format(math.pi))
# 在 ':' 后传入一个整数, 可以保证该域至少有这么多的宽度
print('{0:10} ==> {1:10d}'.format('name', 24))
print('{0:10} ==> {1:10d}'.format('renxie', 244))


table = {'Google': 1, 'Runoob': 2, 'Taobao': 3}
print(
    'Runoob:{0[Runoob]:d};Google:{0[Google]:d};Taobao:{0[Taobao]:d}'.format(table))
print('Runoob:{Runoob:d};Google:{Google:d};Taobao:{Taobao:d}'.format(**table))
print('常量 PI 的值近似为:%9.6f。' % math.pi)
