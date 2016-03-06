package org.funckit.lang;

import org.funckit.common.BaseAction;

public class ParserFunctions {
	public static final BaseAction<String, Short> parseShort = new BaseAction<String, Short>() {
		@Override
		public Short execute(String s) {
			return Short.parseShort(s);
		}
	};

	public static final BaseAction<String, Integer> parseInt = new BaseAction<String, Integer>() {
		@Override
		public Integer execute(String s) {
			return Integer.parseInt(s);
		}
	};

	public static final BaseAction<String, Long> parseLong = new BaseAction<String, Long>() {
		@Override
		public Long execute(String s) {
			return Long.parseLong(s);
		}
	};
	
	public static final BaseAction<String, Float> parseFloat = new BaseAction<String, Float>() {
		@Override
		public Float execute(String s) {
			return Float.parseFloat(s);
		}
	};
	
	public static final BaseAction<String, Double> parseDouble = new BaseAction<String, Double>() {
		@Override
		public Double execute(String s) {
			return Double.parseDouble(s);
		}
	};
	
	public static final BaseAction<String, Boolean> parseBoolean = new BaseAction<String, Boolean>() {
		@Override
		public Boolean execute(String s) {
			return Boolean.parseBoolean(s);
		}
	};
}
