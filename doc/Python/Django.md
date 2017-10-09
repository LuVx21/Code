# Django基础


## 基本命令

```
创建一个Django项目
django-admin.py startproject app

启动项目
python manage.py runserver

> 后面可以添加`IP:Port`的形式设置访问的地址的端口

创建项目下的应用
python manage.py startapp app

设置数据库
python manage.py makemigrations app
python manage.py migrate

创建超级用户
python manage.py createsuperuser

运行测试实例
python manage.py test questions

命令行交互
python manage.py shell
```
## settings.py
### DATABASES

* ENGINE：django.db.backends.postgresql_psycopg2或者django.db.backends.mysql和django.db.backends.sqlite3。也支持其他数据库。
* NAME：数据库名。如果使用的是SQLite的话，数据库则是系统里的一个文件，所以NAME应该设为包含这个文件名字的绝对路径（注意路径要使用斜杠/，无论在什么系统上）。这个文件不需要创建，在第一次进行数据库同步的时候会自动创建这个文件。
* USER：用户名。使用SQLite的话则不需要。
* PASSWORD：密码。使用SQLite的话则不需要。
* HOST：主机地址。使用SQLite的话则不需要。如果数据库安装在同一台机器上，也可以不指定。

### INSTALLED _APPS

保存了那些随着Django实例启动的Django应用(以下用app表示)的名字。app可以被使用到多个项目里，你也可以把它们打包和发布出去供其他人使用。 INSTALLED_APPS默认包含了以下app，这些app全部由Django自带：

* django.contrib.auth – 一个认证系统。
* django.contrib.contenttypes – 内容类型框架。
* django.contrib.sessions – session框架。
* django.contrib.sites – 多网站管理框架。
* django.contrib.messages – 消息管理框架。
* django.contrib.staticfiles – 静态文件管理框架。

这些app每个都至少要用到一个以上的数据库表，所以在使用这些应用前我们先要创建这些表。运行一下命令：

python manage.py migrate

migrate命令会根据 settings.py 文件里的INSTALLED_APPS设置创建必需的数据表,如果不使用上述app可在执行命令前,将app注释掉.