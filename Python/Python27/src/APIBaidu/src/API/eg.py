# -*- coding: utf-8 -*-

# import sys
# import urllib
import urllib2
# import json


# url = 'http://apis.baidu.com/showapi_open_bus/pic/pic_search?type=4002&page=1'
# url = 'http://apis.baidu.com/dajuncloud/goddess/goddesses?tuid=10'
url = 'http://apis.baidu.com/txapi/mvtp/meinv?num=10'
req = urllib2.Request(url)
req.add_header("apikey", "acd515e86a8eca0a69cbf350c7c83a18")
resp = urllib2.urlopen(req)
content = resp.read()
if(content):
    print(content)