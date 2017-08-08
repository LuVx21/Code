# -*- coding:utf-8 -*-
from datetime import date
import datetime


str1 = datetime.date(1992, 10, 21)
str2 = datetime.datetime(2007, 12, 31, 23, 59, 59)

str3 = datetime.datetime.now()

print(str1, str2, str3)
now = date.today()

print(now)
print(now.strftime("%M-%d-%Y. %d %b %Y is a %A on the %d day of %B."))
print(now - str1)