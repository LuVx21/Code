# coding=UTF-8
# 去重复

path = '../resource_Text/1.txt'

file = open(path, "r")
lines = file.readlines()
lines1 = []

print lines

for i in range(len(lines)):
    if(lines[i].find("\n") >= 0):
        lines[i]=lines[i][0:len(lines[i])-1]

for i in range(len(lines)):
    count = lines.count(lines[i])
    if count == 1:
        print lines[i]