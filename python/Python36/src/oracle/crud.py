# -*- coding:utf-8 -*-
import cx_Oracle
from conf import *
from utils import *

# API
# http://cx-oracle.readthedocs.io/en/latest/

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

# ---------------------------------------------------------------------------
cursor.execute('drop table test')
cursor.execute("create table test(id int, col1 varchar(32), col2 varchar(32), col3 varchar(32))")

cursor.execute("insert into test (id, col1, col2, col3)values(1, 'a', 'b', 'c')")
cursor.execute("insert into test (id, col1, col2, col3)values(2, 'aa', 'bb', 'cc')")
cursor.execute("insert into test (id, col1, col2, col3)values(3, 'aaa', 'bbb', 'ccc')")
conn.commit()
printall(cursor.execute("select * from test").fetchall())
# ---------------------------------------------------------------------------
cursor.execute("delete from test where id = 3")
conn.commit()
printall(cursor.execute("select * from test").fetchall())
# ---------------------------------------------------------------------------
cursor.execute("update test set COL1 = 'bbb' where id = 2")
conn.commit()
printall(cursor.execute("select * from test").fetchall())
# ---------------------------------------------------------------------------
cursor.execute('select * from emp where empno > 7844')
rows2 = cursor.fetchall()
printall(rows2)

# pr = {'empno': 7566, 'sal': 2000}
# cursor.execute('select * from emp where empno > :empno and sal > :sal', pr)
cursor.execute('select * from emp where empno > :empno and sal > :sal', empno = 7566, sal = 2000)
rows3 = cursor.fetchall()
printall(rows3)

cursor.execute("select * from emp where empno > '%s' and sal > '%d'" % (7566, 2000))
# rows4 = cursor.fetchall()
rows4 = cursor.fetchmany(2)
printall(rows4)

cursor.close()
conn.close()