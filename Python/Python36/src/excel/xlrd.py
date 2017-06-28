# coding=utf-8

# xlrd xlwt xlutils openpyxl xlsxwriter

import xlrd

workbook = xlrd.open_workbook('1.xlsx')

sheet_names = workbook.sheet_names()
print(sheet_names)

# 通过索引顺序获取
# sheet = workbook.sheets()[0]

# #通过索引顺序获取
sheet = workbook.sheet_by_index(0)

# #通过名称获取
# sheet = workbook.sheet_by_name(u'Sheet1')

# A1	B1
# A2	B2
# 000A3	000B3

name1 = sheet.name
nrows = sheet.nrows
ncols = sheet.ncols

print(name1,nrows,ncols)
# 获取整行和整列的值
# 按行遍历
for i in range(nrows):
    print(sheet.row_values(i))

# 按列遍历
for i in range(ncols):
    print(sheet.col_values(i))

cell_A1 = sheet.cell(0,0).value
cell_B2 = sheet.cell(1,1).value
print(cell_A1,cell_B2)

cell_A1_1 = sheet.row(0)[0].value
cell_B2_1 = sheet.col(1)[1].value
print(cell_A1_1,cell_B2_1)

# 写入
row = 0
col = 0

# 单元格数据类型
# 0 empty
# 1 string
# 2 number
# 3 date
# 4 boolean
# 5 error
ctype = 1
value = 'XXXX'
xf = 0 # 扩展的格式化

sheet.put_cell(row, col, ctype, value, xf)

print(sheet.cell(0,0))
print(sheet.cell_type(0,0))
print(sheet.cell(0,0).value)