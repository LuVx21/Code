@echo off

::SET FROM
set sd=D:\test\1
cd /d "%sd%"

::set TO
set dd=D:\test\3

if not exist %dd%  md %dd%

setlocal enabledelayedexpansion
for /f "delims=" %%i in ('dir *.*/a-d /b /s') do (
set fd=%%~ti
if "!fd:~,10!"=="!date:~,10!" (
     copy "%%i" "%dd%" /y 2>nul||(
      attrib -r -s -h "%%i"& copy "%%i" %dd% /y>nul
)))
pause