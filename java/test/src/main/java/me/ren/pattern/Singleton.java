package me.ren.pattern;

public class Singleton {
	private static Singleton INSTANCE;

	private Singleton() {}

	// method 1
	public static Singleton getInstance1() {
		if (INSTANCE == null) {
			INSTANCE = new Singleton();
		}
		return INSTANCE;
	}

	// method 2
	public static synchronized Singleton getInstance2() {
		if (INSTANCE == null) {
			INSTANCE = new Singleton();
		}
		return INSTANCE;
	}

	// method 3
	public static Singleton getInstance3() {
		if (INSTANCE == null) {
			synchronized (Singleton.class) {
				if (INSTANCE == null) {
					INSTANCE = new Singleton();
				}
			}
		}

		return INSTANCE;
	}

	// method 4
	public static Singleton getInstance4() {
		// private volatile static Singleton INSTANCE;
		if (INSTANCE == null) {
			synchronized (Singleton.class) {
				if (INSTANCE == null) {
					INSTANCE = new Singleton();
				}
			}
		}
		return INSTANCE;
	}

	// method 5
	public static Singleton getInstance5() {
		// private stacin final Singleton INSTANCE;
		return INSTANCE;
	}
}
