#-*- coding:utf-8 -*-
import json

# json.dumps():将 Python 对象编码成 JSON 字符串

dict = {'b': 789, 'c': 456, 'a': 123}
d1 = json.dumps(dict, sort_keys=True, indent=4, separators=(',', ':'))
print(d1)


# json.loads():将已编码的 JSON 字符串解码为 Python 对象

s = json.loads('{"name":"test", "type":{"name":"seq", "parameter":["1", "2"]}}')

print(s)
print(s.keys())
print(s["name"])
print(s["type"]["name"])
print(s["type"]["parameter"][1])