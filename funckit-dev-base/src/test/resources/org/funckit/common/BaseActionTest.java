package org.funckit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.funckit.common.BaseAction;
import org.junit.Test;

public class BaseActionTest {
	private static final BaseAction<String, Integer> action1_0() { 
		return new BaseAction<String, Integer>() {
			@Override
			public Integer execute(String s) {
				return Integer.parseInt(s);
			}
		};
	}

	private static final BaseAction<String, Integer> action2_0() { 
		return new BaseAction<String, Integer>() {
			@Override
			public Integer execute(String s) {
				return Integer.parseInt(s);
			}
		};
	}


	private static final BaseAction<String, Integer> action1_1(final int i) { 
		return new BaseAction<String, Integer>(i) {
			@Override
			public Integer execute(String s) {
				return Integer.parseInt(s, i);
			}
		};
	}
	
	
	
	@Test
	public void execute() {
		new BaseAction<String, Integer>() {
			@Override
			public Integer execute(String s) {
				return Integer.parseInt(s);
			}
		}.apply("123");
	}

	
	

	@Test
	public void hash0() {
		assertTrue(action1_0().hashCode() == action1_0().hashCode());
		assertFalse(action1_0().hashCode() == action2_0().hashCode());
	}
	
	@Test
	public void hash1() {
		assertTrue(action1_1(10).hashCode() == action1_1(10).hashCode());
		assertFalse(action1_1(10).hashCode() == action1_1(8).hashCode());
	}
	
}
