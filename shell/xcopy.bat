REM set yyyymmdd=%date:~0,4% %date:~5,2% %date:~8,2%
set yyyymmdd=%date:~0,4%%date:~5,2%%date:~8,2%
REM 20170309

REM set time2=%time: =0% 
set time2=%time: =0% 
REM 22:47:07.04

REM set hhmi=%time2:~0,2% %time2:~3,2%
set hhmi=%time2:~0,2%%time2:~3,2%
REM 2247

echo %yyyymmdd%
echo %time2%
echo %hhmi%


REM mkdir "y:\test\%yyyymmdd%%hhmi%\renxie\"

REM del "y:\test\%yyyymmdd%%hhmi%\renxie\*.xls"
REM xcopy ".\*.xls" "y:\test\%yyyymmdd%%hhmi%\renxie"

pause