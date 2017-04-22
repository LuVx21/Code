# coding=utf-8

import socket
import threading
import time

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
# 监听端口:
s.bind(('127.0.0.1', 9995))
s.listen(5)  # 调用listen()方法开始监听端口，传入的参数指定等待连接的最大数量
print 'Waiting for connection...'


def tcplink(sock, addr):
    print 'Accept new connection from %s:%s...' % addr
    sock.send('连接成功!')
    while True:
        data = sock.recv(1024)
        time.sleep(1)
        if data == 'exit' or not data:
            break
        sock.send('Hello, %s!' % data)
    sock.close()
    print 'Connection from %s:%s closed.' % addr


while True:
    # 接受一个新连接:
    sock, addr = s.accept()  # accept()会等待并返回一个客户端的连接
    # 创建新线程来处理TCP连接:
    t = threading.Thread(target=tcplink, args=(sock, addr))
    t.start()
