# coding=utf-8

# 文件的打开和关闭

try:  # 使用try ... finally来保证无论是否出错都能正确地关闭文件
    f = open('/home/zlk/test.txt', 'w')  # 写入ASCII编码的文本文件
    f.write('Hello World')
finally:
    if f:
        f.close

# 更为简介的方法：with语句和前面的try ... finally一样，并且不必调用f.close()方法。

with open('/home/zlk/test.txt', 'r') as f:
    for line in f.readlines():
        # 调用readline()可以每次读取一行内容 .strip(）把末尾的'\n'删掉
        print(line.strip())

f = open('/home/zlk/test.jpg', 'rb')  # 读取二进制文件，比如图片、视频等用'rb'模式打开
f.read()
