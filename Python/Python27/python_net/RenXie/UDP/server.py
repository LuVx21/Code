# coding=utf-8

# 导入socket库
import socket             

s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)       #SOCK_DGRAM指定了这个Socket的类型是UDP
# 绑定端口
s.bind(('127.0.0.1', 9995))                

print 'Bind UDP on 9995...'
while True:
    # 接收数据:
    data, addr = s.recvfrom(1024)
    print 'Received from %s:%s.' % addr
    s.sendto('Hello, %s!' % data, addr)