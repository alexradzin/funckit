package org.funckit.io;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

import org.funckit.common.BaseCondition;

public class FilePredicates {
	public static final FileCondition canRead = new FileCondition() {
		@Override
		public boolean check(File file) {
			return file.canRead();
		}
	};

	public static final FileCondition canWrite = new FileCondition() {
		@Override
		public boolean check(File file) {
			return file.canWrite();
		}
	};
		
	public static final FileCondition canExecute = new FileCondition() {
		@Override
		public boolean check(File file) {
			return file.canExecute();
		}
	};

	public static final FileCondition exists = new FileCondition() {
		@Override
		public boolean check(File file) {
			return file.exists();
		}
	};
	
	public static final FileCondition isAbsolute = new FileCondition() {
		@Override
		public boolean check(File file) {
			return file.isAbsolute();
		}
	};
	
	public static final FileCondition isDirectory = new FileCondition() {
		@Override
		public boolean check(File file) {
			return file.isDirectory();
		}
	};
	
	public static final FileCondition isFile = new FileCondition() {
		@Override
		public boolean check(File file) {
			return file.isFile();
		}
	};
	
	public static final FileCondition isHidden = new FileCondition() {
		@Override
		public boolean check(File file) {
			return file.isHidden();
		}
	};

	
	public static final FileCondition matchesWildcard(final String wildcard) {
		return new FileCondition(wildcard) {
			private final Pattern p = Pattern.compile(wildcard.replace('?', '.').replace("*", ".*"));
			@Override
			public boolean check(File file) {
				return p.matcher(file.getPath()).find();
			}
		};
	}
	
	
	public static final BaseCondition<File> predicate(final FileFilter filter) {
		return new BaseCondition<File>(filter) {
			@Override
			protected boolean check(File file) {
				return filter.accept(file);
			}
		};
	}

	public static final BaseCondition<File> predicate(final FilenameFilter filter) {
		return new BaseCondition<File>(filter) {
			@Override
			protected boolean check(File file) {
				return filter.accept(file.getParentFile(), file.getName());
			}
		};
	}
	
	
	public static final FileFilter fileFilter(final BaseCondition<File> condition) {
		return new FileFilter() {
			@Override
			public boolean accept(File file) {
				return condition.verify(file);
			}
		};
	}

	public static final FilenameFilter filenameFilter(final BaseCondition<File> condition) {
		return new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return condition.verify(new File(dir, name));
			}
		};
	}
}

