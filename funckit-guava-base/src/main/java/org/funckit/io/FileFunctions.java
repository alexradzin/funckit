package org.funckit.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import com.google.common.base.Function;

public class FileFunctions {
	public static final Function<String, File> fileFromPath = new Function<String, File>() {
		@Override
		public File apply(String path) {
			return new File(path);
		}
	};
	
	
	public static final Function<String, File> fileFromPath() {
		return fileFromPath;
	}

	
	public static final Function<URI, File> fileFromUri = new Function<URI, File>() {
		@Override
		public File apply(URI uri) {
			return new File(uri);
		}
	};

	
	public static final Function<URI, File> fileFromUri() {
		return fileFromUri;
	}
	
	public static final Function<File, Long> length = new Function<File, Long>() {
		@Override
		public Long apply(File file) {
			return file.length();
		}
	};
	
	public static final Function<File, Long> length() {
		return length;
	}
	
	public static final Function<File, Long> fileLength() {
		return length;
	}
	
	
	public static final Function<File, InputStream> fis = new Function<File, InputStream>() {
		@Override
		public InputStream apply(File file) {
			try {
				return new FileInputStream(file);
			} catch (FileNotFoundException e) {
				throw new IllegalArgumentException(file.getPath(), e);
			}
		}
	};
	
	public static final Function<File, OutputStream> fos = new FileOutputStreamFunction(); 
	public static final Function<File, OutputStream> fosa = new FileOutputStreamFunction(true);
	
	
	public static final Function<File, InputStream> fis() {
		return fis;
	}
	public static final Function<File, OutputStream> fos() {
		return fos;
	}
	public static final Function<File, OutputStream> fos(boolean append) {
		return append ? fosa : fos;
	}
	

	public static final Function<File, String> fileParent = new Function<File, String>() {
		@Override
		public String apply(File file) {
			return file.getParent();
		}
	};

	public static final Function<File, File> parentFile = new Function<File, File>() {
		@Override
		public File apply(File file) {
			return file.getParentFile();
		}
	};
	
	public static final Function<File, String[]> list = new Function<File, String[]>() {
		@Override
		public String[] apply(File file) {
			return file.list();
		}
	};

	public static final Function<File, File[]> listFiles = new Function<File, File[]>() {
		@Override
		public File[] apply(File file) {
			return file.listFiles();
		}
	};
	
//	private static void foo() {
//		FluentIterable.from(Arrays.asList("foo.txt", "bar.txt")).transform(FileFunctions.fileForPath()).filter(FilePredicates.exists).transform(FileFunctions.fis);
//		
//		Properties props = new Properties();
//		FluentIterable.from(Arrays.asList("foo.txt", "bar.txt")).transform(fileForPath()).filter(FilePredicates.exists).transform(fis).transform(PropertiesFunctions.load(props));
//	}
}

