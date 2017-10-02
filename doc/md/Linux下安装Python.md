#Linux下安装Python

@(Python)

[toc]

进入安装包解压后文件夹，执行命令
```
>> ./configure
```
补:configure 命令执行完之后，会生成一个 Makefile 文件，这个 Makefile主要是被下一步的 make 命令所使用。打开 Makefile你就会发现，里边制定了构建的顺序， Linux 需要按照Makefile 所指定的顺序来构建 (build) 程序组件。
```
>> make
```
make实际上编译你的源代码，并生成执行文件。
```
>> make install
```
make install实际上是把生成的执行文件拷贝到 linux系统中必要的目录下，比如拷贝到 /usr/local/bin 目录下，这样所有 user就都能运行这个程序了。

```python
# 下载最新版本
cd /usr/local/src/
sudo wget http://www.python.org/ftp/python/3.3.2/Python-3.3.2.tar.bz2
sudo chmod 777 Python-3.3.2.tar.bz2 
sudo tar -jx -f Python-3.3.2.tar.bz2

# 安装
cd Python-3.3.2/
./configure --prefix=/usr/local/Python-3.3.2/
sudo make
sudo make install

# 浏览旧版本
cd /usr/bin/
ls -l python*

# 配置新版本：
echo $PATH
PATH=$PATH:/usr/local/Python-3.3.2/bin
echo $PATH

# 链接新版本
cd /usr/bin/
sudo rm -rf python
sudo ln -s /usr/local/Python-3.3.2/bin/python3 ./python

# 输入python检查是否更新,进入后可输入exit()退出python.
python

# 还原旧版本：
ll python*
sudo rm -rf python
sudo ln -s /usr/bin/python2.6 ./python
```
