#!/usr/bin/python3
# -*- coding:utf-8 -*-
import xlwt
from openpyxl import load_workbook
from openpyxl import Workbook

def writer(colnum=0, rownum=0, rows=None, sheet=None):
    """
    查询结果写入新建excel中
    :param colnum: 起点列
    :param rownum: 起点行
    :param rows: 查询结果
    :param sheet: 写入excel对象的sheet
    :return:
    """
    colnumtmp = colnum
    for row in rows:
        for item in row:
            sheet.write(rownum, colnum, item)
            colnum = colnum + 1
        colnum = colnumtmp
        rownum = rownum + 1

def writer1(colnum=0, rownum=0, rows=None, sheet=None):
    """
    查询结果写入给定excel中
    :param colnum: 起点列
    :param rownum: 起点行
    :param rows: 查询结果
    :param sheet: 写入excel对象的sheet
    :return:
    """
    colnum = colnum + 64
    colnumtmp = colnum
    for row in rows:
        for item in row:
            location = chr(colnum) + str(rownum)
            sheet[location] = item
            colnum = colnum + 1
        colnum = colnumtmp
        rownum = rownum + 1
