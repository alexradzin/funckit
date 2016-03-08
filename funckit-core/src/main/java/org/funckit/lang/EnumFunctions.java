package org.funckit.lang;

import org.funckit.common.BaseAction;

public class EnumFunctions {
	public static final BaseAction<Enum<?>, Integer> ordinal = new BaseAction<Enum<?>, Integer>() {
		@Override
		public Integer execute(Enum<?> e) {
			return e.ordinal();
		}
	};

	public static final BaseAction<Enum<?>, String> enumName = new BaseAction<Enum<?>, String>() {
		@Override
		public String execute(Enum<?> e) {
			return e.name();
		}
	};
	
	
	public static final <E extends Enum<E>> BaseAction<String, Enum<?>> enumValueOf(final Class<E> clazz) { 
		return new BaseAction<String, Enum<?>>() {
			@Override
			public Enum<?> execute(String name) {
				return Enum.valueOf(clazz, name);
			}
		};
	}

	public static final <E extends Enum<E>> BaseAction<Integer, Enum<?>> enumFromOrdinal(final Class<E> clazz) { 
		return new BaseAction<Integer, Enum<?>>() {
			@Override
			public Enum<?> execute(Integer o) {
				return clazz.getEnumConstants()[o];
			}
		};
	}
	
}
