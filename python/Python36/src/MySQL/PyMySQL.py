#!/usr/bin/python3

import pymysql

# 打开数据库连接
connection = pymysql.connect("localhost", "root", "1121", "python")

# 使用 cursor() 方法创建一个游标对象 cursor
cursor = connection.cursor()

# 使用 execute()  方法执行 SQL 查询
cursor.execute("SELECT VERSION()")

# 使用 fetchone() 方法获取单条数据.
data = cursor.fetchone()
print("Database version : %s " % data)

'''复杂查询
# SQL 查询语句
sql = "select * from employee \
       where income > '%d'" % (1000)
try:
    # 执行SQL语句
    temp = cursor.execute(sql)
    # 获取所有记录列表
    results = cursor.fetchall()
    print("获取到%d条记录:" % temp)
    for row in results:
        fname = row[0]
        lname = row[1]
        age = row[2]
        sex = row[3]
        income = row[4]
        # 打印结果
        print("fname=%s,lname=%s,age=%d,sex=%s,income=%d" % \
              (fname, lname, age, sex, income))
except:
    print("Error: unable to fecth data")
'''

'''建库
# 使用 execute() 方法执行 SQL，如果表存在则删除
cursor.execute("DROP TABLE IF EXISTS EMPLOYEE")

# 使用预处理语句创建表
sql = """CREATE TABLE EMPLOYEE (
         FIRST_NAME  CHAR(20) NOT NULL,
         LAST_NAME  CHAR(20),
         AGE INT,
         SEX CHAR(1),
         INCOME FLOAT )"""

cursor.execute(sql)
'''

'''插入
# sql 插入语句
sql = """insert into employee(first_name,
         last_name, age, sex, income)
         values ('mac', 'mohan', 20, 'm', 2000)"""

# # sql 插入语句
# sql = "insert into employee(first_name, \
#        last_name, age, sex, income) \
#        values ('%s', '%s', '%d', '%c', '%d' )" % \
#        ('mac', 'mohan', 20, 'm', 2000)
try:
   # 执行sql语句
   cursor.execute(sql)
   # 提交到数据库执行
   connection.commit()
except:
   # 如果发生错误则回滚
   connection.rollback()
'''

'''更新
# SQL 更新语句
sql = "update employee set INCOME = 8000 where FIRST_NAME = '%s' and LAST_NAME = '%s';" % ('xie','ren')
try:
    # 执行SQL语句
    cursor.execute(sql)
    # 提交到数据库执行
    connection.commit()
except:
    # 发生错误时回滚
    connection.rollback()
'''

'''删除
# SQL 删除语句
sql = "delete from employee where age > '%d'" % (30)
try:
   # 执行SQL语句
   cursor.execute(sql)
   # 提交修改
   connection.commit()
except:
   # 发生错误时回滚
   connection.rollback()
'''

# 关闭数据库连接
connection.close()
