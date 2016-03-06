package org.funckit.string;

import org.funckit.common.BaseAction;

class SubSequence extends BaseAction<CharSequence, CharSequence> {
	private final int start;
	private final int end;
	
	public SubSequence(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	public CharSequence execute(CharSequence input) {
		return input.subSequence(start, end);
	}
}
