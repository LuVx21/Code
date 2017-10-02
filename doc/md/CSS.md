#CSS

@(WebService)[Markdown]

> [toc]

**html:结构 CSS:样式 JavaScript:行为**
## 常见属性
> 属性间以`;`分割

```
color:red
font-size:20px
background-color:blue
字体加粗:
	font-weight:bold
	font-weight:normal
斜体:
	font-style:italic
	font-style:normal
下划线:
	text-decoration:underline
```

## 基础选择器
选择器间效果可以叠加,同一属性会被计算叠加
### 标签选择器
针对特定的标签进行修饰,所有的特定标签,范围大
### id选择器
针对标签的id进行修饰,只针对id为特定值得某些标签
<id="idName">
在css中,使用`#idName{}`

> id具有唯一性,一个页面上不能出现相同id

### 类选择器
选择同一标签中的多个,任何标签都可以有class属性,可重复.
同一个标签可能具有多个calss,名字使用空格隔开
<class='className'>
在css中使用`.className{}`

> css中尽量不使用id,而选择使用class.id多给js使用

## 高级选择器
### 后代选择器
处理特定标签的子标签(不一定直接)的样式
使用语法:
`.className tagName{}`
`.className1 .className2 tagName{}`
### 交集选择器
同时使用标签和类选择器,一般以标签开始
`tagName.className{}`
`tagName.className1.className2{}`
### 并集选择器

`tagName,tagName2{}`
`tagName.className1,tagName2.className2{}`
### 通配符
`*` 效率不高,和页面上标签数量成正比,尽量避免使用该通配符.

## 其他选择器
以下选择器,一些低版本浏览器不支持,多是IE6,7
### 儿子选择器
和后代选择器不同,特定标签的直接子标签
`tagName1>tagName2{}`
### 序选择器
`:`后面输入顺序,如last-child
例:
`ul li:first-child{}`
### 兄弟选择器
选择紧跟第一个标签的标签,使用`+`号
`tagName+tagName2{}`
## 继承性
标签的某些属性能够影响到子标签,影响深度到最内层,即属性具有继承性
如,`color`,`text-`,`line-`,`font-`等文字样式属性
关于定位,布局的属性无法继承
## 层叠性
css处理冲突的能力

