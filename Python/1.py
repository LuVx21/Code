# 特殊需求的迭代方式
colors = ['red', 'green', 'blue', 'yellow']

for i, color in enumerate(colors):
    print(i, '--->', color)

# python2中使用,3中items与此相同
# for k, v in d.iteritems():
#     print(k, '--->', v)


def fun():
    return sum(i for i, color in enumerate(colors) if i > 0)


print(fun())

print([color for i, color in enumerate(colors)])


# 节省内存的字符串拼接方式
names = ['raymond', 'rachel', 'matthew', 'roger']
print(', '.join(names))


# 类似于多变量赋值
p = 'vttalk', 'female', 30, 'python@qq.com'
name, gender, age, email = p


# pyhton中的三元运算符
print(1 if True else 0)  # a?x:y

# 链式比较
12 < 13 < 14  # 结果为True

# for/else语句
# else中的语句在for循环执行完后执行
for i in range(5):
    print(i)
else:
    print('OK')

# 生成器的使用实例


def fib(n):
    a, b = 0, 1
    while a < n:
        yield a
        a, b = b, a + b


print([i for i in fib(10)])

# 获取字典元素
print({'a': 1}.get('b', 'not in'))

# 想字典中添加元素
# 通过 key 分组的时候，不得不每次检查 key 是否已经存在于字典中。
data = [('foo', 10), ('bar', 20), ('foo', 39), ('bar', 49)]
#　第一种方式
# TODO
groups = {}
for (key, value) in data:
    groups.setdefault(key, []).append(value)
'''
# 第二种方式
from collections import defaultdict
groups = defaultdict(list)
for (key, value) in data:
    groups[key].append(value)
'''

# 构建字典对象的方式
numbers = [1, 2, 3]
my_dict = dict([(number, number * 2) for number in numbers])
print(my_dict)  # {1: 2, 2: 4, 3: 6}

# 字典推导式是python2.7新增的特性，可读性增强了很多，类似的还是列表推导式和集合推导式。
# 还可以指定过滤条件
my_dict = {number: number * 2 for number in numbers if number > 1}
print(my_dict)  # {2: 4, 3: 6}
