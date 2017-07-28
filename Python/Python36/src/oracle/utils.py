# -*- coding:utf-8 -*-
import cx_Oracle
import os

def printall(array):
    """
    遍历数组
    :param array:
    :return:
    """
    print('-------------------------------------------')
    for i in range(len(array)):
        print(array[i])


def connectDB(dbname='test'):
    if dbname == 'test':
        connstr = 'scott/1121@127.0.0.1:1521/XE'
    db = cx_Oracle.connect(connstr)
    return db


def sqlSelect(sql, db):
    # include:select
    cr = db.cursor()
    cr.execute(sql)
    rs = cr.fetchall()
    cr.close()
    return rs


def sqlDML(sql, db):
    # include: insert,update,delete
    cr = db.cursor()
    cr.execute(sql)
    cr.close()
    db.commit()


def sqlDML2(sql, params, db):
    # execute dml with parameters
    cr = db.cursor()
    cr.execute(sql, params)
    cr.close()
    db.commit()


def sqlDDL(sql, db):
    # include: create
    cr = db.cursor()
    cr.execute(sql)
    cr.close()


if __name__ == '__main__':
    os.environ['NLS_LANG'] = 'SIMPLIFIED CHINESE_CHINA.UTF8'
    db = connectDB()
    print('fg')
    db.close()
