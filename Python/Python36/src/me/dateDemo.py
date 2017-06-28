# coding=utf-8

import datetime
from datetime import date

# 获取今天日期
today = date.today()

# 今天星期几
todayWeekday = today.weekday() + 1

if todayWeekday == 1:
	today = today - datetime.timedelta(days = 3)


# 格式化日期
todayFormat = today.strftime("%Y/%m/%d")

print(todayFormat)