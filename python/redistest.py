# -*- coding:utf-8 -*-
import redis

r = redis.Redis(host='localhost', port=6379,db=0)
r.set('name', 'zhangsan')
print(r.get('name'))


# http://www.cnblogs.com/melonjiang/p/5342383.html