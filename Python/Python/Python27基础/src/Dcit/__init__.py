# coding=utf-8

phoneBook = {"Alice":"0458","Lily":"2548","Tom":"1786"}  
#用dict函数初始化  
phoneBook = dict(Alice = "0458",Lily = '2548')  
  
#用dict函数和 (键,值) 初始化  
items = [('Alice', '0458'),('Lily','2548')]  
phoneBook = dict(items)  


#根据键查找相应值  
print phoneBook['Lily']  
#输出键值对的个数  
print len(phoneBook)  
#修改某个键对应的值  
phoneBook['Lily'] = '2579'  
print phoneBook['Lily']  
#删除某个键值  
del phoneBook['Lily']  
print phoneBook  
print "Lily in phoneBook ? ","Lily" in phoneBook  


#clear()方法 清空字典中的所有项  
dict_x = {}  
dict_x['name'] = "value"  
dict_y = dict_x  
dict_x = {}  
print "dict_x :",dict_x  
print "dict_y :",dict_y  
  
dict_x['name'] = "value"  
dict_y = dict_x  
dict_x.clear()  
print "dict_x :",dict_x  
print "dict_y :",dict_y  


#copy() 方法 (浅拷贝)  
dict_x = {"name":"Lily","phoneNum":"2579","friends":["Lucy","Lilei"]}  
#字典y是x的一个浅拷贝  
dict_y = dict_x.copy()  
#替换字典y 的 name值 原字典x的name值不会跟着改变  
dict_y["name"] = "LilyChange"  
print r"dict_x[name] = ",dict_x["name"]  
print r"dict_y[name] = ",dict_y["name"]  
#修改字典y 的 friends值 原字典x的friends值会跟着改变  
dict_y["friends"].remove("Lucy")  
print r"dict_x[friends] = ",dict_x["friends"]  
print r"dict_y[friends] = ",dict_y["friends"]  



#deepcopy(dict) 方法 (深拷贝)  
from copy import deepcopy  
dict_x = {"name":"Lily","phoneNum":"2579","friends":["Lucy","Lilei"]}  
#字典y是x的一个浅拷贝  
dict_y = deepcopy(dict_x)  
#替换字典y 的 name值 原字典x的name值不会跟着改变  
dict_y["name"] = "LilyChange"  
print r"dict_x[name] = ",dict_x["name"]  
print r"dict_y[name] = ",dict_y["name"]  
#修改字典y 的 friends值 原字典x的friends值不会跟着改变  
dict_y["friends"].remove("Lucy")  
print r"dict_x[friends] = ",dict_x["friends"]  
print r"dict_y[friends] = ",dict_y["friends"]  



#fromkeys(['key1','key2'])使用给定键建立新的字典 每个键值的默认值为None  
fromkeysdict = dict.fromkeys(['key1','key2'])  
print fromkeysdict  



#get('key') 方法如果key不在字典中 则返回None 而 dictname['key']如果没有对应key在字典中则会报错  
getDic = {}  
#getDic["keyname"]  #此句会报错  
print getDic.get("keyname")  



#has_key('key') 检查字典中是否拥有某个key  
hasKeyDict = {"name":"Lily","age":12}  
print hasKeyDict.has_key("name")  
print hasKeyDict.has_key("grade")  



#items 方法将所有的字典项以列表的方式返回.这些列表项中的每一项都来自于(键,值)  
#但是项在返回时没有固定顺序  
mDict = {"title":"MyDict","Context":"this is my Dict for Test ","Author":"Guodong"}  
myDictList = mDict.items()  
print myDictList[1]  



#keys 和 iterkeys  
#keys方法返回所有键的列表  
#iterkeys方法返回键的迭代器  
mDict = {"title":"MyDict","Context":"this is my Dict for keys ","Author":"Guodong"}  
print mDict.keys() 



#pop方法移除对应键的键值对  
mDict = {"title":"MyDict","Context":"this is my Dict for keys ","Author":"Guodong"}  
mDict.pop("title")  
print mDict 




#popitem 随机弹出列表的某一项 (一般会弹出第一项 但是Python不确定一定总是第一项)  
mDict = {"title":"MyDict","Context":"this is my Dict for keys ","Author":"Guodong"}  
mDict.popitem()  
print mDict  



#setdefault 给键值设定一个初始值   
  
d = {}  
#如果键不存在  会相应更新字典  
d.setdefault('name',"none")   
print d  
d['name'] = "Lily"  
#如果键值已经存在 则不会改变原有值  
d.setdefault('name',"none")   
print d  



#update 通过另一个字典更新字典  
d1 = {"name":"none","age":13}  
d2 = {"name":"guodong"}  
d1.update(d2)  
print d1  
