# java collection

@(Java)[hashset]


[TOC]
## map

### hashmap

底层实际上是一个数组,key以string形式存在,以key计算value的存储位置.
同一位置处的value数量达到8后,会重构为红黑树

## set
collection <-- set

### hashset
collection <-- set <-- hashset
底层以hashmap形式存在,
主要功能方法实际上都是调用hashmap的方法
基本上可以说HashSet就是利用HashMap来实现的

### treeset

collection <-- set <-- treeset
同样,TreeSet就是利用TreeMap来实现的