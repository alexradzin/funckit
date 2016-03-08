package org.funckit.lang;

import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.funckit.common.BaseAction;

public class PatternFunctions {
	public static final BaseAction<String, Pattern> pattern = new BaseAction<String, Pattern>() {
		@Override
		public Pattern execute(String regex) {
			return Pattern.compile(regex);
		}
	};

	public static final BaseAction<String, Pattern> pattern() {
		return pattern;
	}

	public static final BaseAction<String, Pattern> compile() {
		return pattern;
	}
	

	public static final BaseAction<CharSequence, String> group(final Pattern p, final int group) {
		return new BaseAction<CharSequence, String>(p, group) {
			@Override
			public String execute(CharSequence input) {
				Matcher m = p.matcher(input);
				m.find();
				return m.group(group);
			}
		};
	}
	
	
	public static final BaseAction<CharSequence, Matcher> matcher(final Pattern p) {
		return new BaseAction<CharSequence, Matcher>(p) {
			@Override
			public Matcher execute(CharSequence input) {
				return p.matcher(input);
			}
		};
	}


	public static final BaseAction<Map.Entry<Pattern, Integer>, String> group(final CharSequence input) {
		return new BaseAction<Map.Entry<Pattern, Integer>, String>() {
			@Override
			public String execute(Entry<Pattern, Integer> pg) {
				Pattern p = pg.getKey();
				Matcher m = p.matcher(input);
				return m.find() ? m.group(pg.getValue()) : null;
			}
		};
	}
	
	
	public static final BaseAction<Pattern, Matcher> matcher(final CharSequence input) {
		return new BaseAction<Pattern, Matcher>() {
			@Override
			public Matcher execute(Pattern p) {
				return p.matcher(input);
			}
		};
	}
	
	
	public static final BaseAction<Matcher, String> group(final int group) {
		return new BaseAction<Matcher, String>() {
			@Override
			public String execute(Matcher matcher) {
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
