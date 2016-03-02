package org.funckit.util;

import java.util.Arrays;
import java.util.Iterator;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

public class Adapters {
	public static final <T> Function<T, Boolean> function(Predicate<T> predicate) {
		return new PredicateFunction<T>(predicate);
	}

	public static final <T> Predicate<T> predicate(Function<T, Boolean> function) {
		return new FunctionPredicate<T>(function);
	}
	
	public static final <T> Iterable<T> iterable(Iterator<T> it) {
		return IterableIterator.of(it);
	}
	
	public static final <T> Iterable<T> iterable(T[] array) {
		return Arrays.asList(array);
	}
}
