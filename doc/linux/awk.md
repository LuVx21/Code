# awk

@(Linux)[shell]

awk 以行为处理单位



文件的每一行中，由域分隔符分开的每一项称为一个域。通常，在不指名-F域分隔符的情况下，默认的域分隔符是空格。



工作流程是这样的：

读入有'\n'换行符分割的一条记录，然后将记录按指定的域分隔符划分域，填充域，$0则表示所有域,$1表示第一个域,$n表示第n个域。

默认域分隔符是"空白键" 或 "[tab]键".



```

awk [-F field-separator] 'commands' xx.xx

awk [option] '' xx.xx

```



```

# 账户与shell之间以逗号分割,在所有行添加列名name,shell,在最后一行添加"blue,/bin/nosh"

cat /etc/passwd |awk -F ':' 'BEGIN {print "name,shell"} {print $1","$7} END {print "blue,/bin/nosh"}'

# 搜索/etc/passwd有root关键字的所有行,只对符合的行进行操作,没有action默认输出行

awk -F: '/root/{print $7}' /etc/passwd

awk -F: '/root/' /etc/passwd

```
