package org.funckit.common;

import com.google.common.base.Predicate;

public abstract class BaseCondition<T> extends BaseParamHolder implements Predicate<T> {
	public BaseCondition(Object ... params) {
		super(params);
	}

	@Override
	public boolean apply(T input) {
		return check(input);
	}
	
	
	protected abstract boolean check(T p);
	
	

}
