package org.funckit.string;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.funckit.common.BaseAction;
import org.funckit.string.IndexOf.IndexOfChar;
import org.funckit.string.IndexOf.IndexOfCharIgnoreCase;
import org.funckit.string.IndexOf.IndexOfString;
import org.funckit.string.IndexOf.IndexOfStringIgnoreCase;
import org.funckit.string.SubString.SubString1;

public class StringFunctions {
	public static final BaseAction<String, Integer> length = new BaseAction<String, Integer>() {
		@Override
		public Integer execute(String str) {
			return str.length();
		}
	};
	
	public static final BaseAction<String, Integer> stringLength = length;


	public static final BaseAction<String, Integer> indexOf(final char ch) {
		return new IndexOfChar(ch);
	}
	
	public static final BaseAction<String, Integer> indexOfIgnoreCase(final char ch) {
		if(!Character.isUpperCase(ch) && !Character.isLowerCase(ch)) {
			// neither upper nor lower case - case insensitive search is irrelevant, so we can perform regular search
			return indexOf(ch);
		}
		return new IndexOfCharIgnoreCase(ch);
	}
	
	
	public static final BaseAction<CharSequence, Integer> indexOf(final String str) {
		return new IndexOfString(str);
	}
	
	public static final BaseAction<CharSequence, Integer> indexOfIgnoreCase(final CharSequence str) {
		return new IndexOfStringIgnoreCase(str);
	}
	
	public static final BaseAction<String, String> substring(int start) {
		return new SubString1(start);
	}

	
	public static final BaseAction<String, byte[]> bytes = new BaseAction<String, byte[]>() {
		@Override
		public byte[] execute(String str) {
			return str.getBytes();
		}
	};
	
	public static final BaseAction<String, byte[]> bytes(final Charset charset) {
		return new BaseAction<String, byte[]>() {
			@Override
			public byte[] execute(String str) {
				return str.getBytes(charset);
			}
		};
	}

	public static final BaseAction<String, byte[]> bytes(final String charset) {
		return new BaseAction<String, byte[]>() {
			@Override
			public byte[] execute(String str) {
				try {
					return str.getBytes(charset);
				} catch (UnsupportedEncodingException e) {
					throw new IllegalArgumentException(e);
				}
			}
		};
	}

	
	public static final BaseAction<String, char[]> chars(final Charset charset) {
		return new BaseAction<String, char[]>() {
			@Override
			public char[] execute(String str) {
				return str.toCharArray();
			}
		};
	}

	
	public static final BaseAction<String, String> toLowerCase = new BaseAction<String, String>() {
		@Override
		public String execute(String str) {
			return str.toLowerCase();
		}
	};

	public static final BaseAction<String, String> toUpperCase = new BaseAction<String, String>() {
		@Override
		public String execute(String str) {
			return str.toUpperCase();
		}
	};
	
	public static final BaseAction<String, String> trim = new BaseAction<String, String>() {
		@Override
		public String execute(String str) {
			return str.trim();
		}
	};

	public static final BaseAction<String, Character> charAt(final int index) {
		return new BaseAction<String, Character>(index) {
			@Override
			public Character execute(String str) {
				return str.charAt(index);
			}
		};
	}
	

	public static final BaseAction<Object[], String> format(final String format) {
		return new BaseAction<Object[], String>(format) {
			@Override
			public String execute(Object[] args) {
				return String.format(format, args);
			}
		};
	}
}
