package org.luvx;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Id18Test {

	@Test
	public void testgetValidate() {
		Id18 test1 = new Id18();
		char result = test1.getValidateCode("14230219700101101");
		// char --> int
		int num = Integer.parseInt(String.valueOf(result));
		assertEquals(3, num);
	}
}