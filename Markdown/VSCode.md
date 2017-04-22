# VSCode 使用
## 通用
### 插件

`vscode-icons`

VScode左侧的资源管理器根据文件类型显示图标

## Python
### 插件安装

代码检查

`pip install flake8`

打开VScode，文件->首选项->用户设置，在settings.json文件中输入"python.linting.flake8Enabled": true

格式化代码

`pip install yapf`

打开VScode，文件->首选项->用户设置，在settings.json文件中输入"python.formatting.provider": "yapf"
Alt+Shift+F即可自动格式化代码
### 运行Python程序
方法1:
使用一个名字Python的插件,两次F5运行程序,
如果要按F5马上运行需要将launch.json文件的 "stopOnEntry": true,改为 "stopOnEntry": false。
还可以设置断点进行调试
 
 方法2:
 * ctrl + shifit + p
 * Tasks: Configure Task Runner
 ```
"version": "0.1.0",
"command": "D:/Program Files/Python36/python.exe",
"isShellCommand": true,
"args": ["${file}"],
"showOutput": "always"
 ```
 * ctrl + shift + B 运行