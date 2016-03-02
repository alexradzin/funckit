package org.funckit.lang;

import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.base.Function;

public class PatternFunctions {
	public static final Function<String, Pattern> pattern = new Function<String, Pattern>() {
		@Override
		public Pattern apply(String regex) {
			return Pattern.compile(regex);
		}
	};

	public static final Function<String, Pattern> pattern() {
		return pattern;
	}

	public static final Function<String, Pattern> compile() {
		return pattern;
	}
	

	public static final Function<String, String> group(Pattern pattern, int group) {
		return null;
	}
	
	public static final Function<String, Matcher> matcher(Pattern pattern) {
		return null;
	}
	
//	public static final Function<CharSequence, Matcher> matcher(final Pattern pattern) {
//		return new Function<CharSequence, Matcher>() {
//			@Override
//			public Matcher apply(CharSequence input) {
//				return pattern.matcher(input);
//			}
//		};
//	}


	public static final Function<Map.Entry<Pattern, Integer>, String> group(final CharSequence input) {
		return new Function<Map.Entry<Pattern, Integer>, String>() {
			@Override
			public String apply(Entry<Pattern, Integer> pg) {
				Pattern p = pg.getKey();
				Matcher m = p.matcher(input);
				return m.find() ? m.group(pg.getValue()) : null;
			}
		};
	}
	
	
	public static final Function<Pattern, Matcher> matcher(final CharSequence input) {
		return new Function<Pattern, Matcher>() {
			@Override
			public Matcher apply(Pattern pattern) {
				return pattern.matcher(input);
			}
		};
	}
	
	
	public static final Function<Matcher, String> group(final int group) {
		return new Function<Matcher, String>() {
			@Override
			public String apply(Matcher matcher) {
				return matcher.find(0) ? matcher.group(group) : null;
			}
		};
	}
	
//	public static void examples() {
//		List<String> regexs = null;
//		FluentIterable.from(regexs).transform(pattern).transform(matcher("foo bar")).transform(group(5));
//		
//		List<String> strings = null;
//		FluentIterable.from(strings).transform(group(Pattern.compile("aaaa"), 2));
//		
//		FluentIterable.from(strings).transform(matcher(Pattern.compile("aaaa"))).transform(group(3));
//		
//		FluentIterable.from(strings).transform(matcher(Pattern.compile("aaaa"))).filter(PatternPredicates.matches()).transform(group(2));
//		
//	}
}
