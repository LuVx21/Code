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
SQLPLUS %W_CONNECT% "@0.sql"

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