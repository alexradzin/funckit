package org.funckit.string;

import org.apache.commons.lang3.StringUtils;
import org.funckit.common.BaseAction;

abstract class IndexOf<S extends CharSequence, T> extends BaseAction<S, Integer> {
	protected final T t;
	protected final int fromIndex;

	
	private IndexOf(T t) {
		this(t, 0);
	}
	
	protected IndexOf(T t, int fromIndex) {
		super(t, fromIndex);
		this.t = t;
		this.fromIndex = fromIndex;
	}

	@Override
	public abstract Integer execute(S str);

	
	
	static class IndexOfChar extends IndexOf<String, Character> {
		IndexOfChar(Character t) {
			super(t);
		}

		@Override
		public Integer execute(String str) {
			return str.indexOf(t);
		}
	}
	
	static class IndexOfCharIgnoreCase extends IndexOfChar {
		IndexOfCharIgnoreCase(Character ch) {
			super(ch);
			if (ch >= Character.MIN_SUPPLEMENTARY_CODE_POINT) {
				throw new UnsupportedOperationException("No case insensitive indexOf for supplementary characters (" + ch + ")");
			}
		}

		@Override
		public Integer execute(String str) {
            final char[] value = str.toCharArray();
            final int max = value.length;
            for (int i = fromIndex; i < max; i++) {
                if (value[i] == t || Character.toLowerCase(value[i]) == Character.toLowerCase(t) || Character.toUpperCase(value[i]) == Character.toUpperCase(t)) {
                    return i;
                }
            }
            
			return -1;
		}
	}


	static class IndexOfString extends IndexOf<CharSequence, CharSequence> {
		IndexOfString(CharSequence t) {
			super(t);
		}
		
		IndexOfString(CharSequence t, int fromIndex) {
			super(t, fromIndex);
		}

		@Override
		public Integer execute(CharSequence str) {
			return StringUtils.indexOf(str, t, fromIndex);
		}
	}
	
	static class IndexOfStringIgnoreCase extends IndexOfString {
		IndexOfStringIgnoreCase(CharSequence t) {
			super(t);
		}
		
		IndexOfStringIgnoreCase(CharSequence t, int fromIndex) {
			super(t, fromIndex);
		}

		@Override
		public Integer execute(CharSequence str) {
			return StringUtils.indexOfIgnoreCase(str, t, fromIndex);
		}
	}
}
