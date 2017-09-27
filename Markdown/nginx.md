# nginx

@(Java)[nginx][server]

[TOC]

## 关于

Nginx是一款轻量级的Web服务器/反向代理服务器及电子邮件(IMAP/POP3)代理服务器

* 反向代理 :
    反向代理:代理服务器的,用户不需要设置.

* 负载均衡:
    原理就是数据流量分摊到多个服务器上执行,减轻每台服务器的压力,
    多台服务器共同完成工作任务,从而提高了数据的吞吐量。

* 动静分离:
    将静态的资源放到反向服务器,节省用户的访问时间.


> Nginx接收用户请求是异步的,即先将用户请求全部接收下来,再一次性发送到后端Web服务器,极大减轻后端Web服务器的压力
> 发送响应报文时,是边接收来自后端Web服务器的数据,边发送给客户端

## 模块
内核模块和事件驱动模块,即：CoreModule和EventsModule；另外还有第三方模块 HTTP内核模块


## 命令及配置

```
nginx [-?hvVtq] [-s signal] [-c filename] [-p prefix] [-g directives]
```

|参数|说明|
|:--|:--|
|-?,-h        |打开帮助信息|
|-v           |显示版本信息并退出|
|-V           |显示版本和配置选项信息,然后退出|
|-t           |检测配置文件是否有语法错误,然后退出|
|-q           |在检测配置文件期间屏蔽非错误信息|
|-s signal    |给一个nginx主进程发送信号,reload,reopen,start,stop|
|-p prefix    |设置前缀路径(默认是：/usr/local/Cellar/nginx/1.2.6/)|
|-c filename  |设置配置文件(默认是：/usr/local/etc/nginx/nginx.conf)|
|-g directives|设置配置文件外的全局指令|

**配置及说明**
```
###########start#################
#user administrator administrators;  #配置用户或者组,默认为nobody nobody。
#worker_processes 2;  #允许生成的进程数,默认为1
#pid /nginx/pid/nginx.pid;   #指定nginx进程运行文件存放地址
error_log log/error.log debug;  #制定日志路径,级别。这个设置可以放入全局块,http块,server块,级别以此为:debug|info|notice|warn|error|crit|alert|emerg
events {
    accept_mutex on;   #设置网路连接序列化,防止惊群现象发生,默认为on
    multi_accept on;  #设置一个进程是否同时接受多个网络连接,默认为off
    #use epoll;      #事件驱动模型,select|poll|kqueue|epoll|resig|/dev/poll|eventport
    worker_connections  1024;    #最大连接数
}
http {
    include       mime.types;   #文件扩展名与文件类型映射表
    default_type  application/octet-stream; #默认文件类型
    #access_log off; #取消服务日志
    log_format myFormat '$remote_addr–$remote_user [$time_local] $request $status $body_bytes_sent $http_referer $http_user_agent $http_x_forwarded_for'; #自定义格式
    access_log log/access.log myFormat;  #combined为日志格式的默认值
    sendfile on;   #允许sendfile方式传输文件,可以在http块,server块,location块。
    sendfile_max_chunk 100k;  #每个进程每次调用传输数量不能大于设定的值,默认为0,即不设上限。
    keepalive_timeout 65;  #连接超时时间,可以在http,server,location块。

    upstream servers {
      server 127.0.0.1:8080;
      server 192.168.10.121:3333 backup;  #热备
      ip_hash; # 1个ip只能访问其中一台server,解决session共享问题
    }

    error_page 404 https://www.baidu.com; #错误页
    server {
        keepalive_requests 120; #单连接请求上限次数。
        listen       4545;   #监听端口
        server_name  127.0.0.1;   #监听地址
        location  ~*^.+$ {       #请求的url过滤,正则匹配,~为区分大小写,~*为不区分大小写。
           #root path;  #根目录
           #index vv.txt;  #设置默认页
           proxy_pass  http://servers;  #请求转向servers定义的服务器列表
           deny 127.0.0.1;  #拒绝的ip
           allow 172.18.5.54; #允许的ip
        }
    }
}
###########end#################
```
1. $remote_addr 与$http_x_forwarded_for 用以记录客户端的ip地址;
2. $remote_user :用来记录客户端用户名称;
3. $time_local : 用来记录访问时间与时区;
4. $request : 用来记录请求的url与http协议;
5. $status : 用来记录请求状态;成功是200,
6. $body_bytes_s ent :记录发送给客户端文件主体内容大小;
7. $http_referer :用来记录从那个页面链接访问过来的;
8. $http_user_agent :记录客户端浏览器的相关信息;

> 每个指令必须有分号结束。

## 搭建集群
### windows

1. 在g盘新建两个目录 tomcat1 tomcat2
2. 修改tomcat2的端口 在tomcat1的端口上+10
3. 配置nginx
    修改nginx的 nginx.conf文件
    在locatioin / 下添加了反向代理
        proxy_pass 代理服务器
    这是只是代理一台服务器
4. 代理集群
    需要在http节点内添加一个
    ```
    upstream servers{
        server 127.0.0.1:8080;
        server 127.0.0.1:8090;
    }
    ```
    修改location /下的反向代理
    ```
    proxy_pass http://servers
    ```
5. session共享问题
    解决方式1:只能在window下有效
        web服务器解决(广播机制)
        修改两个地方:
            1.修改tomcat的server.xml 支持共享
                将 引擎标签下的
                    <Cluster className="org.apache.catalina.ha.tcp.SimpleTcpCluster"/>
                注释去掉
            2.修改项目的配置文件 web.xml中添加一个节点
        注意:tomcat下性能低

    解决方式2:
        可以将session的id放入redis中

    解决方式3:
        保证一个ip地址永远的访问一台web服务器,就不存在session共享问题了
        在nginx的配置文件中
            upstream中添加`p_hash`;

### Linux

1. 编译nginx
    安装依赖包

        * yum install gcc-c++
        * yum install -y pcre pcre-devel
        * yum install -y zlib zlib-devel
        * yum install -y openssl openssl-devel

    执行编译

        进入 nginx的目录
        执行`./configure`

2. 安装nginx
    ```
    make
    make install
    ```
3. 启动nginx
    cd nginx目录下
        配置文件 conf
        启动nginx
            ./nginx

4. 将端口号80 放行
    `/sbin/iptables -I INPUT -p tcp --dport 80 -j ACCEPT`
    将该设置添加到防火墙的规则中
    `/etc/rc.d/init.d/iptables save`

5. 修改conf文件 和window下一样
    配置集群