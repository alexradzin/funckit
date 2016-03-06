package org.funckit.common;

import com.google.common.base.Function;

public abstract class BaseAction<F, T> extends BaseParamHolder implements Function<F, T> {
	public BaseAction(Object ... params) {
		super(params);
	}

	@Override
	public T apply(F input) {
		return execute(input);
	}
	
	public abstract T execute(F p);
}
