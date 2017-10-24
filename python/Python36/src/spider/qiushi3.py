# -*- coding:utf-8 -*-
import urllib.request
from bs4 import BeautifulSoup
import re
import ssl

context = ssl._create_unverified_context()

# https://www.qiushibaike.com/hot/page/1/

url = 'http://www.qiushibaike.com/hot/'
user_agent = 'Mozilla/4.0 (compatible; MSIE 5.5; Windows NT)'
headers = {'User-Agent': user_agent}
request = urllib.request.Request(url=url, headers=headers)

response = urllib.request.urlopen(request,context=context)
content = response.read().decode('utf-8')
# print(content)

soup = BeautifulSoup(content, "html.parser")
tag = soup.find_all("div","content")
print(tag[0].span)

'''
pattern = re.compile(
    '<div.*?author clearfix">.*?<h2>(.*?)</h2>.*?<div.*?content">(.*?)<!--.*?-->.*?<img src="(.*?)" alt=.*?>.*?</i>')
items = re.findall(pattern, str(content))
print(items)
for item in items:
    haveImg = re.search('img', item[2])
    if not haveImg:
        print(item[0]), print(item[1])
'''