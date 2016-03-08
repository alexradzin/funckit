package org.funckit.string;

import java.util.Arrays;

import org.junit.Test;

import com.google.common.collect.FluentIterable;

import static org.funckit.string.StringFunctions.length;
import static org.funckit.string.StringFunctions.stringLength;
import static org.funckit.string.StringPredicates.startsWith;
import static org.junit.Assert.assertArrayEquals;
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
	
	@Test
	public void filterAndTransform() {
		Integer[] actuals = FluentIterable.from(Arrays.asList("", "a", "abc")).filter(startsWith("a")).transform(length).toArray(Integer.class);
		Integer[] expecteds = new Integer[] {1, 3};
		assertArrayEquals(expecteds, actuals);
	}
	
	private void length(String str, int expectedLength) {
		assertEquals(expectedLength, length.apply(str).intValue());
		assertEquals(expectedLength, stringLength.apply(str).intValue());
	}

}
