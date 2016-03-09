package org.funckit.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BaseParamHolderTest {
	/**
	 * Instances of different classes are never equal
	 */
	@Test
	public void differentAnonymousClassesNoParams() {
		BaseParamHolder one = new BaseParamHolder() { /* no code */ };
		BaseParamHolder two = new BaseParamHolder() { /* no code */ };
		assertHoldersNotEqual(one, two);
	}

	
	/**
	 * Two instances of the same class without parameters are equal
	 */
	@Test
	public void sameClassDifferentObjects() {
		BaseParamHolder one = new NoParamHolder();
		BaseParamHolder two = new NoParamHolder();
		assertHoldersEqual(one, two);
	}
	
	/**
	 * Two instances of the same class with same parameters are equal
	 */
	@Test
	public void sameClassDifferentObjectsSameParameters() {
		BaseParamHolder one = new ParamHolder("hello", "world", 123);
		BaseParamHolder two = new ParamHolder("hello", "world", 123);
		assertHoldersEqual(one, two);
	}
	

	/**
	 * Two instances of the same class with different parameters are not equal
	 */
	@Test
	public void sameClassDifferentObjectsDifferentParameters() {
		BaseParamHolder one = new ParamHolder("hello", 123);
		BaseParamHolder two = new ParamHolder("world", 456);
		assertHoldersNotEqual(one, two);
	}
	

	private void assertHoldersEqual(BaseParamHolder one, BaseParamHolder two) {
		assertEquals(one.hashCode(), two.hashCode());
		assertTrue(one.equals(two));
		assertTrue(two.equals(one));
	}

	private void assertHoldersNotEqual(BaseParamHolder one, BaseParamHolder two) {
		assertNotEquals(one.hashCode(), two.hashCode());
		assertFalse(one.equals(two));
		assertFalse(two.equals(one));
	}
	
	
	private static class NoParamHolder extends BaseParamHolder {
		// no code
	}

	private static class ParamHolder extends BaseParamHolder {
		public ParamHolder(Object... params) {
			super(params);
		}
	}
}
