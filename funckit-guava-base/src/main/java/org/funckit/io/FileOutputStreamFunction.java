package org.funckit.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.google.common.base.Function;

public class FileOutputStreamFunction implements Function<File, OutputStream> {
	private final boolean append;
	
	public FileOutputStreamFunction() {
		this(false);
	}

	public FileOutputStreamFunction(boolean append) {
		super();
		this.append = append;
	}

	
	
	@Override
	public int hashCode() {
		return append ? 1 : 0;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		return getClass() == obj.getClass() && append == ((FileOutputStreamFunction) obj).append;
	}



	@Override
	public OutputStream apply(File file) {
		try {
			return new FileOutputStream(file, append);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException(file.getPath(), e);
		}
	}

}
