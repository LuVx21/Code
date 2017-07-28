# -*- coding:utf-8 -*-

import cx_Oracle

ip = '10.213.79.226'
port = '1521'
host = ip + ':' + port

dbname = 'MX77'
usename = 'Z_YBWANG'
password = 'MX77'

link = host + '/' + dbname
link2 = usename + '/' + password + '@' + link