# coding=UTF-8

def fileMerge(pathFile1, pathFile2):
    '''合并两个文件,同行进行拼接'''
    File1 = open(pathFile1, "r")
    File2 = open(pathFile2, "r")
    lines1 = File1.readlines()
    lines2 = File2.readlines()
    for line in lines1:
        print line

    print '----------'

    for i in lines1:
        print deleteEnter(i)
    print '------------'
    # print lines1
    # print '-----------'
    # print lines1[0]
    # print '-----------'
    # print deleteEnter(lines1[0])
    # print '-----------'
    '''需要去除左侧文件的每行的换行符
    然后和右侧同行进行拼接'''
    File1.close()
    File2.close()


def deleteEnter(str):
    if (str.find("\n") >= 0):
        str = str[0:len(str) - 1]
    return str


fileMerge('../resource_Text/1.txt', '../resource_Text/2.txt')
