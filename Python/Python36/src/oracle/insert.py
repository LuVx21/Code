# -*- coding:utf-8 -*-
import cx_Oracle
from conf import *

conn = cx_Oracle.connect(usename, password, link)
cursor = conn.cursor()

cursor.execute('drop table test')
cursor.execute("create table test(id int, col1 varchar(32), col2 varchar(32), col3 varchar(32))")

cursor.execute("insert into test (id, col1, col2, col3)values(1, 'a', 'b', 'c')")
cursor.execute("insert into test (id, col1, col2, col3)values(2, 'aa', 'bb', 'cc')")
cursor.execute("insert into test (id, col1, col2, col3)values(3, 'aaa', 'bbb', 'ccc')")
conn.commit()

cursor.close()
conn.close()