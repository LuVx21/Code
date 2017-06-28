# coding=utf-8

import xlrd
from xlutils.copy import copy

# xlutils结合xlrd可以达到修改excel文件目的

workbook = xlrd.open_workbook(u'1.xlsx')
workbooknew = copy(workbook)
ws = workbooknew.get_sheet(0)
ws.write(2, 0, 'changed!')
workbooknew.save(u'3.xls')