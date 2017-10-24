package cn.test;

public class Test2 {
	public static void main(String[] args) {
		/*
		boolean bool = true;
		int a = 1;
		int b = 0;

		if (bool && (a > 0 || (a <= 0 && b > 0))) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
		*/
		
		// 遇到满足后面继续执行
		int num = 4;
		if (num > 3) {
			System.out.println(">3");
		}
		if (num < 5) {
			System.out.println("<5");
		}
		if (num == 4) {
			System.out.println("=4");
		}

		
		// 遇到满足后续不再执行
		int num2 = 4;
		if (num2 > 3) {
			System.out.println(">3");
		}
		else if (num2 < 5) {
			System.out.println("<5");
		}
		else if (num2 ==4) {
			System.out.println("=4");
		}
	}
}
