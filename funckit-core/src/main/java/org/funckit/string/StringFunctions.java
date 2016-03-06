package org.funckit.string;

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
	
//	public static final Function<String, Integer> length() {
//		return length;
//	}

	public static final BaseAction<String, Integer> stringLength() {
		return length;
	}


	public static final BaseAction<String, Integer> indexOf(final char ch) {
		return new IndexOfChar(ch);
	};
	public static final BaseAction<String, Integer> indexOfIgnoreCase(final char ch) {
		if(!Character.isUpperCase(ch) && !Character.isLowerCase(ch)) {
			// neither upper nor lower case - case insensitive search is irrelevant, so we can perform regular search
			return indexOf(ch);
		}
		return new IndexOfCharIgnoreCase(ch);
	};
	
	
	public static final BaseAction<CharSequence, Integer> indexOf(final String str) {
		return new IndexOfString(str);
	};
	
	public static final BaseAction<CharSequence, Integer> indexOfIgnoreCase(final CharSequence str) {
		return new IndexOfStringIgnoreCase(str);
	};
	
	public static final BaseAction<String, String> substring(int start) {
		return new SubString1(start);
	}
	
	// TODO
	// format
}
