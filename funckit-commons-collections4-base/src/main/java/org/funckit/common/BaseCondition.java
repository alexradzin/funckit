package org.funckit.common;

import org.apache.commons.collections4.Predicate;


public abstract class BaseCondition<T> extends BaseParamHolder implements Predicate<T> {
	public BaseCondition(Object ... params) {
		super(params);
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean evaluate(Object input) {
		return check((T)input);
	}
	
	
	protected abstract boolean check(T p);
	
	

}
