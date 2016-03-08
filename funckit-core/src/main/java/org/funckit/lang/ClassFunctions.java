package org.funckit.lang;

import org.funckit.common.BaseAction;

public class ClassFunctions {
	public static final BaseAction<String, Class<?>> classForName = new BaseAction<String, Class<?>>() {
		@Override
		public Class<?> execute(String name) {
			try {
				return Class.forName(name);
			} catch (ClassNotFoundException e) {
				throw new IllegalArgumentException(e);
			}
		}
	};
	
	public static final BaseAction<Class<?>, String> className = new BaseAction<Class<?>, String>() {
		@Override
		public String execute(Class<?> clazz) {
			return clazz.getName();
		}
	};

	public static final BaseAction<Class<?>, String> simpleClassName = new BaseAction<Class<?>, String>() {
		@Override
		public String execute(Class<?> clazz) {
			return clazz.getSimpleName();
		}
	};
}
