# coding=UTF-8

# readlines()读取文件
File = open("../resource_Text/sqltest.txt","r")
lines = File.readlines()
for line in lines:
    print line,
#this is a stream operation, or the next File
#will get nothing
File.close()
print "\n-------------------------------"

# readline()读取文件
File = open("../resource_Text/sqltest.txt","r")
sql = File.readline()
while sql:
    print sql,
    sql = File.readline()
File.close()
print "\n-------------------------------"

# read()读取文件
File = open("../resource_Text/sqltest.txt","r")
all_the_text = File.read()
# 统计换行符\n的数目
print '换行符\\n的数目:',all_the_text.count("\n")
#sql记录换行符\n的位置
sql = list()
n = 0
for ch in all_the_text:
    if ch == "\n":
        sql.append(n)
    n+=1
print '换行符\\n的位置:',sql
length = len(sql)
print all_the_text[0:sql[0]],
for i in range(0,length-1):
    print all_the_text[sql[i]:sql[i+1]],
print all_the_text[sql[length-1]:]
File.close()
print "-------------------------------"

# split()函数
sqllist = all_the_text.split("\n")
for query in sqllist:
    print query
print "-------------------------------"

# find()函数
seq = all_the_text.find("\n")
print '第一个换行符\\n的位置',seq
# index()函数
seq = all_the_text.index("\n")
print '第一个换行符\\n的位置',seq