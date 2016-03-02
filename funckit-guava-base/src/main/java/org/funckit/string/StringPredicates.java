package org.funckit.string;

import java.util.regex.Pattern;

import org.funckit.string.PatternPredicate.PatternFindFromPredicate;
import org.funckit.string.PatternPredicate.PatternFindPredicate;
import org.funckit.string.PatternPredicate.PatternMatchPredicate;

import com.google.common.base.Predicate;

public class StringPredicates {
	public static final Predicate<String> contains(final CharSequence s) {
		return new Predicate<String>() {
			@Override
			public boolean apply(String str) {
				return str.contains(s);
			}
		};
	};
	
	public static final Predicate<String> equalsTo(final Object s) {
		return new Predicate<String>() {
			@Override
			public boolean apply(String str) {
				return str.equals(s);
			}
		};
	};
	
	public static final Predicate<String> equalsIgnoreCase(final String s) {
		return new Predicate<String>() {
			@Override
			public boolean apply(String str) {
				return str.equalsIgnoreCase(s);
			}
		};
	};
	
	
	public static final Predicate<CharSequence> matches(final Pattern pattern) {
		return new PatternMatchPredicate(pattern);
	}

	public static final Predicate<CharSequence> find(final Pattern pattern) {
		return new PatternFindPredicate(pattern);
	}
	
	public static final Predicate<CharSequence> find(final Pattern pattern, int start) {
		return new PatternFindFromPredicate(pattern, start);
	}
	
	public static final Predicate<String> startsWith(final String prefix) {
		return new Predicate<String>() {
			@Override
			public boolean apply(String str) {
				return str.startsWith(prefix);
			}
		};
	};
	
	public static final Predicate<String> endsWith(final String suffix) {
		return new Predicate<String>() {
			@Override
			public boolean apply(String str) {
				return str.startsWith(suffix);
			}
		};
	};
	
	//TODO:
	// parseInt, parseLong etc
}
