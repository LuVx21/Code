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
    and they lived at the bottom of a well.
    <p class="story">start...end</p>
</body>
</html>
"""

soup = BeautifulSoup(html_doc)

print(soup.head.contents)
print('------------------')
print(soup.title)
print('------------------')
print(soup.title.name)
print('------------------')
print(soup.title.string)
print('------------------')
print(soup.p)
print(soup.p.get_text())
print('------------------')
print(soup.a)
print(soup.a['href'])
print('------------------')
print(soup.find_all('a'))
print('------------------')
print(soup.find(id='link3'))
print('------------------')
print(soup.get_text())

# find_all 函数 : 遍历树
# 
# find_all(name, attrs, recursive, text, limit, **kwargs)

print(soup.find_all('title'))
print(soup.find_all('p', 'title'))
print(soup.find_all('a'))
print(soup.find_all(id="link2"))
print(soup.find_all(id=True))
