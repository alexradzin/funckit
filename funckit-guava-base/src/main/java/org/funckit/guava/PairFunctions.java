package org.funckit.guava;

import org.apache.commons.lang3.tuple.Pair;

import com.google.common.base.Function;

public class PairFunctions {
	public static final <K> Function<Pair<K, ?>, K> key() {
		return new Function<Pair<K, ?>, K>() {
			@Override
			public K apply(Pair<K, ?> pair) {
				return pair.getKey();
			}
		};
	}
	
	public static final <V> Function<Pair<?, V>, V> value() {
		return new Function<Pair<?, V>, V>() {
			@Override
			public V apply(Pair<?, V> pair) {
				return pair.getValue();
			}
		};
	}

	
	public static final <L> Function<Pair<L, ?>, L> left() {
		return new Function<Pair<L, ?>, L>() {
			@Override
			public L apply(Pair<L, ?> pair) {
				return pair.getLeft();
			}
		};
	}
	
	public static final <R> Function<Pair<?, R>, R> right() {
		return new Function<Pair<?, R>, R>() {
			@Override
			public R apply(Pair<?, R> pair) {
				return pair.getRight();
			}
		};
	}
	
	
}
