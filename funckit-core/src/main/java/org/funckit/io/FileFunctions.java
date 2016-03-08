package org.funckit.io;

import static org.funckit.io.FilePredicates.isDirectory;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import org.funckit.common.BaseAction;
import org.funckit.common.BaseCondition;

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

	public static final BaseAction<File, Long> lastModified = new BaseAction<File, Long>() {
		@Override
		public Long execute(File file) {
			return file.lastModified();
		}
	};
	
	
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
	
	public static final BaseAction<File, File[]> listFiles(final FileFilter fileFilter) {
		return new BaseAction<File, File[]>() {
			@Override
			public File[] execute(File file) {
				return file.listFiles(fileFilter);
			}
		};
	}	

	public static final BaseAction<File, File[]> listFiles(final FilenameFilter filenameFilter) {
		return new BaseAction<File, File[]>() {
			@Override
			public File[] execute(File file) {
				return file.listFiles(filenameFilter);
			}
		};
	}
	
	public static final BaseAction<File, File[]> listFiles(final BaseCondition<File> condition) {
		return new BaseAction<File, File[]>(condition) {
			private final FileFilter filter = FilePredicates.fileFilter(condition);
			@Override
			public File[] execute(File file) {
				return file.listFiles(filter);
			}
		};
	}
	
	
	public static final BaseAction<File, File[]> tree(final FileFilter fileFilter) {
		return new BaseAction<File, File[]>(fileFilter) {
			@Override
			public File[] execute(File dir) {
				List<File> files = new ArrayList<File>();
				execute(dir, files);
				return files.toArray(new File[files.size()]);
			}
			
			private void execute(File dir, List<File> files) {
				if (!dir.isDirectory() || !dir.exists()) {
					return;
				}
				Collection<File> subDirs = new LinkedHashSet<File>();
				for (File file : dir.listFiles(fileFilter)) {
					files.add(file);
					
					if (file.isDirectory()) {
						subDirs.add(file);
					}
				}
				for (File subDir : dir.listFiles((FileFilter)isDirectory)) {
					subDirs.add(subDir);
				}
				for (File subDir : subDirs) {
					execute(subDir, files);
				}
			}
		};
	}	
	
}

