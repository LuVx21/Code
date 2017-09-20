# -*- coding: utf-8 -*-

'''
insert.sum方法的类,
insert实现<string,int>键值对插入,key相同则覆盖
sum求以指定字符串开头的键的值的和
'''

class MapSum:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.datadict = {}

    def insert(self, key, val):
        """
        :type key: str
        :type val: int
        :rtype: void
        """
        self.datadict[key] = val

    def sum(self, prefix):
        """
        :type prefix: str
        :rtype: int
        """
        return sum(val for key, val in self.datadict.items() if str(key).startswith(prefix))

obj = MapSum()
obj.insert('a', 1)
obj.insert('bb', 2)
obj.insert('aaa', 4)
obj.insert(121, 4)
param_2 = obj.sum('a')
print(param_2)

