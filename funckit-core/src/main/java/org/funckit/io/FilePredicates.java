package org.funckit.io;

import java.io.File;


import org.funckit.common.BaseCondition;

public class FilePredicates {
	public static final BaseCondition<File> canRead = new BaseCondition<File>() {
		@Override
		public boolean check(File file) {
			return file.canRead();
		}
	};

	public static final BaseCondition<File> canWrite = new BaseCondition<File>() {
		@Override
		public boolean check(File file) {
			return file.canWrite();
		}
	};
		
	public static final BaseCondition<File> canExecute = new BaseCondition<File>() {
		@Override
		public boolean check(File file) {
			return file.canExecute();
		}
	};

	public static final BaseCondition<File> exists = new BaseCondition<File>() {
		@Override
		public boolean check(File file) {
			return file.exists();
		}
	};
	
	public static final BaseCondition<File> isAbsolute = new BaseCondition<File>() {
		@Override
		public boolean check(File file) {
			return file.isAbsolute();
		}
	};
	
	public static final BaseCondition<File> isDirectory = new BaseCondition<File>() {
		@Override
		public boolean check(File file) {
			return file.isDirectory();
		}
	};
	
	public static final BaseCondition<File> isFile = new BaseCondition<File>() {
		@Override
		public boolean check(File file) {
			return file.isFile();
		}
	};
	
	public static final BaseCondition<File> isHidden = new BaseCondition<File>() {
		@Override
		public boolean check(File file) {
			return file.isHidden();
		}
	};
	
	
	
	public static final BaseCondition<File> canExecute() {
		return canExecute;
	}
	public static final BaseCondition<File> isExecutable() {
		return canExecute;
	}
	public static final BaseCondition<File> canRead() {
		return canRead;
	}
	public static final BaseCondition<File> isReadable() {
		return canRead;
	}
	public static final BaseCondition<File> canWrite() {
		return canWrite;
	}
	public static final BaseCondition<File> isWritable() {
		return canWrite;
	}
	public static final BaseCondition<File> exists() {
		return exists;
	}
	public static final BaseCondition<File> isAbsolute() {
		return isAbsolute;
	}
	public static final BaseCondition<File> isDirectory() {
		return isDirectory;
	}
	public static final BaseCondition<File> isFile() {
		return isFile;
	}
	public static final BaseCondition<File> isHidden() {
		return isHidden;
	}
}

