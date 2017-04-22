package cn.renxie;

/**
 * Author: 王俊超
 * Date: 2015-04-21 
 * Time: 19:09 
 * Declaration: All Rights Reserved !!!
 */
public class Test04 {
	/**
	 * 请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.“，则输出”We%20are%20happy.“。
	 *
	 * @param arrays
	 *            要转换的字符数组
	 * @param usedLength
	 *            字符数组中已经使用的长度
	 * @return 转换后使用的字符长度，-1表示处理失败
	 */
	public static int replaceBlank(char[] arrays, int usedLength) {
		// 判断输入是否合法
		if (arrays == null || arrays.length < usedLength) {
			return -1;
		}

		// 统计字符数组中的空白字符数
		int whiteCount = 0;
		for (int i = 0; i < usedLength; i++) {
			if (arrays[i] == ' ') {
				whiteCount++;
			}
		}

		// 计算转换后的字符长度是多少
		int targetLength = whiteCount * 2 + usedLength;
		int tmp = targetLength; // 保存长度结果用于返回
		if (targetLength > arrays.length) { // 如果转换后的长度大于数组的最大长度，直接返回失败
			return -1;
		}

		// 如果没有空白字符就不用处理
		if (whiteCount == 0) {
			return usedLength;
		}

		usedLength--; // 从后向前，第一个开始处理的字符
		targetLength--; // 处理后的字符放置的位置

		// 字符中有空白字符，一直处理到所有的空白字符处理完
		while (usedLength >= 0 && usedLength < targetLength) {
			// 如是当前字符是空白字符，进行"%20"替换
			if (arrays[usedLength] == ' ') {
				arrays[targetLength--] = '0';
				arrays[targetLength--] = '2';
				arrays[targetLength--] = '%';
			} else { // 否则移动字符
				arrays[targetLength--] = arrays[usedLength];
			}
			usedLength--;
		}

		return tmp;
	}

	/**
	 * @param arrays
	 *            判断非空长度的数组
	 * @return lengthOfNotBlank 数据非空部分的长度
	 */
	public static int lengthOfNotBlankOfArray(char[] arrays) {
		// 数组为null，length = 0
		if (arrays == null) {
			return 0;
		}
		int lengthOfNotBlank = arrays.length;
		for (int i = arrays.length - 1; i > -1; i--) {
			// 该元素为空
			if (arrays[i] == 0)
				lengthOfNotBlank--;
		}
		return lengthOfNotBlank;
	}

	public static void main(String[] args) {
		char[] arrays = new char[50];
		arrays[0] = ' ';
		arrays[1] = 'e';
		arrays[2] = ' ';
		arrays[3] = ' ';
		arrays[4] = 'r';
		arrays[5] = 'e';
		arrays[6] = ' ';
		arrays[7] = ' ';
		arrays[8] = 'a';
		arrays[9] = ' ';
		arrays[10] = 'p';
		arrays[11] = ' ';

		int length = replaceBlank(arrays, lengthOfNotBlankOfArray(arrays));
		System.out.println(new String(arrays, 0, length) + " length:" + length);
	}
}
