package org.funckit.io;

import java.io.File;

import com.google.common.base.Predicate;

public class FilePredicates {
	public static final Predicate<File> canRead = new Predicate<File>() {
		@Override
		public boolean apply(File file) {
			return file.canRead();
		}
	};

	public static final Predicate<File> canWrite = new Predicate<File>() {
		@Override
		public boolean apply(File file) {
			return file.canWrite();
		}
	};
		
	public static final Predicate<File> canExecute = new Predicate<File>() {
		@Override
		public boolean apply(File file) {
			return file.canExecute();
		}
	};

	public static final Predicate<File> exists = new Predicate<File>() {
		@Override
		public boolean apply(File file) {
			return file.exists();
		}
	};
	
	public static final Predicate<File> isAbsolute = new Predicate<File>() {
		@Override
		public boolean apply(File file) {
			return file.isAbsolute();
		}
	};
	
	public static final Predicate<File> isDirectory = new Predicate<File>() {
		@Override
		public boolean apply(File file) {
			return file.isDirectory();
		}
	};
	
	public static final Predicate<File> isFile = new Predicate<File>() {
		@Override
		public boolean apply(File file) {
			return file.isFile();
		}
	};
	
	public static final Predicate<File> isHidden = new Predicate<File>() {
		@Override
		public boolean apply(File file) {
			return file.isHidden();
		}
	};
	
	
	
	public static final Predicate<File> canExecute() {
		return canExecute;
	}
	public static final Predicate<File> isExecutable() {
		return canExecute;
	}
	public static final Predicate<File> canRead() {
		return canRead;
	}
	public static final Predicate<File> isReadable() {
		return canRead;
	}
	public static final Predicate<File> canWrite() {
		return canWrite;
	}
	public static final Predicate<File> isWritable() {
		return canWrite;
	}
	public static final Predicate<File> exists() {
		return exists;
	}
	public static final Predicate<File> isAbsolute() {
		return isAbsolute;
	}
	public static final Predicate<File> isDirectory() {
		return isDirectory;
	}
	public static final Predicate<File> isFile() {
		return isFile;
	}
	public static final Predicate<File> isHidden() {
		return isHidden;
	}
}

