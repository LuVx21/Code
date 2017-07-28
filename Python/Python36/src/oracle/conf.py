# -*- coding:utf-8 -*-

import cx_Oracle

ip = '127.0.0.1'
port = '1521'
host = ip + ':' + port

dbname = 'XE'
usename = 'scott'
password = '1121'

link = host + '/' + dbname
link2 = usename + '/' + password + '@' + link