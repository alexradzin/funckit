package org.funckit.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.funckit.common.BaseAction;

public class FileOutputStreamFunction extends BaseAction<File, OutputStream> {
	public FileOutputStreamFunction() {
		this(false);
	}

	public FileOutputStreamFunction(boolean append) {
		super(append);
	}


	@Override
	public OutputStream execute(File file) {
		try {
			boolean append = (Boolean)getParameters()[0];
			return new FileOutputStream(file, append);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException(file.getPath(), e);
		}
	}

}
