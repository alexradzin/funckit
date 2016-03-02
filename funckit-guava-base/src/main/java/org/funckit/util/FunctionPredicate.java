package org.funckit.util;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

public class FunctionPredicate<T> implements Predicate<T> {
	private final Function<T, Boolean> function;
	
	public FunctionPredicate(Function<T, Boolean> function) {
		super();
		this.function = function;
	}

	@Override
	public boolean apply(T input) {
		return function.apply(input);
	}

	
	@Override
	public int hashCode() {
		return function.hashCode();
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		return (getClass().equals(obj.getClass()) && function.equals(((FunctionPredicate<T>)obj).function));
	}	
	
}
