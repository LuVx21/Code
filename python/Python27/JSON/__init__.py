# coding=utf-8


import demjson


# encode() 函数用于将 Python 对象编码成 JSON 字符串
data = [{'a': 1, 'b': 2, 'c': 3, 'd': 4, 'e': 5}]

json = demjson.encode(data)
print json

# decode() 函数解码 JSON 数据。该函数返回 Python 字段的数据类型。
json = '{"a":1,"b":2,"c":3,"d":4,"e":5}'

text = demjson.decode(json)
print text
