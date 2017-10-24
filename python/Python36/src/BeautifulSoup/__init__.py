# -*- coding:utf-8 -*-

from bs4 import BeautifulSoup

# https://www.crummy.com/software/BeautifulSoup/bs4/doc.zh/

html_doc = """
<html>
<head>
    <title>The Dormouse's story</title>
</head>
<body>
    <p class="title"><b>The Dormouse's story</b></p>
    <p class="story">Once upon a time there were three little sisters; and their names were
    <a href="http://example.com/elsie" class="sister" id="link1">Elsie</a>,
    <a href="http://example.com/lacie" class="sister" id="link2">Lacie</a> and
    <a href="http://example.com/tillie" class="sister" id="link3">Tillie</a>;
    and they lived at the bottom of a well.</p>

    <p class="story">start...end</p>
</body>
</html>
"""
soup = BeautifulSoup(html_doc, "html.parser")

# print(soup.prettify())

print(soup.name)

tag = soup.a

print(tag)
print(tag.name)
print(tag.attrs)
print(tag['href'])
print(tag.get('href'))

print(tag.string)
print(tag.string.replace_with('renxie'))
print(tag.string)

print(soup.head.contents)

'''
print(soup.title)
print(soup.title.name)
print(soup.title.string)
print(soup.p)
print(soup.p.get_text())
print(soup.find_all('a'))
print(soup.find(id='link3'))
print(soup.get_text())


# 遍历文档树
# find_all(name, attrs, recursive, text, limit, **kwargs)

print(soup.find_all('title'))
print(soup.find_all('p', 'title'))
print(soup.find_all('a'))
print(soup.find_all(id="link2"))
print(soup.find_all(id=True))
'''
