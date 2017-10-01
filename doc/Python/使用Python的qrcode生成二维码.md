#使用Python的qrcode生成二维码
##安装
pip安装

	pip install qrcode
使用源码安装

	git clone git@github.com:lincolnloop/python-qrcode.git
	cd python-qrcode
	python setup.py install
查看安装信息

	pip show qrcode
##命令行
qrcode提供了生成二维码的命令，这个很符合程序员装逼的风格。

	qr 'Some data' > test.png
这样就能够产生一个包含对应信息的二维码。

##代码生成
首先需要导入qrcode模块，然后调用make方法，会生成一个图片对象，调用图片对象 的save方法就可以将生成的二维码保存下来了。

	import qrcode
	img = qrcode.make("renxie")
	img.save("LuVx.png")
##更多设置
上面两种方式都是按照qrcode默认的方式生成二维码，如果我们希望生成不同尺寸的二维码 就需要使用QRCode类了。

	import qrcode
	qr = qrcode.QRCode(
	    version=1,
	    error_correction=qrcode.constants.ERROR_CORRECT_L,
	    box_size=10,
	    border=4,
	)
	qr.add_data('renxie')
	qr.make(fit=True)
	
	img = qr.make_image()
	img.save('LuVx.png')
version 表示二维码的版本号，二维码总共有1到40个版本，最小的版本号是1，对应的尺寸是 21×21，每增加一个版本会增加4个尺寸。这里说的尺寸不是只生成图片的大小，而是值二维码的长 宽被平均分为多少份。
error_correction指的是纠错容量，这就是为什么二维码上面放一个小图标也能扫出来，纠错 容量有四个级别，分别是

* ERROR_CORRECT_L L级别，7%或更少的错误能修正
* ERROR_CORRECT_M M级别，15%或更少的错误能修正，也是qrcode的默认级别
* ERROR_CORRECT_Q Q级别，25%或更少的错误能修正
* ERROR_CORRECT_H H级别，30%或更少的错误能修正

box_size 指的是生成图片的像素
border 表示二维码的边框宽度，4是最小值

生成其他类型的二维码
我们可以将二维码转化为SVG(矢量图)，命令行的方式：

	qr --factory=svg-path "xinxingzhao" > xinxingzhao.svg
	qr --factory=svg "xinxingzhao" > xinxingzhao.svg
	qr --factory=svg-fragment "xinxingzhao" > xinxingzhao.svg
使用python代码的方式：

	import qrcode
	import qrcode.image.svg
	
	if method == 'basic':
	    # Simple factory, just a set of rects.
	    factory = qrcode.image.svg.SvgImage
	elif method == 'fragment':
	    # Fragment factory (also just a set of rects)
	    factory = qrcode.image.svg.SvgFragmentImage
	else:
	    # Combined path factory, fixes white space that may occur when zooming
	    factory = qrcode.image.svg.SvgPathImage
	
	img = qrcode.make('xinxingzhao', image_factory=factory)