package cn.renxie;

import static org.junit.Assert.*;
import org.junit.Test;

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

	@Test
	public void testgetValidate() {
		Id18 test1 = new Id18();
		char result = test1.getValidateCode("14230219700101101");
		// char --> int
		int num = Integer.parseInt(String.valueOf(result));
		assertEquals(3, num);
	}

	public static void main(String[] args) {
		Id18 test = new Id18();
		String id17 = "14230219700101101";
		char result = test.getValidateCode(id17);
		System.out.println("身份证验证码：" + result); // 该身份证校验码：3
	}
}