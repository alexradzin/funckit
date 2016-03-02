package org.funckit.string;

import com.google.common.base.Function;

class SubSequence implements Function<CharSequence, CharSequence> {
	private final int start;
	private final int end;
	
	public SubSequence(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	public CharSequence apply(CharSequence input) {
		return input.subSequence(start, end);
	}
}
