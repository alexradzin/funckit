package org.funckit.string;

import java.util.regex.Pattern;

import org.funckit.common.BaseCondition;

abstract class PatternPredicate extends BaseCondition<CharSequence> {
	protected final Pattern pattern;
	
	PatternPredicate(Pattern pattern) {
		super(pattern);
		this.pattern = pattern;
	}
	


	static class PatternMatchPredicate extends PatternPredicate {
		PatternMatchPredicate(Pattern pattern) {
			super(pattern);
		}

		@Override
		public boolean check(CharSequence input) {
			return pattern.matcher(input).matches();
		}
	}

	static class PatternFindPredicate extends PatternPredicate {
		PatternFindPredicate(Pattern pattern) {
			super(pattern);
		}

		@Override
		public boolean check(CharSequence input) {
			return pattern.matcher(input).find();
		}
	}

	static class PatternFindFromPredicate extends PatternPredicate {
		private final int start;
		
		PatternFindFromPredicate(Pattern pattern, int start) {
			super(pattern);
			this.start = start;
		}

		@Override
		public boolean check(CharSequence input) {
			return pattern.matcher(input).find(start);
		}
		
		
		@Override
		public int hashCode() {
			return 31 * super.hashCode() + start;
		}

		@Override
		public boolean equals(Object obj) {
			if (!super.equals(obj)) {
				return false;
			}
			
			return start == ((PatternFindFromPredicate)obj).start; 
		}
		
	}
}
