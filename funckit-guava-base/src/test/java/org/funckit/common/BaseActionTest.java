package org.funckit.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.google.common.base.Function;

public class BaseActionTest {
	/**
	 * This test verifies that when {@link Function#apply(Object)} is called 
	 * internal method {@link BaseAction#execute(Object)} is called too with
	 * the same argument and that return value of {@link BaseAction#execute(Object)}
	 * is returned by {@link Function#apply(Object)}.
	 */
	@Test
	public void apply() {
		final String in = "hello";
		final String out = "bye";
		String actual = new BaseAction<String, String>() {
			@Override
			public String execute(String p) {
				assertEquals(in, p);
				return out;
			}
		}.apply(in);

		assertEquals(out, actual);
	}

	@Test
	public void noParameters() {
		parameters();
	}
	
	@Test
	public void oneStringParameter() {
		parameters("hello");
	}

	@Test
	public void severalParameter() {
		parameters("hello", 1, "bye", true);
	}
	

	/**
	 * Verifies that parameters sent to constructor of sub class are available as-is using 
	 * {@link BaseParamHolder#getParameters()}.
	 * @param parameters
	 */
	private void parameters(Object ... parameters) {
		Object[] actual = new BaseAction<String, String>(parameters) {
			@Override
			public String execute(String p) {
				return null;
			}
		}.getParameters();

		assertArrayEquals(parameters, actual);
	}
}
