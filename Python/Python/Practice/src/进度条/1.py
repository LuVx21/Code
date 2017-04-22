# -*- coding=utf-8 -*-
from __future__ import division

import sys
import time
j = '#'

# 测试sys.stdout.write()函数
# 类似于print,但输出时不换行,不添加空格等字符
for i in range(0, 3):
    sys.stdout.write('test ')

print

if __name__ == '__main__':
    for i in range(1, 61):
        """\r实现"""
        j += '#'
        sys.stdout.write(str(int((i / 60) * 100)) + '%  ||' + j + '->' + "\r")
        sys.stdout.flush()
        time.sleep(0.2)  # 模拟进度快慢
print


if __name__ == '__main__':
    for i in range(1, 61):
        """\b实现"""
        sys.stdout.write('#' + '->' + "\b\b")
        sys.stdout.flush()
        time.sleep(0.5)
print