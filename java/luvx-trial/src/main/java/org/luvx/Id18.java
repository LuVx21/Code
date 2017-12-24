package org.luvx;

/**
 * 身份证最后一位为验证位, 模拟此验证位的产生
 * 前17位已经确定的情况下,验证位也唯一确定
 * @author renxie
 *
 */
public class Id18 {
	// 十七位数字本体码权重
	int[] weight = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
	// mod11,对应校验码字符值
	char[] validate = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' };

	// 计算校验码
	public char getValidateCode(String id17) {
		int sum = 0;
		int mod = 0;
		for (int i = 0; i < id17.length(); i++) {
			sum = sum + Integer.parseInt(String.valueOf(id17.charAt(i))) * weight[i];
		}
		mod = sum % 11;
		return validate[mod];
	}

}