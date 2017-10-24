# coding=utf-8

import xlwt

# xlwt主要是用来写excel文件

wbk = xlwt.Workbook()
sheet = wbk.add_sheet('sheet3')
#B2处写入内容
sheet.write(0,1,'B2')
wbk.save('2.xls')