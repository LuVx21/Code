# Python
Python 练习

## 数据类型

在 Python 2 中，/ 执行整型运算,5./2-->2.5 而5/2-->2
在 Python 3 中，/ 操作符是做浮点除法，而 // 是做整除（即商没有余数，比如 10 // 3 其结果就为 3，余数会被截除掉，而 (-7) // 3 的结果却是 -3。
这个算法与其它很多编程语言不一样，需要注意，它们的整除运算会向0的方向取值。


## 一些函数
    ** # 代表指数运算,2**3:2的3次方
    math.ceil() # 向上取整
    math.log(num,arg) # log以arg为底,num的指数

## Lambda
*普通实现*

	def sq(x):
	    return x * x
	
	map(sq, [y for y in range(108)])
	
*Lambda实现*
	
	map( lambda x: x*x, [y for y in range(108)] )

## UDP
使用UDP协议时，不需要建立连接，只需要知道对方的IP地址和端口号，就可以直接发数据包。但是，能不能到达就不知道了。 
虽然用UDP传输数据不可靠，但它的优点是和TCP比，速度快，对于不要求可靠到达的数据，就可以使用UDP协议。

## 序列化
把变量从内存中变成可存储或传输的过程称之为序列化，在Python中叫pickling
序列化之后，就可以把序列化后的内容写入磁盘，或者通过网络传输到别的机器上
反过来，把变量内容从序列化的对象重新读到内存里称之为反序列化，即unpickling
### 操作
Python提供两个模块来实现序列化：cPickle和pickle。
这两个模块功能是一样的，区别在于cPickle是C语言写的，速度快，pickle是纯Python写的，速度慢
跟cStringIO和StringIO一个道理
用的时候，先尝试导入cPickle，如果失败，再导入pickle