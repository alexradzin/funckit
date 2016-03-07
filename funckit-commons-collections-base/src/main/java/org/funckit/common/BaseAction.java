package org.funckit.common;

import org.apache.commons.collections.Transformer;


public abstract class BaseAction<F, T> extends BaseParamHolder implements Transformer {
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
