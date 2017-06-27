#coding=utf-8

import urllib

def getHtml(url):
    page = urllib.urlopen(url)
    html = page.read()
    return html

# html = getHtml("http://tieba.baidu.com/p/2738151262")

File = open('Text/1.txt', "r")
lines = File.readlines()

for i in range(len(lines)):
    fo = open("Text/2.txt", "r+")
    path = lines[i][:45]
    html = getHtml(path)
    fo.seek(0, 2)
    fo.write(html)
    fo.close()