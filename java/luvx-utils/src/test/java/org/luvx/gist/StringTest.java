package org.luvx.gist;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class StringTest {
	@Test
	public void createTest() {
		List<List<String>> fatherList = new ArrayList<>();
		List<String> childList = new ArrayList<>();
		childList.add("before");
		fatherList.add(childList);
		childList.add("after");
		System.out.println(fatherList);
	}

	@Test
	public void createTest1() {
		String s1 = new String("hello");
		String s2 = new String("world");
		System.out.println(s1 + ":" + s2);// hello:world
		change(s1, s2);
		System.out.println(s1 + ":" + s2);// hello:world
	}

	@Test
	public void createTest2() {
		StringBuffer sb1 = new StringBuffer("hello");
		StringBuffer sb2 = new StringBuffer("world");
		System.out.println(sb1 + ":" + sb2);// hello:world
		change(sb1, sb2);
		System.out.println(sb1 + ":" + sb2);// hello:worldworld
	}

	public void change(String s1, String s2) {
		s1 = s2;
		s2 = s1 + s2;
	}

	public void change(StringBuffer sb1, StringBuffer sb2) {
		sb1 = sb2;
		sb2.append(sb1);
	}
}
