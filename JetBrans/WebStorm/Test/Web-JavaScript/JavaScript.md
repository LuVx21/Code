# JavaScript

## 基础语法
代码折行操作:

	document.write('hello \
	world')

语法错误:控制台调试
逻辑错误:`alert()`调试

数字类型超出最大/最小范围:`Infinity`/`-Infinity`

布尔类型只能是小写true/false

区分`null`和`undefined`

区分`==`和`===:`比较值和比较对象

使用功能typeof obj可以查看对象类型

## 数据类型转换
### 隐式转换
--> 布尔类型
	undefined null 0 0.0 Nan --> false
	空字符串 --> false
--> 数值类型
	undefined --> NaN
	null --> 0
	true --> 1
	false --> 0
	字符串 --> 数字(内容是数字)
	字符串 --> Nan(内容不是数字)
--> 字符串
	undefined --> 'undefined'
	null --> 'null'
	NaN --> 'NaN'
	123 --> '123'
	false --> 'false'
	true --> 'true'
### 显示转换


## 函数

	var a = prompt('input something!'); // 输入内容默认为String

### 编解码

	// uri编解码
	encodeURI();
	decodeURI();
	encodeURIComponent();
	decodeURIComponent();
	// 对字符串编解码
	escape();
	unescape();