package org.funckit.lang;

import org.funckit.common.BaseAction;


public class CastingFunctions {
	public static final BaseAction<Short, Byte> short2byte = new BaseAction<Short, Byte>() {
		@Override
		public Byte execute(Short s) {
			return s.byteValue();
		}
	};
	
	public static final BaseAction<Integer, Short> int2short = new BaseAction<Integer, Short>() {
		@Override
		public Short execute(Integer i) {
			return i.shortValue();
		}
	};
	
	public static final BaseAction<Long, Integer> long2int = new BaseAction<Long, Integer>() {
		@Override
		public Integer execute(Long l) {
			return l.intValue();
		}
	};
	
	public static final BaseAction<Double, Float> double2float = new BaseAction<Double, Float>() {
		@Override
		public Float execute(Double d) {
			return d.floatValue();
		}
	};
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	public static final BaseAction<Byte, Short> byte2short = new BaseAction<Byte, Short>() {
		@Override
		public Short execute(Byte b) {
			return b.shortValue();
		}
	};
	
	public static final BaseAction<Short, Integer> short2int = new BaseAction<Short, Integer>() {
		@Override
		public Integer execute(Short s) {
			return s.intValue();
		}
	};
	
	public static final BaseAction<Integer, Long> int2long = new BaseAction<Integer, Long>() {
		@Override
		public Long execute(Integer i) {
			return i.longValue();
		}
	};
	
	public static final BaseAction<Float, Double> float2double = new BaseAction<Float, Double>() {
		@Override
		public Double execute(Float f) {
			return f.doubleValue();
		}
	};
	
	public static final <V, T> BaseAction<V, T> cast(final Class<T> type) {
		return new BaseAction<V, T>() {
			@Override
			@SuppressWarnings("unchecked")
			public T execute(V value) {
				return (T)value;
			}
		};
	}
}
