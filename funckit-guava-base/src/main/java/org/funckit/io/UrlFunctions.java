package org.funckit.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.google.common.base.Function;

public class UrlFunctions {
	public static final Function<String, URL> url = new Function<String, URL>() {
		@Override
		public URL apply(String spec) {
			try {
				return new URL(spec);
			} catch (MalformedURLException e) {
				throw new IllegalArgumentException(spec, e);
			}
		}
	};

	public static final Function<URL, URLConnection> urlConnection = new Function<URL, URLConnection>() {
		@Override
		public URLConnection apply(URL url) {
			try {
				return url.openConnection();
			} catch (IOException e) {
				throw new IllegalStateException(String.valueOf(url), e);
			}
		}
	};
	
	public static final Function<URLConnection, InputStream> urlIn = new Function<URLConnection, InputStream>() {
		@Override
		public InputStream apply(URLConnection connection) {
			try {
				return connection.getInputStream();
			} catch (IOException e) {
				throw new IllegalStateException(String.valueOf(connection.getURL()), e);
			}
		}
	};
	
}
