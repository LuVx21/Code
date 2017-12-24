package org.luvx.save;

public class Test {
	public static void main(String[] args) {
		equalVS();
	}

	public static void equalVS() {
		/**
		 * 创建str2时,先去查找有没有相同的内容,然后指向str1,因此是同一对象
		 */
		String str1 = "hello world!";
		String str2 = "hello world!";
		System.out.println(str1 == str2); // true
		System.out.println(str1.equals(str2)); // true

		/**
		 * new 出来的对象不是同一个,即使内容相同
		 */
		String str3 = new String("hello world!");
		String str4 = new String("hello world!");
		System.out.println(str3 == str4); // false
		System.out.println(str3.equals(str4)); // true
	}
};