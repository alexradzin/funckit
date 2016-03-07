package org.funckit.common;

import org.apache.commons.collections.Predicate;

public abstract class BaseCondition<T> extends BaseParamHolder implements Predicate {
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
