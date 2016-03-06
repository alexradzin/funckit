package org.funckit.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.funckit.common.BaseAction;


public class UrlFunctions {
	public static final BaseAction<String, URL> url = new BaseAction<String, URL>() {
		@Override
		public URL execute(String spec) {
			try {
				return new URL(spec);
			} catch (MalformedURLException e) {
				throw new IllegalArgumentException(spec, e);
			}
		}
	};

	public static final BaseAction<URL, URLConnection> urlConnection = new BaseAction<URL, URLConnection>() {
		@Override
		public URLConnection execute(URL url) {
			try {
				return url.openConnection();
			} catch (IOException e) {
				throw new IllegalStateException(String.valueOf(url), e);
			}
		}
	};
	
	public static final BaseAction<URLConnection, InputStream> urlIn = new BaseAction<URLConnection, InputStream>() {
		@Override
		public InputStream execute(URLConnection connection) {
			try {
				return connection.getInputStream();
			} catch (IOException e) {
				throw new IllegalStateException(String.valueOf(connection.getURL()), e);
			}
		}
	};
	
}
