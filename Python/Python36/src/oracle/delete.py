# -*- coding:utf-8 -*-
import cx_Oracle
from conf import *

conn = cx_Oracle.connect(usename, password, link)
cursor = conn.cursor()

cursor.execute("delete from test where id = 3")
conn.commit()

cursor.close()
conn.close()
