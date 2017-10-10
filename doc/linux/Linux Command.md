# Linux 命令

@(Linux)

[TOC]

## Linux 命令

	command [-options] [parameter]

|命令项|说明|
|:-|:-|
|command|命令名,相应功能的英文单词或单词缩写
|-options|选项名,可用来对命令进行控制,可省略
|parameter1|传给命令的参数,可以是一个或多个


–help:Linux命令自带帮助信息.如:ls –help
man:Linux提供的一个手册,包含绝大部分的命令,函数使用说明.如:man ls
|功能键|说明|
|:-|:-|
|space|下一屏
|enter|下一行
|b|回滚一屏
|f|前滚一屏
|q|退出
|h|查看所有功能键
|/word|搜索word字符串

## tail

默认输出文件的后10行内容,可以指定输出的行数 

```
tail <filename.xx>
tail -n N <filename.xx>
```


## mkdir

```
mkdir -p project/{lib/ext,bin,src,doc/{html,info,pdf},demo/stat/a}
```

## expr

关于

计算表达式变量的值

格式
    
    expr expression

字符串处理
```
match str1 str2:在str1中查找str2,str2支持正则表达式
substr str index length:从index处开始截取length长度子串(index start from 0)
index str1 str2:在str1中查找str2
length str:str的长度
```

## 查看信息:ls
关于

Linux文件或目录名称最长有265个字符.`'.'`代表当前目录,`'..'`代表上一级目录.以`'.'`开头的文件为隐藏文件,需要用`-a`参数才能显示

格式

	ls [option]

参数

|参数|说明|
|:-|:-|
|-a|显示目录下所有,包含隐藏文件
|-l|以列表方式显示
|-h|配合-l使用,显示文件大小
|-s|同上

注意

* option部支持正则表达式,如*,?,[],-(作为通配符只能在[]中使用)等

使用

```
ls -alh
ls *.java # 所有.java文件
ls ?.java # 文件名只有一个字符的java文件
ls [a-f].java # 文件名`a~f`其中之一个字符的java文件
```

## sort
关于

对文本的行排序

格式

	sort [option] xx.xx

参数

|参数|说明|
|:-|:-|
|-c|测试文件是否已经被排序  complete|
|-k|指定排序的域   k1  k2nr 往后加命令即可|
|-m|合并两个已排序的文件   merge|
|-n|根据数字大小进行排序  number|
|-o|[输出文件] 将输出写到指定的文件,相当于将输出重定向到指定文件  open|
|-r|将排序结果逆向 reverse|
|-t|改变域分隔符|
|-u|去除结果中的重复行 unique  -u|

## uniq
关于

去除文本文件中的重复行<=>`sort -u`
只能处理邻近的行,所以去重复前有必要sort

格式

	uniq [option] xx.xx

参数
|参数|说明|
|:-|:-|
|-c|打印每行在文本中重复出现的次数,count|
|-d|只显示有重复的记录,每个重复记录只出现一次|
|-u|只显示没有重复的记录,unique|

## join
关于


格式

	join [option] xx1.xx xx2.xx

参数
|参数|说明|
|:-|:-|
|-a1/-a2|除了显示以共同域进行连接的结果外,-a1表示还显示第1个文件中没有共同域的记录,-a2则表示显示第2个文件中没有共同域的记录|
|-i|比较域内容时,忽略大小写差异|
|-o|设置结果显示的格式|
|-t|改变域分隔符|
|-v1/-v2|跟-a选项类似,不显示以共同域进行连接的结果|

## cut
关于

从标准输入或文本文件中按域或行提取文本

格式

	cut [option] xx.xx
参数
|参数|说明|
|:-|:-|
|-c|指定提取的字符数,或字符范围   count|
|-f|指定提取的域数,或域范围  field|
|-d|改变域分隔符|

例:
```
cut -c1-5 teacher.db
cut -d: -f1,4 teacher.db
cut -d: -f1-3 teacher.db
```

## paste
关于

文本文件或标准输出中的内容粘贴到新的文件

格式

	paste [option] xx1.xx xx2.xx
参数
|参数|说明|
|:-|:-|
|-d|默认域分隔符是空格或Tab键,设置新的域分隔符|
|-s|将每个文件粘贴成一行|
|-|从标准输入中读取数据|

```
paste 1.txt 2.txt 同行合并,以tab分隔
```

## split
关于

分割文件
格式

	split [option] xx.xx xx1.xx
参数
|参数|说明|
|:-|:-|
|-/-l|此两个选项等价,都用于指定切割成小文件的行数|
|-b|指定切割成小文件的字节|
|-C|与-b选项类似,切割时尽量维持每行的完整性|


## tr
关于

字符转换,类似于`sed`
格式

	tr [option] str1 str2 <xx.xx
参数
|参数|说明|
|:-|:-|
|-c|选定字符串1中字符集的补集,即反选字符串1中的字符集|
|-d|删除字符串1中出现的所有字符|
|-s|删除所有重复出现的字符序列,只保留一个|

## sed
关于

本身是一个管道命令,主要是以行为单位进行处理,可以将数据行进行替换,删除,新增,选取等特定工作
http://8598676.blog.51cto.com/8588676/1398213

格式

	sed [option] "cmd" xx.xx
参数
|参数|说明|
|:-|:-|
|-n|使用安静(silent)模式.只有经过sed 特殊处理的那一行(或者动作)才会被列出来.|
|-e|直接在指令列模式上进行 sed 的动作编辑;|
|-f|直接将 sed 的动作写在一个档案内, -f filename 则可以执行 filename 内的sed 动作;|
|-r|sed 的动作支援的是延伸型正规表示法的语法.(预设是基础正规表示法语法)|
|-i|直接修改读取的档案内容,而不是由萤幕输出|


|命令|说明|
|:-|:-|
|a|新增, a 的后面可以接字串,而这些字串会在新的一行出现(目前的下一行)～|
|c|替换,行|
|d|删除|
|i|插入, i 的后面可以接字串,而这些字串会在新的一行出现(目前的上一行);|
|p|列印,将某个选择的资料印出.通常 p 会与参数 sed -n 一起|
|s|替换,字符|

```
sed '1,2d' xx.xx 删除1~2行
sed '2,$d' xx.xx 删除2~最后一行
```

## >/>>

Linux允许将命令执行结果重定向到一个文件,
将本应显示在终端上的内容保存到指定文件中.

注意

* `>`输出重定向会覆盖原来的内容
* `>>`输出重定向则会追加到文件的尾部

## 分屏显示:more

查看内容时,在信息过长无法在一屏上显示时,会出现快速滚屏,使得用户无法看清文件的内容,此时可以使用more命令,每次只显示一页,按下空格键可以显示下一页,按下q键退出显示,按下h键可以获取帮助.
ctrl+b 返回上一屏
ctrl+f 下一屏

> 与此类似的有`less`命令

## 管道:|

一个命令的输出可以通过管道做为另一个命令的输入
`|`的左右分为两端,左端获得命令执行结果,右端使用左端结果

## 文本搜索:grep

关于

grep命令是一种强大的文本搜索工具,grep允许对文本文件进行模式查找.如果找到匹配模式, grep打印包含模式的所有行

格式

	grep [-option] 'word' filename.xx

参数

|参数|说明|
|:-|:-|
|-v|不匹配的行
|-n|显示匹配行的行号
|-i|忽略大小写


注意

* grep命令中输入字符串参数时,最好引号或双引号括起来
* 可以匹配正则表达式,如下

|参数|说明|
|:-|:-|
|^a|以a开始的行
|a$|以a结束的行
|.|匹配一个非换行符的字符

使用
```
grep -n 'word' filename.py
grep -nv 'word' filename.py
grep -nv '^a' filename.py # a开始的行
grep -nv 'a$' filename.py # a结束的行
grep -nv 'a.b' filename.py # ab间有一个非换行符字符
```

## 切换目录:cd
关于

cd命令可以帮助用户切换工作目录.Linux所有的目录和文件名大小写敏感
cd后面可跟绝对路径,也可以跟相对路径.如果省略目录,则默认切换到当前用户的主目录.

注意

* 如果路径是从根路径开始的,则路径的前面需要加上`/`

使用
|命令|说明|
|:-|:-|
|cd ~|等价于`cd`,切换到用户主目录
|cd ..|上层目录
|cd -|上次所在目录

例
```
# -r 是“递归”， -u 是“更新”，-v 是“详细”
cp -r -u -v dir1 dir2 # 值拷贝新的
# 备份
cp -f --backup=numbered test1.py test1.py
```

## 创建目录:mkdir
mkdir命令可以创建一个新的目录

	mkdir [-p] dirname/[dirname]

注意

* 新建目录的名称不能与当前目录中已有的目录或文件同名
* 目录创建者必须对当前目录具有写权限
* `-p`参数可递归创建文件夹

```
mkdir -p a/b/
```
## 删除目录:rmdir

删除一个目录

注意

* 必须离开目录
* 目录必须为空目录
* `-p`递归删除()

```
rmdir -p a/b/
```

## 删除文件:rm

可通过rm删除文件或目录
使用rm命令要小心,因为文件删除后不能恢复

参数

|命令|说明|
|:-|:-|
|-i|交互式进行(有确认)
|-f|强制删除,无提示
|-r|递归删除目录下内容,删除dir时此参数必需

## 链接文件:ln

链接文件分为软链接和硬链接.
软链接:软链接不占用磁盘空间,源文件删除则软链接失效.
硬链接:硬链接只能链接普通文件,不能链接目录.

使用

```
ln xxx.xx xxx.xx.ln
ln -s xxx.xx xxx.xx.ln
```

注意

* -s 代表建立一个软链接文件
* -s选项是更常见的形式
* 硬链接文件,两个文件占用相同大小的硬盘空间,即使删除了源文件,链接文件还是存在
* 软链接文件和源文件不在同一个目录,源文件要使用绝对路径,不能使用相对路径

## 查找文件:find
通常用来在特定的目录下搜索符合条件的文件
也可以用来搜索特定用户属主的文件

	find [dirname] [-option] xxx.xx|size

参数

|参数|说明|
|:-|:-|
|-name|按文件名查找
|-size|按文件大小查找
|-perm|按权限查找

## 拷贝文件:cp
将给出的文件或目录复制到另一个文件或目录中

	cp [-opiton] $*

参数

|参数|说明|
|:-|:-|
|-a|拷贝目录时使用,能保持拷贝文件的属性,递归拷贝
|-f|交互式操作(无确认),文件已存在时不提示
|-i|交互式操作(有确认)
|-r|若拷贝的是目录,将递归拷贝改目录下所有目录和文件,目标必需为目录
|-v|显示进度


注意

* `-r`不能保持拷贝文件的属性不变,是与`-a`的一大不同


## 移动文件:mv

移动文件或目录,也可以给文件或目录重命名

	mv [-option] $*

参数

|参数|说明|
|:-|:-|
|-f|交互式操作(无确认),文件已存在时不提示
|-i|交互式操作(有确认),以免覆盖文件
|-v|显示进度

## 归档管理:tar

关于

tar是Unix/Linux中最常用的备份工具,此命令可以把一系列文件归档到一个大文件中,也可以把档案文件解开以恢复数据

格式

	tar [option] filename <files>

参数

|参数|说明|
|:-|:-|
|-c|打包
|-x|解包
|-v|显示进度
|-f|指定tar文件名,其后一定是.tar文件,所以必须放option最后
|-t|查看包内容

注意
* 参数前面可以使用'-',也可以不使用
* f需要放在参数的最后,其它参数的顺序任意
* <files>支持正则表达式

使用
```
tar -cvf test.tar *
tar -xvf test.tar
```

## 文件压缩:gzip

关于

tar与gzip命令结合使用实现文件打包,压缩. tar只负责打包文件,但不压缩,用gzip压缩tar打包后的文件,其扩展名一般用xxxx.tar.gz

格式

	gzip [option] filename [filename.gz]

参数

|参数|说明|
|:-|:-|
|-r|压缩
|-d|解压

注意
* 压缩时,r可以省略
* `tar -z`可以调用gzip

使用

```
gzip filename.tar
gzip -r filename.tar filename.tar.gz
gzip -d filename.tar.gz
tar -zcvf xxxx.tar.gz *
tar -zxvf xxxx.tar.gz
# 解压到指定目录
tar -zxvf xxxx.tar.gz -C dirname/
```
## 文件压缩:bzip2
关于

用法和gzip一样
用bzip2压缩tar打包后的文件,其扩展名一般用xxxx.tar.gz2

注意

* `tar -j`可以调用bzip2
* 实际使用发现gzip比bzip2压缩率高,更节省空间

## zip/unzip
关于

通过zip压缩文件的目标文件不需要指定扩展名,默认扩展名为zip
```
zip [-r] xxx *
```

```
unzip -d dirname/ xxx.zip
```

## 用户,权限管理

用户管理包括用户与组账号的管理
Unix/Linux系统中的root账号通常用于系统的维护和管理,它对Unix/Linux操作系统的所有部分具有不受限制的访问权限.
在Unix/Linux安装的过程中,系统会自动创建许多用户账号,而这些默认的用户就称为“标准用户”

## 查看当前用户:whoami

可通过cat /etc/passwd查看系统用户信息

## 查看登录用户:who

who命令用于查看当前所有登录系统的用户信息

|参数|说明|
|:-|:-|
|-m或am i|只显示运行该命令的账户|
|-q或--count|显示账户名和登录用户数量|
|-u或--heading|显示列标题|

## 退出登录账户:exit

如果是图形界面,退出当前终端;
如果是使用ssh远程登录,退出登陆账户;
如果是切换后的登陆用户,退出则返回上一个登陆账号

## 添加用户账号:useradd

在Unix/Linux中添加用户账号可以使用adduser或useradd命令,因为adduser命令是指向useradd命令的一个链接,因此,这两个命令的使用格式完全一样

	useradd [-option] username

|参数|说明|
|:-|:-|
|-d|指定新用户的主目录,不使用该参数会在/home下创建同名主目录|
|-m|自动常见目录|
|-g|指定组|

注意

* 用户的主目录一般要放到在/home下,用户的主目录和用户名是相同的
* 如果创建用户的时候,不指定组名,那么系统会自动创建一个和用户名一样的组名

使用

```
useradd -d /home/xxx xxx -m
useradd -d /home/xxx xxx -g grpname -m
```



## 设置用户密码:passwd

超级用户可以使用passwd命令为普通用户设置或修改用户口令.用户也可以直接使用该命令来修改自己的口令,而无需在命令后面使用用户名

```
sudo passwd xxx # 修改xxx的密码
passwd # 修改当前用户密码
```

## 删除用户:userdel

```
userdel xxx # 删除用户不会删除对应主目录
uder -r xxx # 删除用户同时删除对应主目录
```

## 切换用户:su

可以通过su命令切换用户,su后面可以加`-`.
`su`和`su –`命令不同之处在于,`su –`切换到对应的用户时会将当前的工作目录自动转换到切换后的用户主目录




## 添加,删除组账号:‘groupadd,groupdel’

```
groupadd xxx # 新建组账号
groupdel xxx # 删除组账号
```

> 查看有哪些用户组
`cat /etc/group`

## usermod
```
usermod -g 用户组 用户名 # 修改用户所在组
usermod -a -G 用户组 用户名 # 将用户加入组
```

```
groups username # 查看用户所在组
```


创建的普通用户添加sudo权限
```
sudo usermod -a -G adm 用户名 # 将用户加入组adm

sudo usermod -a -G sudo 用户名 # 将用户加入组sudo
```

usermod -g 与 -G的区别

`-g`用来指定这个用户默认的用户组
`-G`一般配合’`a`来完成向其它组添加

## 修改文件权限:chmod

chmod 修改文件权限有两种使用格式:字母法与数字法.
字母法:chmod u/g/o/a +/-/= rwx 文件
|参数|说明|
|:-|:-|
|u
|g
|o
|a

|参数|说明|
|:-|:-|
|+
|-
|=

|参数|说明|
|:-|:-|
|r|读,对目录,无此权限则不能通过ls查看目录内容|
|w|写,对目录,无此权限则不能新建文件|
|x|执行,对目录,无此权限则不能通过`cd`命令进入


注意

* 如果想递归所有目录加上相同权限,需要加上参数“ -R ”. 如:chmod 777 test/ -R 递归 test 目录下所有文件加 777 权限

## 修改文件所有者:chown

## 修改文件所属组:chgrp