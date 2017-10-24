@rem ===============================================================================
@echo off


echo ■■■■■■■■■■■Test!■■■■■■■■■■■
echo 0.创建项目
echo 1.创建应用
echo 2.启动服务
echo 3.同步数据库
echo 4.创建超级用户

SET /P option=输入操作选项:
if "%option%"=="0"
(
	SET /P ProjectName=输入创建的项目名:
	if "%ProjectName%"=="" (
	echo 项目名不能为空:
	echo off
	pause
	exit 2
	)
	@rem 创建项目
	django-admin.py %startproject%
)

if "%option%"=="1"
(
	SET /P APPName=输入创建的应用名:
	if "%APPName%"=="" 
	(
		echo 应用名不能为空:
		echo off
		pause
		exit 2
	)
	@ rem 创建应用
	python manage.py startapp %APPName%
)
if "%option%"=="2"
(
	@rem 启动服务
	python manage.py runserver
)
if "%option%"=="3"
(
	@rem 同步数据库
	python manage.py migrate
)
if "%option%"=="4"
(
	@rem 创建超级用户
	python manage.py createsuperuser
)

@rem EXIT
echo off
pause