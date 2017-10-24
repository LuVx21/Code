# -*- coding:utf-8 -*-
import cx_Oracle
import os
from conf import *


def printall(array):
    """
    遍历数组
    :param array:
    :return:
    """
    print('-------------------------------------------')
    for i in range(len(array)):
        print(array[i])

def connectDB(db='XE'):
    if db == 'XE':
        connstr = LINK3
    else:
        connstr = LINK2 + '/' + db
    conn = cx_Oracle.connect(connstr)
    return conn