package org.funckit.common;

import org.funckit.dev.Condition;

public abstract class BaseCondition<P> extends BaseParamHolder implements Condition<P> {
	protected BaseCondition(Object... params) {
		super(params);
	}

	@Override
	public boolean verify(P p) {
		return check(p);
	}
	
	protected abstract boolean check(P p);
}
