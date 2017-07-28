# -*- coding:utf-8 -*-
import cx_Oracle
from conf import *
# http://blog.csdn.net/kongxx/article/details/7107661 
# 链接方式1
conn = cx_Oracle.connect(usename, password, link)

# # 链接方式2
# conn1 = cx_Oracle.connect(link2)

# # 链接方式3
# dsn_tns = cx_Oracle.makedsn(ip, port, dbname)
# conn2 = cx_Oracle.connect(usename, password, dsn_tns)

# print(conn.version)
# print(conn.dsn)

cursor = conn.cursor()
cursor.execute("select * from tc01080")
row = cursor.fetchone()
print(row)

for i in range(len(row)):
	print(row[i])

cursor.close()
conn.close()
