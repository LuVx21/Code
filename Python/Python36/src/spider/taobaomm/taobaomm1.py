# -*- coding:utf-8 -*-
import urllib.request
from bs4 import BeautifulSoup
import re
import ssl
context = ssl._create_unverified_context()

url = 'https://mm.taobao.com/search_tstar_model.htm'
user_agent = 'Mozilla/4.0 (compatible; MSIE 5.5; Windows NT)'
headers = {'User-Agent': user_agent}
request = urllib.request.Request(url=url, headers=headers)



response = urllib.request.urlopen(request,context=context)
# content=response.read()
content = response.read().decode('utf-8','ignore')
print(content)


# soup = BeautifulSoup(content, "html.parser")
# tag = soup.find_all("div","content")
# print(tag[0].span)


'''
进入个人页面
mm.taobao.com/self/aiShow.htm?userId=176817195

进入模特卡
mm.taobao.com/self/model_info.htm?user_id=176817195

soup.find("div","mm-p-info mm-p-base-info")
soup.find("ul","mm-p-info-cell clearfix")
'''