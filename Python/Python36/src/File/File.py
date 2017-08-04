# coding=utf-8
import datetime
from datetime import date

# 获取今天日期
today = date.today()

# 今天星期几
todayWeekday = today.weekday() + 1

predays = 3 if todayWeekday == 1 else 1
preDay = today - datetime.timedelta(days=predays)

# 格式化日期
preDayFormat = preDay.strftime("%Y%m%d")
preDayFormat1 = preDay.strftime("%Y/%m/%d")
todayFormat = today.strftime("%Y/%m/%d")

filepath = u'S:\Code\Python\Python36\src\File\\template.txt'

with open(filepath, "r+", encoding='utf-8') as File:
    lines = File.read().splitlines()
    lines[4] = lines[4][:19] + preDayFormat + lines[4][27:]
    lines[8] = preDayFormat1 + lines[8][10:]
    lines[13] = todayFormat + lines[13][10:]
    lines[20] = lines[20][:9] + todayFormat[5:]
    File.seek(0, 0)
    for line in lines:
        File.write(line + '\n')
    print('OK!')