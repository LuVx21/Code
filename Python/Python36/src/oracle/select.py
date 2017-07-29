# -*- coding:utf-8 -*-
import cx_Oracle
from conf import *
from utils import *

# 链接方式1
conn = cx_Oracle.connect(USENAME, PASSWORD, LINK)
cursor = conn.cursor()

# # 链接方式2
# conn1 = cx_Oracle.connect(link2)

# # 链接方式3
# dsn_tns = cx_Oracle.makedsn(ip, port, dbname)
# conn2 = cx_Oracle.connect(usename, password, dsn_tns)

# print(conn.version)
# print(conn.dsn)

cursor.execute("select * from emp order by empno")

rows = cursor.fetchall()

printall(rows)

cursor.execute('select * from emp where empno > 7844')
rows2 = cursor.fetchall()
printall(rows2)

pr = {'empno': 7566, 'sal': 2000}
cursor.execute('select * from emp where empno > :empno and sal > :sal', pr)
rows3 = cursor.fetchall()
printall(rows3)

# pr = {'empno': 7566, 'sal': 2000}
cursor.execute("select * from emp where empno > '%s' and sal > '%d'" % (7566, 2000))
rows4 = cursor.fetchall()
printall(rows4)

cursor.close()
conn.close()
