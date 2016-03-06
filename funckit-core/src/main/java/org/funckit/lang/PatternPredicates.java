package org.funckit.lang;

import java.util.regex.Matcher;

import org.funckit.common.BaseCondition;

public class PatternPredicates {
	public static final BaseCondition<Matcher> matches() {
		return new BaseCondition<Matcher>() {
			@Override
			public boolean check(Matcher matcher) {
				return matcher.matches();
			}
			
		};
	}

}
