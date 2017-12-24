package org.luvx.save;

public class UtilsMethon {

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
			// 该元素为空,比较ASCII码
			if (arrays[i] == 0)
				lengthOfNotBlank--;
		}
		return lengthOfNotBlank;
	}

}
