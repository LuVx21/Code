package cn.test;

public class Singleton2 {
	private static class SingletonHolder {
		private static final Singleton2 INSTANCE = new Singleton2();
	}


	private Singleton2() {}

	// method 6
	public static final Singleton2 getInstance6() {
		return SingletonHolder.INSTANCE;
	}

}
