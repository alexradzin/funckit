package org.funckit.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import org.funckit.common.BaseAction;

public class FileFunctions {
	public static final BaseAction<String, File> fileFromPath = new BaseAction<String, File>() {
		@Override
		public File execute(String path) {
			return new File(path);
		}
	};
	
	
	public static final BaseAction<String, File> fileFromPath() {
		return fileFromPath;
	}

	
	public static final BaseAction<URI, File> fileFromUri = new BaseAction<URI, File>() {
		@Override
		public File execute(URI uri) {
			return new File(uri);
		}
	};

	
	public static final BaseAction<URI, File> fileFromUri() {
		return fileFromUri;
	}
	
	public static final BaseAction<File, Long> length = new BaseAction<File, Long>() {
		@Override
		public Long execute(File file) {
			return file.length();
		}
	};
	
	public static final BaseAction<File, Long> length() {
		return length;
	}
	
	public static final BaseAction<File, Long> fileLength() {
		return length;
	}
	
	
	public static final BaseAction<File, InputStream> fis = new BaseAction<File, InputStream>() {
		@Override
		public InputStream execute(File file) {
			try {
				return new FileInputStream(file);
			} catch (FileNotFoundException e) {
				throw new IllegalArgumentException(file.getPath(), e);
			}
		}
	};
	
	public static final BaseAction<File, OutputStream> fos = new FileOutputStreamFunction(); 
	public static final BaseAction<File, OutputStream> fosa = new FileOutputStreamFunction(true);
	
	
	public static final BaseAction<File, InputStream> fis() {
		return fis;
	}
	public static final BaseAction<File, OutputStream> fos() {
		return fos;
	}
	public static final BaseAction<File, OutputStream> fos(boolean append) {
		return append ? fosa : fos;
	}
	

	public static final BaseAction<File, String> fileParent = new BaseAction<File, String>() {
		@Override
		public String execute(File file) {
			return file.getParent();
		}
	};

	public static final BaseAction<File, File> parentFile = new BaseAction<File, File>() {
		@Override
		public File execute(File file) {
			return file.getParentFile();
		}
	};
	
	public static final BaseAction<File, String[]> list = new BaseAction<File, String[]>() {
		@Override
		public String[] execute(File file) {
			return file.list();
		}
	};

	public static final BaseAction<File, File[]> listFiles = new BaseAction<File, File[]>() {
		@Override
		public File[] execute(File file) {
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

