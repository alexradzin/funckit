package org.funckit.string;

import org.funckit.common.BaseAction;

abstract class SubString extends BaseAction<String, String> {
	protected final int start;
	protected final int end;
	
	private SubString(int start, int end) {
		super(start, end);
		this.start = start;
		this.end = end;
	}

	@Override
	public String execute(String input) {
		return input.substring(start, end);
	}
	
	static class SubString1 extends SubString {
		SubString1(int start) {
			super(start, -1);
		}
		@Override
		public String execute(String input) {
			return input.substring(start);
		}
	}

	static class SubString2 extends SubString {
		SubString2(int start) {
			super(start, -1);
		}
		@Override
		public String execute(String input) {
			return input.substring(start, end);
		}
	}
}
