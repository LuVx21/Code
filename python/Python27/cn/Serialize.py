# coding=utf-8

try:
    import cPickle as pickle
except ImportError:
    import pickle

# dumps(Object)将对象序列化
a = dict(name='Bob', age=20, score=88)
b = pickle.dumps(a)
print b
# loads(String)原样恢复
c = pickle.loads(b)
print c
# ------------------------------------------------------------------------
# dump(Object,file)将对象存储到文件中序列化
a = dict(name='Bob', age=24, score=88)
f1 = file('test.txt', 'wb')
b = pickle.dump(a, f1, True)
f1.close()
print b

# load()恢复
f2 = file('test.txt', 'rb')
c = pickle.load(f2)
f2.close()
print c
# ------------------------------------------------------------------------

# JSON
import json

b = json.dumps(a)  # 把Python对象变成一个JSON
print b
print json.loads(b)  # 把JSON反序列化为Python对象，用loads()或者对应的load()方法.反序列化得到的所有字符串对象默认都是unicode而不是str
