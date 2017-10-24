# -*- coding:UTF-8 -*-  
import xml.dom.minidom  
  
#创建XML文件  
doc = xml.dom.minidom.Document()  
doc.appendChild(doc.createComment("this is a simple xmll."))  
booklist = doc.createElement("booklist")  
doc.appendChild(booklist)  
  
def addBook(newBook):  
  
    book = doc.createElement("book")  
    book.setAttribute("name", newBook["name"])  
  
    bookid = doc.createElement("bookid")  
    bookid.appendChild(doc.createTextNode(newBook["id"]))  
    book.appendChild(bookid)  
  
      
  
    bookauthor = doc.createElement("author")  
    bookauthor.appendChild(doc.createTextNode(newBook["author"]))  
    book.appendChild(bookauthor)  
  
    bookChapter = doc.createElement("chapter")  
    chapter1 = doc.createElement("chapter1")  
    chapter2 = doc.createElement("chapter2")  
    chapter1.appendChild(doc.createTextNode(newBook["chapter1"]))  
    chapter2.appendChild(doc.createTextNode(newBook["chapter2"]))  
    bookChapter.appendChild(chapter1)  
    bookChapter.appendChild(chapter2)  
    book.appendChild(bookChapter)  
  
    booklist.appendChild(book)  
  
addBook({"id":"0001","name":"果冻自传","author":"果冻","chapter1":"果冻自传第一章","chapter2":"果冻自传第二章"})  
addBook({"id":"0002","name":"GUODONG's LIFE","author":"GUODONG","chapter1":"GUODONG's LIFE chapter1","chapter2":"GUODONG's LIFE chapter2"})  
  
f = file("book.xml","w")  
doc.writexml(f)  
f.close()  