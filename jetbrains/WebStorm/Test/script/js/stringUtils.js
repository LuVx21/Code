/*
 * 清除左空格,不改变原来的值
 */
String.prototype.ltrim = function(str) {
	return str.replace(/^(\s*|　*)/, "");
}

/*
 * 清除右空格
 */
String.prototype.rtrim = function(str) {
	return str.replace(/(\s*|　*)$/, "");
}

/*
 * 清除左右空格
 */
String.prototype.trim = function(str) {
	return this.ltrim(this.rtrim(str));
}

/*
 * 先判断是否undefined,再判断是否null
 */
String.prototype.isNull = function(str) {
	//	result = (str === undefined ? '为undefined' : (str.length == 0 ? '为null' : '非null'));
	if(str === undefined) {
		return '未定义';
	} else {
		//判断是否为空
		if(str.length == 0) { //str==""
			return '为空';
		} else {
			// 判断是否只有1个空格
			if(str == " ") {
				return '只有空格';
			}
			//判断是否全部为空格
			// TODO
			//判断是否存在空格
			if(str.indexOf(' ') > -1) {
				return '存在空格';
			}
		}
	}
}

/*
 * 替换所有 
 */
String.prototype.replaceAll = function(str, replaceWith) {　　
	return this.replace(new RegExp(str, "gm"), replaceWith);　　
}

/*
 * 3个参数
 */
// TODO
String.prototype.replaceAll2 = function(str, replaceWith, ignoreCase) {　
	if(!RegExp.prototype.isPrototypeOf(str)) {
		return this.replace(new RegExp(str, (ignoreCase ? "gi" : "g")), replaceWith);
	} else {
		return this.replace(str, replaceWith);
	}
}