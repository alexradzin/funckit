package org.funckit.lang;

import java.util.regex.Matcher;

import com.google.common.base.Predicate;

public class PatternPredicates {
	public static final Predicate<Matcher> matches() {
		return new Predicate<Matcher>() {
			@Override
			public boolean apply(Matcher matcher) {
				return matcher.matches();
			}
			
		};
	}

}
