# coding=UTF-8

'''
判断一个文件中的sql语句是什么类型
寻找字符串中第一个出现可以用find
寻找由特定间隔符隔开的第一个可以用find
需找特定间隔符隔开的第几个，先用split分割，然后用下标找
判断一个元素是否在列表中，可以使用in
'''


def sqlType(pathSQLFile):
    query = ["select", "show"]
    update = ["insert", "update", "delete"]
    dml = ["create", "drop"]
    File = open(pathSQLFile, "r")
    lines = File.readlines()
    for line in lines:
        sql = line
        n = sql.find(" ")
        sqltype = sql[0:n]
        if sqltype in query:
            print sqltype + " is a query sql"
        elif sqltype in update:
            print sqltype + " is a update sql"
        elif sqltype in dml:
            print sqltype + " is a create/drop sql"
    print "\n读取success"
    File.close()


sqlType('../resource_Text/sqltest.sql')