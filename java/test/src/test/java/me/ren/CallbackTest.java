package me.ren;

import java.util.Arrays;

import org.junit.Test;

public class CallbackTest {
	@Test
	public void funtest() {
		Callback s1 = new Callback(2, "a", 18, 89);
		Callback s2 = new Callback(3, "x", 22, 94);
		Callback s3 = new Callback(1, "w", 19, 78);
		Callback[] arrs = { s1, s2, s3 };
		Arrays.sort(arrs);
		for (Callback student : arrs) {
			System.out.println(student);
		}
	}
}
