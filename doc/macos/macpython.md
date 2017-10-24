① Mac系统自带的python环境在：

Python 2.7.10： /System/Library/Frameworks/Python.framework/Versions/2.7 
其中，解释器在该目录下的 ./bin/python2.7 
Python 2.6.9:   /System/Library/Frameworks/Python.framework/Versions/2.6 
其中，解释器在该目录下的 ./bin/python2.6 


② 用户安装的python环境默认环境在：

Python 3.4.2：  /Library/Frameworks/Python.framework/Versions/3.4 
其中，解释器在该目录下的 ./bin/python3.4 
Python 2.7.7：  /Library/Frameworks/Python.framework/Versions/2.7 
其中，解释器在该目录下的 ./bin/python2.7 

注意：一般用户再装一遍python环境的时候，在终端的输入python命令，默认启动的python命令是当前用户安装的python版本环境(即：系统默认的py启动路径，由原来的mac系统默认的解释器变为当前用户安装的py解释器)


③ 用户安装Anaconda3后，自带的python环境在：
Python 3.4.1：  /Users/steven/Anaconda3 (anaconda在安装时候的自定义路径)
其中，解释器在该目录下的 ./bin/python3.4 


④ 用户安装anaconda后，自带的python环境在：
Python 2.7.8：  /Users/steven/anaconda 
其中，解释器在该目录下的 ./bin/python2.7 


注意一个小问题（跟本题无关）：
在命令行下，直接输入

StevenLiu-MacBookPro:bin steven$ pwd

/Users/steven/Anaconda3/bin  #在python3的环境变量下

StevenLiu-MacBookPro:bin steven$ ./python #根据当前路径找解释器

Python 3.4.1 |Anaconda 2.1.0 (x86_64)| (default, Sep 10 2014, 17:24:09) 

[GCC 4.2.1 (Apple Inc. build 5577)] on darwin

Type "help", "copyright", "credits" or "license" for more information.

>>> quit()

StevenLiu-MacBookPro:bin steven$ python#如果没有输入“./”，则进入的是系统当前默认的python环境

Python 2.7.8 |Anaconda 2.1.0 (x86_64)| (default, Aug 21 2014, 15:21:46) 

[GCC 4.2.1 (Apple Inc. build 5577)] on darwin

Type "help", "copyright", "credits" or "license" for more information.

Anaconda is brought to you by Continuum Analytics.

# 这里由于设置了anaconda中的python解释器为默认的python，所以不是

/Library/Frameworks/Python.framework/Versions/2.7 


其他：

Mac系统自带的python环境默认启动路径在：/usr/bin
用户安装的python环境默认启动路径在：/usr/local/bin
终端输入: “python”命令会执行/usr/local/bin下的“python” # 在没有配置文件改变该默认路径的条件下。


最终答案（重点）：
   Mac在启动，会先加载系统配置文件(包括~/.bash_profile  )，所有默认的命令的路径，将会配置文件（比如：~/.bash_profile）中的路径覆盖，并且，是后面覆盖前面的路径：例如，在终端输入“python”，系统会在配置文件中的路径查找，一直到找到位置（在配置文件中从后向前找）：


例如：当前.bash_profile的内容为：

  5 # Setting PATH for Python 2.7
  6 # The orginal version is saved in .bash_profile.pysave
  7 PATH="/Library/Frameworks/Python.framework/Versions/2.7/bin:${PATH}"
  8 export PATH
  9 
 10 # Setting PATH for Python 3.4
 11 # The orginal version is saved in .bash_profile.pysave
 12 PATH="/Library/Frameworks/Python.framework/Versions/3.4/bin:${PATH}"
 13 export PATH
 14 
 15 # added by Steven Liu
 16 export PATH="/Users/steven/Anaconda3/bin:$PATH"
 17 
 18 # added by Anaconda 2.1.0 installer
 19 export PATH="/Users/steven/anaconda/bin:$PATH"
 20 
 21 # added by Anaconda3 2.1.0 installer
 22 export PATH="/Users/steven/Anaconda3/bin:$PATH"
 23 
 24 # Setting PATH for Subversion 1.9.0
 25 export PATH="/opt/subversion/bin:$PATH"
 26 #export PATH="/usr/bin:$PATH"

根据该脚本，先会去找 /opt/subversion/bin 中，有没有命名为“python”的可执行文件(或是快捷方式)，如果没有，则往上找，接着找 /Users/steven/Anaconda3/bin ，发现有，就为当前路径下的解释器环境。—— 所以，想设置python的版本，直接把你想添加的路径export上去，并放在后面。实测有效！

