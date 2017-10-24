# coding=utf-8

import time
import threading


# 新线程执行的代码:
def loop():
    print 'thread %s is running...' % threading.current_thread().name
    n = 0
    while n < 5:
        n = n + 1
        print 'thread %s >>> %s' % (threading.current_thread().name, n)
        time.sleep(1)
    print 'thread %s ended.' % threading.current_thread().name


print 'thread %s is running...' % threading.current_thread().name
t = threading.Thread(target=loop, name='LoopThread')
t.start()
t.join()  # 一直执行子进程
print 'thread %s ended.' % threading.current_thread().name

print '---------------------------------------------------------------------'

lock = threading.Lock()
# 新线程执行的代码:
def loop1():
    # 先要获取锁:
    lock.acquire()
    try:
        print 'thread %s is running...' % threading.current_thread().name
        n = 0
        while n < 5:
            n = n + 1
            print 'thread %s >>> %s' % (threading.current_thread().name, n)
            time.sleep(1)
        print 'thread %s ended.' % threading.current_thread().name
    finally:
        # 改完了一定要释放锁:
        lock.release()


print 'thread %s is running...' % threading.current_thread().name
t = threading.Thread(target=loop1, name='AThread')
t1 = threading.Thread(target=loop1, name='BThread')
t.start()
t1.start()
t.join()
t1.join()  # 一直执行子进程
print 'thread %s ended.' % threading.current_thread().name