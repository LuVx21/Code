# Shell

@(Linux)[shell]

## terminal 快捷键

ctrl-a: 移动光标到行首。
ctrl-e: 移动光标到行尾。
ctrl-w: 剪切光标前一个单词（注意是剪切，不是彻底删除，可以通过ctrl-y粘贴。
ctrl-u: 剪切光标之前的所有内容，如果光标位于行尾，则相当于剪切整行内容。
ctrl-k: 剪切光标之后的所有内容，有点类似vim的D命令。
ctrl-y：粘贴剪切的内容。
ctrl-p、ctrl-n：向前/向后查看历史命令，和方向键的UP和Down等价。
ctrl-l: 清屏，相当于执行clear命令，注意不会清除当前行内容。
ctrl-h: 向前删除一个字符，相当于回退键。

## (()) 和 []

用于整数计算

## 字符串截取

str="abbc,def,ghi,abcjkl"
echo ${str#a*c}     # 输出,def,ghi,abcjkl.(#)表示从左边截取掉最短的匹配 (这里把abbc字串去掉）
echo ${str##a*c}    # 输出jkl,(##)表示从左边截取掉最长的匹配
echo ${str#"a*c"}   # 输出abbc,def,ghi,abcjkl 因为str中没有"a*c"子串
echo ${str##"a*c"}  # 输出abbc,def,ghi,abcjkl 同理
echo ${str#*a*c*}   # 空
echo ${str##*a*c*}  # 空
echo ${str#d*f)     # 输出abbc,def,ghi,abcjkl,
echo ${str#*d*f}    # 输出,ghi,abcjkl
echo ${str%a*l}     # abbc,def,ghi  一个百分号(%)表示从右边截取最短的匹配
echo ${str%%b*l}    # a.两个百分号表示(%%)表示从右边截取最长的匹配
echo ${str%a*c}     # abbc,def,ghi,abcjkl


## 字符串替换

str="apple, tree, apple tree"
echo ${str/apple/APPLE}   # 替换第一次出现的apple
echo ${str//apple/APPLE}  # 替换所有apple

echo ${str/#apple/APPLE}  # 如果字符串str以apple开头，则用APPLE替换它
echo ${str/%apple/APPLE}  # 如果字符串str以apple结尾，则用APPLE替换它


## alias中使用shell函数

alias中间使用参数,可以使用函数:
```
alias src='fun() { grep -i $1 /c/cvs_app/1/src.txt > /c/cvs_app/1/docpath.txt && vs /c/cvs_app/1/docpath.txt;};fun'
```



```
echo off
echo [Start FileCopy] %time% > filecopy.log
FOR /F "tokens=1,2,3 delims=," %%a IN (filecopy.csv) DO (
	copy "%%a" "%%b"
	copy "%%a" "%%c"
	echo pathFrom: %%a → pathTo: %%b >> filecopy.log
	echo pathFrom: %%a → pathTo: %%c >> filecopy.log
	@rem explorer "%%a"
)
echo [End FileCopy] %time% >> filecopy.log
```
```
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
```
