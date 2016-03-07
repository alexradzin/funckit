package org.funckit.common;

import org.apache.commons.collections4.Transformer;


public abstract class BaseAction<F, T> extends BaseParamHolder implements Transformer<F, T> {
	public BaseAction(Object ... params) {
		super(params);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Object transform(Object input) {
		return execute((F)input);
	}
	
	public abstract T execute(F p);
}
