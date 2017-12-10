package me.ren.junittest;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import org.hamcrest.core.CombinableMatcher;
import org.junit.Test;

/**
 * assertNotEquals(first, second) 查看两个对象是否不相等。 assertTrue(condition)
 * 查看运行结果是否为true。 fail() 让测试失败
 */
public class AssertTests {

	@Test
	// assertArrayEquals(expecteds, actuals) 查看两个数组是否相等。
	public void testAssertArrayEquals() {
		byte[] expected = "trial".getBytes();
		byte[] actual = "trial".getBytes();
		assertArrayEquals("failure - byte arrays not same", expected, actual);
	}

	@Test
	// assertEquals(expected, actual) 查看两个对象是否相等。类似于字符串比较使用的equals()方法
	public void testAssertEquals() {
		assertEquals("failure - strings not same", 5l, 5l);
	}

	@Test
	// assertFalse(condition) 查看运行结果是否为false。
	public void testAssertFalse() {
		assertFalse("failure - should be false", false);
	}

	@Test
	// assertNotNull(object) 查看对象是否不为空。
	public void testAssertNotNull() {
		assertNotNull("should not be null", new Object());
	}

	@Test
	// assertNotSame(unexpected, actual) 查看两个对象的引用是否不相等。类似于使用“!=”比较两个对象
	public void testAssertNotSame() {
		assertNotSame("should not be same Object", new Object(), new Object());
	}

	@Test
	// assertNull(object) 查看对象是否为空。
	public void testAssertNull() {
		assertNull("should be null", null);
	}

	@Test
	// assertSame(expected, actual) 查看两个对象的引用是否相等。类似于使用“==”比较两个对象
	public void testAssertSame() {
		Integer aNumber = Integer.valueOf(768);
		assertSame("should be same", aNumber, aNumber);
	}

	// JUnit Matchers assertThat
	@Test
	// assertThat(actual, matcher) 查看实际值是否满足指定的条件
	public void testAssertThatBothContainsString() {
		assertThat("albumen", both(containsString("a")).and(containsString("b")));
	}

	@Test
	public void testAssertThathasItemsContainsString() {
		assertThat(Arrays.asList("one", "two", "three"), hasItems("one", "three"));
	}

	@Test
	public void testAssertThatEveryItemContainsString() {
		assertThat(Arrays.asList(new String[] { "fun", "ban", "net" }), everyItem(containsString("n")));
	}

	// Core Hamcrest Matchers with assertThat
	@Test
	public void testAssertThatHamcrestCoreMatchers() {
		assertThat("good", allOf(equalTo("good"), startsWith("good")));
		assertThat("good", not(allOf(equalTo("bad"), equalTo("good"))));
		assertThat("good", anyOf(equalTo("bad"), equalTo("good")));
		assertThat(7, not(CombinableMatcher.<Integer>either(equalTo(3)).or(equalTo(4))));
		assertThat(new Object(), not(sameInstance(new Object())));
	}
}
