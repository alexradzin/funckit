package org.funckit.string;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Function;

abstract class IndexOf<S extends CharSequence, T> implements Function<S, Integer> {
	protected final T t;
	protected final int fromIndex;

	
	private IndexOf(T t) {
		this(t, 0);
	}
	
	protected IndexOf(T t, int fromIndex) {
		super();
		this.t = t;
		this.fromIndex = fromIndex;
	}

	public abstract Integer apply(S str);

	@Override
	public int hashCode() {
		int hash = getClass().getName().hashCode();
		if (t != null) {
			hash = 31 * hash + t.hashCode();
		}
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj.getClass() == getClass()) {
			@SuppressWarnings("unchecked")
			T otherValue = ((IndexOf<S, T>)obj).t;
			return t == null ? otherValue == null : t.equals(otherValue);
		}
		return false; 
	}
	
	
	static class IndexOfChar extends IndexOf<String, Character> {
		IndexOfChar(Character t) {
			super(t);
		}

		@Override
		public Integer apply(String str) {
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
		public Integer apply(String str) {
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
		public Integer apply(CharSequence str) {
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
		public Integer apply(CharSequence str) {
			return StringUtils.indexOfIgnoreCase(str, t, fromIndex);
		}
	}
}
