#coding=utf-8

import urllib2
import random

def getContent(url,headers):
    """
    此函数用于抓取返回403禁止访问的网页
    """
    random_header = random.choice(headers)

    """
    对于Request中的第二个参数headers，它是字典型参数，所以在传入时
    也可以直接将个字典传入，字典中就是下面元组的键值对应
    """
    req =urllib2.Request(url)
    req.add_header("User-Agent", random_header)
    req.add_header("GET",url)
    req.add_header("Host","blog.csdn.net")
    req.add_header("Referer","http://dict.hjenglish.com/jp/jc/")

    content=urllib2.urlopen(req).read()
    return content

url = "http://blog.csdn.net/ystyaoshengting/article/details/45094495"
# my_headers中的内容由于是个人主机的信息，
# 用句号省略了一些，在使用时可以将自己主机的User-Agent放进去
my_headers = ["Mozilla/5.0 (Windows NT 6.3; Win64; x64) 。。。 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36"]
print getContent(url,my_headers)