package org.funckit.string;

import org.junit.Test;

import static org.funckit.string.StringFunctions.length;
import static org.funckit.string.StringFunctions.stringLength;
import static org.junit.Assert.assertEquals;

public class StringFunctionsTest {
	@Test
	public void lengthEmptyString() {
		length("", 0);
	}

	@Test
	public void lengthSomeString() {
		length("abc", 3);
	}
	
	private void length(String str, int expectedLength) {
		assertEquals(expectedLength, length.apply(str).intValue());
		assertEquals(expectedLength, stringLength.apply(str).intValue());
	}

}
