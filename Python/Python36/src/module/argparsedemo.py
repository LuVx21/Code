#-*- coding:utf-8 -*-
import argparse

# 命令行输入参数处理
parser = argparse.ArgumentParser()

parser.add_argument('input')
parser.add_argument('-o', '--output')
parser.add_argument('--width', type=int, default=80)

# 获取参数

IMG = parser.parse_args().input
OUTPUT = parser.parse_args().output
WIDTH = parser.parse_args().width

if __name__ == '__main__':
    print(IMG,OUTPUT,WIDTH)