/**
 * 格式化日期
 * @param format
 * @returns
 */
Date.prototype.format = function(format) {
	var o = {
		"M+": this.getMonth() + 1, // month
		"d+": this.getDate(), // day
		"h+": this.getHours(), // hour
		"m+": this.getMinutes(), // minute
		"s+": this.getSeconds(), // second
		"q+": Math.floor((this.getMonth() + 3) / 3), // quarter
		"S": this.getMilliseconds()
			// millisecond
	};

	if(/(y+)/.test(format)) {
		format = format.replace(RegExp.$1, (this.getFullYear() + "")
			.substr(4 - RegExp.$1.length));
	}

	for(var k in o) {
		if(new RegExp("(" + k + ")").test(format)) {
			format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] :
				("00" + o[k]).substr(("" + o[k]).length));
		}
	}
	return format;
};

/**
 * 日期相减
 * @param sDate1
 * @param sDate2
 * @returns
 */
function DateDiff(sDate1, sDate2) {
	var arrDate, objDate1, objDate2, intDays;
	arrDate = sDate1.split("-");
	objDate1 = new Date(arrDate[1] + '-' + arrDate[2] + '-' + arrDate[0]);
	arrDate = sDate2.split("-");
	objDate2 = new Date(arrDate[1] + '-' + arrDate[2] + '-' + arrDate[0]);
	intDays = parseInt(Math.abs(objDate1 - objDate2) / 1000 / 60 / 60 / 24);
	return intDays;
}

/**
 * js原型链实现replaceAll
 */
String.prototype.replaceAll = function(s1, s2) {
	return this.replace(new RegExp(s1, "gm"), s2);
};

/**
 * js实现endWith
 */
String.prototype.endWith = function(str) {
	if(str == null || str == "" || this.length == 0 || str.length > this.length)
		return false;
	if(this.substring(this.length - str.length) == str)
		return true;
	else
		return false;
	return true;
}

/**
 * js实现startWith
 */
String.prototype.startWith = function(str) {
	if(str == null || str == "" || this.length == 0 || str.length > this.length)
		return false;
	if(this.substr(0, str.length) == str)
		return true;
	else
		return false;
	return true;
}

/**
 * 数组扩展---根据下标删除某元素
 */
Array.prototype.del = function(n) {
	if(n < 0) return this;
	else
		return this.slice(0, n).concat(this.slice(n + 1, this.length));
};

/**
 * 数组扩展---根据一个值删除某元素
 */
Array.prototype.delByValue = function(value) {
	for(var i = 0; i < this.length; i++) {
		if(this[i] == value) {
			this.del(i);
		}
	}
};

/**
 * 数组扩展判断某值知否在数组中
 */
Array.prototype.isContainsValue = function(value) {
	for(var i in this) {
		if(this[i] == value) {
			return true;
		}
	}
	return false;
};

/**
 * js阻止冒泡事件
 */
function stopPropagation(e) {
	e = e || window.event;
	if(e.stopPropagation) { //W3C阻止冒泡方法
		e.stopPropagation();
	} else {
		e.cancelBubble = true; //IE阻止冒泡方法
	}
}

/*
 * 判断浏览器
 */
WhichBrowser: function() {
	var userAgent = navigator.userAgent;

	var isOpera = userAgent.indexOf("Opera") > -1;
	var isIE = userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1 && !isOpera;
	var isFF = userAgent.indexOf("Firefox") > -1;
	var isCH = userAgent.indexOf("Chrome") > -1;
	var isSafari = userAgent.indexOf("Safari") > -1;

	if(isIE) {
		var IE5 = IE55 = IE6 = IE7 = IE8 = false;
		var reIE = new RegExp("MSIE (\\d+\\.\\d+);");
		reIE.test(userAgent);
		var fIEVersion = parseFloat(RegExp["$1"]);
		IE55 = fIEVersion == 5.5;
		IE6 = fIEVersion == 6.0;
		IE7 = fIEVersion == 7.0;
		IE8 = fIEVersion == 8.0;
		if(IE55) {
			return "IE55";
		}
		if(IE6) {
			return "IE6";
		}
		if(IE7) {
			return "IE7";
		}
		if(IE8) {
			return "IE8";
		}
	}

	if(isFF) {
		return "Firefox";
	}
	if(isCH) {
		return "Chrome";
	}
	if(isOpera) {
		return "Opera";
	}
	if(isSafari) {
		return "Safari";
	}
}