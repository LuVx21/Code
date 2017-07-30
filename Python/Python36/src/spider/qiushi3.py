# -*- coding:utf-8 -*-
import urllib.request
import re

# https://www.qiushibaike.com/hot/page/1/

url = 'http://www.qiushibaike.com/hot/'
user_agent = 'Mozilla/4.0 (compatible; MSIE 5.5; Windows NT)'
headers = {'User-Agent': user_agent}
request = urllib.request.Request(url=url, headers=headers)
response = urllib.request.urlopen(request)
content = response.read().decode('utf-8')
print(content)
pattern = re.compile(
    '<div.*?author clearfix">.*?<h2>(.*?)</h2>.*?<div.*?content">(.*?)<!--.*?-->.*?<img src="(.*?)" alt=.*?>.*?</i>')
items = re.findall(pattern, str(content))
for item in items:
    haveImg = re.search('img', item[2])
    if not haveImg:
        print(item[0]), print(item[1])
