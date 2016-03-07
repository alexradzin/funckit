package org.funckit.string;

import static org.funckit.string.StringFunctions.length;
import static org.funckit.string.StringFunctions.stringLength;
import static org.funckit.string.StringPredicates.startsWith;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

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
		List<String> strings = new ArrayList<String>(Arrays.asList("", "a", "abc"));
		CollectionUtils.filter(strings, startsWith("a"));
		Integer[] actuals = CollectionUtils.collect(strings, length).toArray(new Integer[0]);
		Integer[] expecteds = new Integer[] {1, 3};
		assertArrayEquals(expecteds, actuals);
	}
	
	private void length(String str, int expectedLength) {
		assertEquals(expectedLength, ((Integer)length.transform(str)).intValue());
		assertEquals(expectedLength, ((Integer)stringLength().transform(str)).intValue());
	}

}
