# Oralce 批量执行多个sql文件

@(Oracle)

> [toc]

新建 index.sql文件
添加以下内容
```sql
@start.sql
@@执行的文件.sql
@@文件夹/执行的文件.sql
@@end.sql
```
> 执行的文件可以在多层文件夹下,写相对路径即可

start.sql文件
```
set serveroutput on
spool "log.log" append
```

end.sql文件
```
spool off
```
执行sql文件的脚本文件,run.bat
```
@rem ===============================================================================
@echo off
@rem ===============================================================================

@rem 设置用户
SET ORACLE_USERID=scott
@rem 指定用户密码
SET ORACLE_PASSWARD=1121
@rem 设置数据库
SET ORACLE_SID=XE

@rem 动态输入密码
@rem SET /P ORACLE_PASSWARD=input the Password of %ORACLE_USERID%:
@rem ===============================================================================

@rem 配置数据库登录信息
SET W_CONNECT=%ORACLE_USERID%/%ORACLE_PASSWARD%@%ORACLE_SID%

if "%ORACLE_PASSWARD%"=="" (
echo パスワードを入力してください：
echo off
pause
exit 2
)

echo ================Info of User=============
echo User:		%ORACLE_USERID%
echo PassWord:	%ORACLE_PASSWARD%
echo DB:		%ORACLE_SID%
echo ================Run Start================

@rem 登录数据库,执行文件
SQLPLUS %W_CONNECT% "@index.sql"

@rem 异常信息
if errorlevel 1 (
echo RenXie-ERROR!
echo off
pause
) 

EXIT
echo ================Run End===============

echo off

pause
```
## Linux下
```
sqlplus -S /nolog <<EOF
    conn test/test@test
    @a.sql
    @b.sql
    @c.sql
EOF
```