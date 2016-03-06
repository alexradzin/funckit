package org.funckit.util;

import org.funckit.common.BaseAction;
import org.funckit.common.BaseCondition;

public class PredicateFunction<T> extends BaseAction<T, Boolean> {
	private final BaseCondition<T> predicate;
	
	public PredicateFunction(BaseCondition<T> predicate) {		
		super(predicate);
		this.predicate = predicate;
	}

	@Override
	public Boolean execute(T input) {
		return predicate.verify(input);	
	}
}
