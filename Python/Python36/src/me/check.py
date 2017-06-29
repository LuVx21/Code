# coding=utf-8

import datetime
from datetime import date

# 获取今天日期
today = date.today()

# 今天星期几
todayWeekday = today.weekday() + 1

if todayWeekday == 1:
    preDay = today - datetime.timedelta(days = 3)
else:
    preDay = today - datetime.timedelta(days = 1)

# 格式化日期
preDayFormat = preDay.strftime("%Y%m%d")
preDayFormat1 = preDay.strftime("%Y/%m/%d")
todayFormat = today.strftime("%Y/%m/%d")


# 文件操作
oldFilePath = '1.txt'
newFilePath = '2.txt'
oldFile = open(oldFilePath,"r")
newFile = open(newFilePath,"w")

str = oldFile.read()
newStr = str.format(preDayFormat,preDayFormat1,todayFormat)
newFile.seek(0,0)
newFile.write(newStr)

oldFile.close()
newFile.close()