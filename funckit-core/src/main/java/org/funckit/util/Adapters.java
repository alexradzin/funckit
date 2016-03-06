package org.funckit.util;

import java.util.Arrays;
import java.util.Iterator;

import org.funckit.common.BaseAction;
import org.funckit.common.BaseCondition;

public class Adapters {
	public static final <T> BaseAction<T, Boolean> function(BaseCondition<T> predicate) {
		return new PredicateFunction<T>(predicate);
	}

	public static final <T> BaseCondition<T> predicate(BaseAction<T, Boolean> function) {
		return new FunctionPredicate<T>(function);
	}
	
	public static final <T> Iterable<T> iterable(Iterator<T> it) {
		return IterableIterator.of(it);
	}
	
	public static final <T> Iterable<T> iterable(T[] array) {
		return Arrays.asList(array);
	}
}
