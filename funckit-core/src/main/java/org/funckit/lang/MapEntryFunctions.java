package org.funckit.lang;

import java.util.Map;

import org.funckit.common.BaseAction;

public class MapEntryFunctions {
	public static final <K> BaseAction<Map.Entry<K, ?>, K> key() {
		return new BaseAction<Map.Entry<K, ?>, K>() {
			@Override
			public K execute(Map.Entry<K, ?> pair) {
				return pair.getKey();
			}
		};
	}
	
	public static final <V> BaseAction<Map.Entry<?, V>, V> value() {
		return new BaseAction<Map.Entry<?, V>, V>() {
			@Override
			public V execute(Map.Entry<?, V> pair) {
				return pair.getValue();
			}
		};
	}
}
