package org.funckit.common;

import org.funckit.dev.Action;

public abstract class BaseAction<P, R> extends BaseParamHolder implements Action<P, R> {
	protected BaseAction(Object... params) {
		super(params);
	}
	
	public R perform(P p) {
		return execute(p);
	}

	public abstract R execute(P p);
}

