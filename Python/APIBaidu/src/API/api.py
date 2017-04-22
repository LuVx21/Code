# -*- coding: utf-8 -*-

import requests
import json

url = 'http://apis.baidu.com/txapi/mvtp/meinv'
params = {'num': '10'}

headers = {'apikey': 'acd515e86a8eca0a69cbf350c7c83a18'}
r = requests.get(url, params=params, headers=headers)
r = r.json()


def saveImage(imgUrl, imgName='default.jpg'):
    """保存图片到本地"""
    response = requests.get(imgUrl, stream=True)
    image = response.content
    dst = 'F:\\api\\'
    path = dst + imgName
    print 'save the file:' + path
    with open(path, 'wb') as img:
        img.write(image)
    img.close()


def run():
    for line in r['newslist']:
        title = line['title']
        picUrl = line['picUrl']
        saveImage(picUrl, imgName=title + '.jpg')

run()
