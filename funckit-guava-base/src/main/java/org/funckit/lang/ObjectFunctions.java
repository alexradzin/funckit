package org.funckit.lang;

import com.google.common.base.Function;

public class ObjectFunctions {
	public static final Function<Object, Integer> hashCode = new Function<Object, Integer>() {
		@Override
		public Integer apply(Object obj) {
			return obj.hashCode();
		}
	};
	
	public static final Function<Object, Integer> hashCodeFunction() {
		return hashCode;
	}
	
	
	public static final <T> Function<T, Class<T>> getClassFunction() {
		return new Function<T, Class<T>>() {
			@Override
			@SuppressWarnings("unchecked")
			public Class<T> apply(T obj) {
				return (Class<T>)obj.getClass();
			}
		};
	};
	
	
	public static final Function<Object, Void> notifyFunction = new Function<Object, Void>() {
		@Override
		public Void apply(Object obj) {
			obj.notify();
			return null;
		}
	};
	
	public static final Function<Object, Void> notifyFunction() {
		return notifyFunction;
	} 


	public static final Function<Object, Void> waitFunction = new Function<Object, Void>() {
		@Override
		public Void apply(Object obj) {
			try {
				obj.wait();
				return null;
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
		}
	};
	
	public static final Function<Object, Void> waitFunction() {
		return waitFunction;
	} 



	public static final Function<Object, Void> waitFunction(final long timeout) {
		return new Function<Object, Void>() {
			@Override
			public Void apply(Object obj) {
				try {
					obj.wait(timeout);
					return null;
				} catch (InterruptedException e) {
					throw new IllegalStateException(e);
				}
			}
		};
	} 


	public static final Function<Object, Void> waitFunction(final long timeout, final int nanos) {
		return new Function<Object, Void>() {
			@Override
			public Void apply(Object obj) {
				try {
					obj.wait(timeout, nanos);
					return null;
				} catch (InterruptedException e) {
					throw new IllegalStateException(e);
				}
			}
		};
	} 
	
}
