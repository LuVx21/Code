# -*- coding:UTF-8 -*-  
from xml.dom import minidom , Node  
from xml.dom.minidom import parse  
import xml.dom.minidom  
  
DOMTree = xml.dom.minidom.parse("book.xml")  
collection = DOMTree.documentElement  
books = collection.getElementsByTagName("book")  
for book in books:  
    print"*"*10  
    if book.hasAttribute("name"):  
        print "BookName: %s" % book.getAttribute("name")  
      
    bookid = book.getElementsByTagName('bookid')[0]  
    print "bookid :",bookid.childNodes[0].data  
  
      
    author = book.getElementsByTagName('author')[0]  
    print "author :",author.childNodes[0].data  
  
    chapters = book.getElementsByTagName('chapter')  
    for chapter in chapters:  
  
        chapter1 = chapter.getElementsByTagName('chapter1')[0]  
        print "chapter1 :",chapter1.childNodes[0].data  
  
        chapter2 = chapter.getElementsByTagName('chapter2')[0]  
        print "chapter1 :",chapter2.childNodes[0].data  
      