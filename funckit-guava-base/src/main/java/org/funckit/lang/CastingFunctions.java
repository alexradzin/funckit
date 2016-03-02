package org.funckit.lang;

import com.google.common.base.Function;

public class CastingFunctions {
	public static final Function<Short, Byte> short2byte = new Function<Short, Byte>() {
		@Override
		public Byte apply(Short s) {
			return s.byteValue();
		}
	};
	
	public static final Function<Integer, Short> int2short = new Function<Integer, Short>() {
		@Override
		public Short apply(Integer i) {
			return i.shortValue();
		}
	};
	
	public static final Function<Long, Integer> long2int = new Function<Long, Integer>() {
		@Override
		public Integer apply(Long l) {
			return l.intValue();
		}
	};
	
	public static final Function<Double, Float> double2float = new Function<Double, Float>() {
		@Override
		public Float apply(Double d) {
			return d.floatValue();
		}
	};
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	public static final Function<Byte, Short> byte2short = new Function<Byte, Short>() {
		@Override
		public Short apply(Byte b) {
			return b.shortValue();
		}
	};
	
	public static final Function<Short, Integer> short2int = new Function<Short, Integer>() {
		@Override
		public Integer apply(Short s) {
			return s.intValue();
		}
	};
	
	public static final Function<Integer, Long> int2long = new Function<Integer, Long>() {
		@Override
		public Long apply(Integer i) {
			return i.longValue();
		}
	};
	
	public static final Function<Float, Double> float2double = new Function<Float, Double>() {
		@Override
		public Double apply(Float f) {
			return f.doubleValue();
		}
	};
	
	public static final <V, T> Function<V, T> cast(final Class<T> type) {
		return new Function<V, T>() {
			@Override
			@SuppressWarnings("unchecked")
			public T apply(V value) {
				return (T)value;
			}
		};
	};
}
