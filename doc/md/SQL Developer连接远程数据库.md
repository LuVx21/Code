# 本机不安装Oracle客户端，使用PL/SQL Developer连接远程数据库


1、先到Oracle网站下载Instant Client :

http://www.oracle.com/technology/global/cn/software/tech/oci/instantclient/index.html

根据你的操作系统选择不同的Instant Client版本

下载会是一个压缩文件,解压之后的文件夹叫:D:/instantclient_11_2.放在你喜欢的目录即可.例如:D:/instantclient_11_2

 

2、在D:/instantclient_11_2目录下新建目录network,在network目录下再新建admin目录,在admin目录下新建文件tnsnames.ora,使用文本编辑器打开写入如下内容:

MWDB =
(DESCRIPTION =
    (ADDRESS_LIST =
      (ADDRESS = (PROTOCOL = TCP)(HOST = 192.168.0.58 )(PORT = 1521))
    )
    (CONNECT_DATA =
      (SERVICE_NAME = MWDB )
    )
)

第一个黄色字块：表示定义远程服务器的在本地主机名

第二个黄色字块：远程数据库的IP地址

第三个黄色子块：远程数据库实例名

 

3、添加一个环境变量，名为TNS_ADMIN，值为tnsnames.ora文件所在路径。比如我的本机为：D:/instantclient_11_2/network/admin

 

4、设置ORACLE的语言，添加环境变量NLS_LANG ,值为: AMERICAN_AMERICA.US7ASCII

该值可以连接到远程数据库中，通过下面的sql语句查询得到：

select userenv('language') from dual;

如果该值设置不正确，将导致PL/SQL Developer连接数据库后，查看的数据会出现乱码。

 

5、下载并安装PL.SQL.Developer配置应用
配置tools->preferences->connection

Oracle Home
D:/instantclient_11_2

OCI library

D:/instantclient_11_2/oci.dll

中文的PL/SQL Developer就是

工具-->首选项-->连接

Oracle主目录

D:/instantclient_11_2

OCI库

D:/instantclient_11_2/oci.dll

 

6、关闭PL/SQL Developer,重起Developer.

主机名就会出现在PL/SQL Developer的列表里，输入用户名密码，就可以登录远程oracle 11g数据库了。

 

补充Instant Client 说明

Oracle Instant client 是oracle提供的简便客户端, 支持多种平台. 可从oracle网站下载, 下载地址为
http://www.oracle.com/technology/global/cn/software/tech/oci/instantclient/index.html

包括如下内容:
Instant client Package - Basic 运行OCI, OCCI, 和JDBC-OCI应用程序需要的所有文件. 

Instant client Package - Basic Lite: 只包含英语错误信息, 只支持unicode, ascii, 西欧字符集. 

Instant client Package - JDBC Supplement  为jdbc增加了xa, 国际化和RowSet操作.

Instant Client Package - SQL *Plus 包含sqlplus和需要的库文件

Instant client Package - SDK 使用Instant Client开发Oracle 应用程序需要的头文件及示例makefile

Instant client package - ODBC 使用odbc时需要的库, 不是所有平台都有. linux平台包含. 

Basic 和Basic Lite两个中必须选一个, 其他包都是可选的. 我下载 了 Basic, JDBC supplement, SQL *Plus, SDK, ODBC. 解压后放在一个文件夹下, 在这个文件夹下建立文件 tnsnames.ora, 设置环境变量LD_LIBRARY_PATH和TNS_ADMIN指向解压后的目录, 就可以使用sqlplus了. 

我下载的instant client版本为10.2.0.2.0, 测试了联接到oracle 9.2.0.4和oracle 10.2.0.1. 

Instant Client中不包含tnsping, exp/imp, rman, netca等工具. 如果需要这些工具则需要安装oracle client