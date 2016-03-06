package org.funckit.util;

import org.funckit.common.BaseAction;
import org.funckit.common.BaseCondition;

public class FunctionPredicate<T> extends BaseCondition<T> {
	private final BaseAction<T, Boolean> function;
	
	public FunctionPredicate(BaseAction<T, Boolean> function) {
		super(function);
		this.function = function;
	}

	@Override
	public boolean check(T input) {
		return function.execute(input);
	}
}
