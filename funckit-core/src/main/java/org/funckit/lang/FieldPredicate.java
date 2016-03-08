package org.funckit.lang;

import org.funckit.common.BaseAction;
import org.funckit.common.BaseCondition;

public class FieldPredicate<P, R> extends BaseCondition<P> {
	private BaseAction<P, R> fieldAccessor;
	private BaseCondition<R> fieldCondition;
	
	

	public FieldPredicate(BaseAction<P, R> fieldAccessor, BaseCondition<R> fieldCondition) {
		super(fieldAccessor, fieldCondition);
		this.fieldAccessor = fieldAccessor;
		this.fieldCondition = fieldCondition;
	}



	@Override
	protected boolean check(P p) {
		return fieldCondition.verify(fieldAccessor.perform(p));
	}
}
