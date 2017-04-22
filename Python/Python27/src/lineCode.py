# coding=UTF-8
'''
Created on 2016/10/03

@author: rxie
'''
# 一颗心
print'\n'.join([''.join([('RenXieLove'[(x - y) % 8] if ((x * 0.05) ** 2 + (y * 0.1) ** 2 - 1) ** 3 - (x * 0.05) ** 2 * (
    y * 0.1) ** 3 <= 0 else' ')
    for x in range(-30, 30)]) for y in range(15, -15, -1)])
# 乘法表
print'\n'.join([' '.join(['%s*%s=%-2s' % (y, x, x * y) for y in range(1, x + 1)]) for x in range(1, 10)])


# 函数实现乘法表
def func():
    for x in range(1, 10):
        for y in range(1, x + 1):
            print ''.join('%s*%s=%-2s' % (y, x, x * y)),
            # print '\n'.join(' '.join('%s*%s=%-2s' % (y, x, x * y)))
        print ''


func()
# 1-1000之间的素数
# print (*(i for i in range(2, 1000) if all(tuple(i%j for j in range(2, int(i**.5))))))

# 前100项斐波那契数列
print [x[0] for x in [(a[i][0], a.append((a[i][1], a[i][0] + a[i][1]))) for a in ([[1, 1]],) for i in xrange(100)]]
# 阶乘,交互
print reduce(lambda x, y: x * y, range(1, input() + 1))
# 摄氏度与华氏度转换
print((lambda i: i not in [1, 2] and "Invalid input!" or i == 1 and (lambda f: f < -459.67 and "Invalid input!" or f)(
    float(input("Please input a Celsius temperature:")) * 1.8 + 32) or i == 2 and (
    lambda c: c < -273.15 and "Invalid input!" or c)((float(input("Please input a Fahrenheit temperature:")) - 32) / 1.8))(
    int(input("1,Celsius to Fahrenheit\n2,Fahrenheit to Celsius\nPlease input 1 or 2\n"))))
# 字符串排序和快速排序
# print ''.join((lambda x:(x.sort(),x)[1])(list(‘string’)))
qsort = lambda arr: len(arr) > 1 and qsort(filter(lambda x: x <= arr[0], arr[1:])) + arr[0:1] + qsort(
    filter(lambda x: x > arr[0], arr[1:])) or arr


# 猜数字游戏
def guess_my_number(n):
    while True:
        user_input = raw_input("Enter a positive integer to guess: ")
        if len(user_input) == 0 or not user_input.isdigit():
            print "Not a positive integer!"
        else:
            user_input = int(user_input)
            if user_input > n:
                print "Too big ! Try again!"
            elif user_input < n:
                print "Too small ! Try again!"
            else:
                print "You win!"
                return True


guess_my_number(42)

# 取一个列表里的随机数
import random as rnd

print rnd.choice([2, 3, 5, 7, 11, 13, 17])
# 转换为1行
print (lambda rnd: rnd.choice([1, 2, 3, 10]))(__import__('random'))
