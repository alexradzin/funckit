package org.funckit.util;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

public class PredicateFunction<T> implements Function<T, Boolean> {
	private final Predicate<T> predicate;
	
	public PredicateFunction(Predicate<T> predicate) {		
		super();
		this.predicate = predicate;
	}

	@Override
	public Boolean apply(T input) {
		return predicate.apply(input);	
	}

	@Override
	public int hashCode() {
		return predicate.hashCode();
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
		return (getClass().equals(obj.getClass()) && predicate.equals(((PredicateFunction<T>)obj).predicate));
	}	
}
