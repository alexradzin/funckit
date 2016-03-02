package org.funckit.lang;

import com.google.common.base.Function;

public class ParserFunctions {
	public static final Function<String, Short> parseShort = new Function<String, Short>() {
		@Override
		public Short apply(String s) {
			return Short.parseShort(s);
		}
	};

	public static final Function<String, Integer> parseInt = new Function<String, Integer>() {
		@Override
		public Integer apply(String s) {
			return Integer.parseInt(s);
		}
	};

	public static final Function<String, Long> parseLong = new Function<String, Long>() {
		@Override
		public Long apply(String s) {
			return Long.parseLong(s);
		}
	};
	
	public static final Function<String, Float> parseFloat = new Function<String, Float>() {
		@Override
		public Float apply(String s) {
			return Float.parseFloat(s);
		}
	};
	
	public static final Function<String, Double> parseDouble = new Function<String, Double>() {
		@Override
		public Double apply(String s) {
			return Double.parseDouble(s);
		}
	};
	
	public static final Function<String, Boolean> parseBoolean = new Function<String, Boolean>() {
		@Override
		public Boolean apply(String s) {
			return Boolean.parseBoolean(s);
		}
	};
}
