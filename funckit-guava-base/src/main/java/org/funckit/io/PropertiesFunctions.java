package org.funckit.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.google.common.base.Function;

public class PropertiesFunctions {
	public static final Function<InputStream, Properties> load() {
		return new  PropertiesLoader();
	};
	
	public static final Function<InputStream, Properties> load(Properties properties) {
		return new  PropertiesLoader(properties);
	};
	
	private static class PropertiesLoader implements Function<InputStream, Properties> {
		private final Properties properties;

		public PropertiesLoader() {
			this(new Properties());
		}
		
		public PropertiesLoader(Properties properties) {
			super();
			this.properties = properties;
		}

		@Override
		public Properties apply(InputStream in) {
			try {
				properties.load(in);
			} catch (IOException e) {
				throw new IllegalArgumentException(e);
			}
			return properties;
		}
		
	}
}
