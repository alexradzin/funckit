package org.funckit.string;

import java.util.regex.Pattern;

import org.funckit.common.BaseCondition;
import org.funckit.string.PatternPredicate.PatternFindFromPredicate;
import org.funckit.string.PatternPredicate.PatternFindPredicate;
import org.funckit.string.PatternPredicate.PatternMatchPredicate;

public class StringPredicates {
	public static final BaseCondition<String> contains(final CharSequence s) {
		return new BaseCondition<String>() {
			@Override
			public boolean check(String str) {
				return str.contains(s);
			}
		};
	}
	
	public static final BaseCondition<String> equalsTo(final Object s) {
		return new BaseCondition<String>() {
			@Override
			public boolean check(String str) {
				return str.equals(s);
			}
		};
	}
	
	public static final BaseCondition<String> equalsIgnoreCase(final String s) {
		return new BaseCondition<String>() {
			@Override
			public boolean check(String str) {
				return str.equalsIgnoreCase(s);
			}
		};
	}
	
	
	public static final BaseCondition<CharSequence> matches(final Pattern pattern) {
		return new PatternMatchPredicate(pattern);
	}

	public static final BaseCondition<CharSequence> find(final Pattern pattern) {
		return new PatternFindPredicate(pattern);
	}
	
	public static final BaseCondition<CharSequence> find(final Pattern pattern, int start) {
		return new PatternFindFromPredicate(pattern, start);
	}
	
	public static final BaseCondition<String> startsWith(final String prefix) {
		return new BaseCondition<String>() {
			@Override
			public boolean check(String str) {
				return str.startsWith(prefix);
			}
		};
	}
	
	public static final BaseCondition<String> endsWith(final String suffix) {
		return new BaseCondition<String>() {
			@Override
			public boolean check(String str) {
				return str.startsWith(suffix);
			}
		};
	}

	
	public static final BaseCondition<String> isEmpty = new BaseCondition<String>() {
		@Override
		public boolean check(String str) {
			return str.isEmpty();
		}
	};
}
