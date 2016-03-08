package org.funckit.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.funckit.common.BaseAction;

public class PropertiesFunctions {
	public static final BaseAction<InputStream, Properties> load() {
		return new  PropertiesLoader();
	}
	
	public static final BaseAction<InputStream, Properties> load(Properties properties) {
		return new  PropertiesLoader(properties);
	}
	
	private static class PropertiesLoader extends BaseAction<InputStream, Properties> {
		private final Properties properties;

		public PropertiesLoader() {
			this(new Properties());
		}
		
		public PropertiesLoader(Properties properties) {
			super();
			this.properties = properties;
		}

		@Override
		public Properties execute(InputStream in) {
			try {
				properties.load(in);
			} catch (IOException e) {
				throw new IllegalArgumentException(e);
			}
			return properties;
		}
		
	}
}
