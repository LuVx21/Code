# coding=UTF-8
import os
import sys

'''
# listdir() join()
path = '../resource_images/images'
print os.listdir(path) # 列出所给路径下的所有文件夹和文件,返回list 
for path2 in os.listdir(path):
    print os.path.join(path, path2)
    print type(os.path) # Module
'''
'''
# 获取当前文件夹
print os.getcwd()
# 获取当前文件夹
print os.getcwdu()
# 当前文件夹的绝对路径,1个点:当前文件夹,2个点:上1层文件夹,1个'\\':磁盘根目录
print os.path.abspath('.')
# 当前文件的全路径
print sys.argv[0]
# 指示你正在使用的平台,Windows:'nt',Linux/Unix:'posix'
print os.name
# 当前平台使用的行终止符,Windows:'\r\n',Linux:'\n',Mac:'\r'
# print os.linesep 
print os.getenv('nt')
# 当前文件夹的上一层文件夹
print os.path.dirname(os.getcwdu())
'''

'''
path1 = os.path.dirname(os.getcwdu())  # C:\Ren\Eclipse\WorkSpace\Python
path2 = os.path.curdir # .
path3 = os.path.join(path1,path2) # C:\Ren\Eclipse\WorkSpace\Python\.
print os.path.abspath(path3) # C:\Ren\Eclipse\WorkSpace\Python
'''


