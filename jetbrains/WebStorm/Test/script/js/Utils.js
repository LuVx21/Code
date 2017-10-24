/*
 * 输出函数 
 */
function print(str) {
	document.write('<br>' + str + '</>');
}

/*
 * 日志函数
 */
function log(str) {
	console.log(str);
}

/*
 * 输出一条分割线
 */
function printLine() {
	document.write('<hr />');
}

/*
 * typeof的重新实现
 */
function type(obj) {
	print('---对象类型---');
	print(obj + '' + typeof(obj));
}