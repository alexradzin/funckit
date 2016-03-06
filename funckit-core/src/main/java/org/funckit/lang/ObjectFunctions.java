package org.funckit.lang;

import org.funckit.common.BaseAction;


public class ObjectFunctions {
	public static final BaseAction<Object, Integer> hashCode = new BaseAction<Object, Integer>() {
		@Override
		public Integer execute(Object obj) {
			return obj.hashCode();
		}
	};
	
	public static final BaseAction<Object, Integer> hashCodeFunction() {
		return hashCode;
	}
	
	
	public static final <T> BaseAction<T, Class<T>> getClassFunction() {
		return new BaseAction<T, Class<T>>() {
			@Override
			@SuppressWarnings("unchecked")
			public Class<T> execute(T obj) {
				return (Class<T>)obj.getClass();
			}
		};
	};
	
	
	public static final BaseAction<Object, Void> notifyFunction = new BaseAction<Object, Void>() {
		@Override
		public Void execute(Object obj) {
			obj.notify();
			return null;
		}
	};
	
	public static final BaseAction<Object, Void> notifyFunction() {
		return notifyFunction;
	} 


	public static final BaseAction<Object, Void> waitFunction = new BaseAction<Object, Void>() {
		@Override
		public Void execute(Object obj) {
			try {
				obj.wait();
				return null;
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
		}
	};
	
	public static final BaseAction<Object, Void> waitFunction() {
		return waitFunction;
	} 



	public static final BaseAction<Object, Void> waitFunction(final long timeout) {
		return new BaseAction<Object, Void>() {
			@Override
			public Void execute(Object obj) {
				try {
					obj.wait(timeout);
					return null;
				} catch (InterruptedException e) {
					throw new IllegalStateException(e);
				}
			}
		};
	} 


	public static final BaseAction<Object, Void> waitFunction(final long timeout, final int nanos) {
		return new BaseAction<Object, Void>() {
			@Override
			public Void execute(Object obj) {
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
