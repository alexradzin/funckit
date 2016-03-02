package org.funckit.string;

import java.util.regex.Pattern;

import com.google.common.base.Predicate;

abstract class PatternPredicate implements Predicate<CharSequence> {
	protected final Pattern pattern;
	
	PatternPredicate(Pattern pattern) {
		super();
		this.pattern = pattern;
	}
	
	@Override
	public int hashCode() {
		int hash = getClass().getName().hashCode();
		if (pattern != null) {
			hash = 31 * hash + pattern.hashCode();
		}
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj.getClass() == getClass()) {
			Pattern otherPattern = ((PatternPredicate)obj).pattern;
			return pattern == null ? otherPattern == null : pattern.equals(otherPattern);
		}
		return false; 
	}




	static class PatternMatchPredicate extends PatternPredicate {
		PatternMatchPredicate(Pattern pattern) {
			super(pattern);
		}

		@Override
		public boolean apply(CharSequence input) {
			return pattern.matcher(input).matches();
		}
	}

	static class PatternFindPredicate extends PatternPredicate {
		PatternFindPredicate(Pattern pattern) {
			super(pattern);
		}

		@Override
		public boolean apply(CharSequence input) {
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
		public boolean apply(CharSequence input) {
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
