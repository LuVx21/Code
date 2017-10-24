# coding=utf-8


from Utils.Utils import *


# Dict相关
dic = {'a': 'A', 'b': 'B'}

print(dic.get('ab', 'renxie'))  # 如果没get到就返回自己赋予的值',
print(dic.get('ab'))  # 如果没get到就返回自己赋予的值',
print('------------------------------')
dic.setdefault('c', 'C')  # 添加键值对
print(dic)
dic.pop('c')  # 删除键值对
print(dic)
print('------------------------------')

# set相关
aSet = set([5, 1, 6, 1, 3, 6, 3])

print(aSet)  # 自动去重复
aSet.add(12)  # 添加
print(aSet)
aSet.remove(12)  # 删除
print(aSet)

print('------------------------------')


# 函数相关
def func(x):
    # 绝对值,自带类型校验
    if not isinstance(x, (int, float)):
        raise TypeError('bad type')
    if x >= 0:
        return x
    else:
        return -x


print(func(-8))


def reverse(x, y):
    return y, x


print(reverse(3, 4))

print('------------------------------')


def people(name, age, **kw):
    print('name:', name, 'age:', age, 'other:', kw)


# 关键字参数,被封装为dict
people('Bob', 35, city='ShangHai')

# *args是可变参数，args接收的是一个tuple
# **kw是关键字参数，kw接收的是一个dict

a, b = 0, 1
while b < 100000:
    print(b, end='')
    a, b = b, a + b


printLine()
printLine()


for n in range(2, 10):
    for i in range(2, n):
        if n % i == 0:
            print('chujin' + str(n) + str(i))
            break
    else:
        print('buchujin' + str(n))

