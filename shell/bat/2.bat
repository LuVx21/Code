@echo off

set COPYTO_DIR="S:\Share\3"
set TEMP_DIR=%COPYTO_DIR%_temp
set UPDATE_DIR=%COPYTO_DIR%_update

echo [Start FileCopy] %time% > filecopy.log

FOR /F "tokens=1,2 delims=," %%a IN (filecopy.csv) DO (
	echo ・%%a >> filecopy.log
	copy /Y %%a %UPDATE_DIR%\%%b >> filecopy.log
)

echo [Rename Folder] %time% >> filecopy.log
move %COPYTO_DIR% %TEMP_DIR%
move %UPDATE_DIR% %COPYTO_DIR%
move %TEMP_DIR% %UPDATE_DIR%

echo [End FileCopy] %time% >> filecopy.log