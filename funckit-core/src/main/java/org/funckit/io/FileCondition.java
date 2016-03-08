package org.funckit.io;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

import org.funckit.common.BaseCondition;

public abstract class FileCondition extends BaseCondition<File> implements FileFilter, FilenameFilter {
	protected FileCondition(Object... params) {
		super(params);
	}

	@Override
	protected abstract boolean check(File p);

	@Override
	public boolean accept(File dir, String name) {
		return accept(new File(dir, name));
	}

	@Override
	public boolean accept(File file) {
		return check(file);
	}

}
