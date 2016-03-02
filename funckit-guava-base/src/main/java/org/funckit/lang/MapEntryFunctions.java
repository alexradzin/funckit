package org.funckit.lang;

import java.util.Map;

import com.google.common.base.Function;

public class MapEntryFunctions {
	public static final <K> Function<Map.Entry<K, ?>, K> key() {
		return new Function<Map.Entry<K, ?>, K>() {
			@Override
			public K apply(Map.Entry<K, ?> pair) {
				return pair.getKey();
			}
		};
	}
	
	public static final <V> Function<Map.Entry<?, V>, V> value() {
		return new Function<Map.Entry<?, V>, V>() {
			@Override
			public V apply(Map.Entry<?, V> pair) {
				return pair.getValue();
			}
		};
	}
}
