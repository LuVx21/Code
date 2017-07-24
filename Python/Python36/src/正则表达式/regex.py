# coding=utf-8

import re

string = 'aaabbbabb zz abbaabb abb aabb babb zz'
length = len(string)

# a或b出现出现>=0次的,以abb结束的字符串
# compile 函数根据一个模式字符串和可选的标志参数生成一个正则表达式对象。该对象拥有一系列方法用于正则表达式匹配和替换。
pattern = re.compile('[a|b]*abb')

# re.findall: 返回所有匹配搜索模式的字符串组成的列表；
print(pattern.findall(string))

print('---------------------------------------------------------------')
# re.search(string[, pos[, endpos]]):
# 搜索字符串直到找到匹配模式的字符串，然后返回一个re.MatchObject对象，否则返回None；
obj1 = pattern.search(string, 11, length)
print(obj1)
print(obj1.group())
print(obj1.groups())

print('---------------------------------------------------------------')
# re.match(string[, pos[, endpos]]):
# 如果从头开始的一段字符匹配搜索模式，返回re.MatchObject对象，否则返回None。
obj2 = pattern.match(string)
print(obj2)
print(obj2.group())
print(obj2.groups())

print('---------------------------------------------------------------')
# re.sub(repl, string, count=0): 返回repl替换pattern后的字符串。
print(pattern.sub('renxie', string, 2))

print('---------------------------------------------------------------')
# re.split: 在pattern出现的地方分割字符串。
print(pattern.split(string, 2))
