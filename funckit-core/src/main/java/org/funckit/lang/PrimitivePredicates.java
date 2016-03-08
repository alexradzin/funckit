package org.funckit.lang;

import static java.lang.String.format;

import java.io.File;
import java.util.Collection;
import java.util.Map;

import org.funckit.common.BaseCondition;

public class PrimitivePredicates {
	public static final BlankPredicate isBlank = new BlankPredicate();

	private PrimitivePredicates() {
		// this is pure utilities class
	}

	public static <T> BaseCondition<T> eq(T base) {
		return new EqualsPredicate<T>(base);
	}

	public static <T extends Comparable<T>> BaseCondition<T> ne(T base) {
		return new ComparablePredicate<T>(base, -1, 1);
	}

	public static <T extends Comparable<T>> BaseCondition<T> gt(T base) {
		return new ComparablePredicate<T>(base, 1);
	}

	public static <T extends Comparable<T>> BaseCondition<T> lt(T base) {
		return new ComparablePredicate<T>(base, -1);
	}

	public static <T extends Comparable<T>> BaseCondition<T> ge(T base) {
		return new ComparablePredicate<T>(base, 0, 1);
	}

	public static <T extends Comparable<T>> BaseCondition<T> le(T base) {
		return new ComparablePredicate<T>(base, -1, 0);
	}



	private static final class ComparablePredicate<T extends Comparable<T>> extends BaseCondition<T> {
		private final T base;
		private final int[] signs; // negative, 0 or positive

		/**
		 *
		 * @param base
		 * @param sign negative, 0 or positive
		 */
		private ComparablePredicate(T base, int comp) {
			this.base = base;
			signs = new int[] {sign(comp)};
		}

		private ComparablePredicate(T base, int comp1, int comp2) {
			this.base = base;
			signs = new int[] {sign(comp1), sign(comp2)};
		}

		private int sign(int number) {
			return number < 0 ? -1 : number > 0 ? 1 : 0;
		}


		@Override public boolean check(T value) {
			int s;
			if (value == null) {
				s = base == null ? 0 : -1;
			} else {

				final int comp;
				if (areNumbers(base, value)) {
					comp = compNumbers(value, base);
				} else {
					comp = value.compareTo(base);
				}

				s = sign(comp);
			}
			for (int sign : signs) {
				if (s == sign) {
					return true;
				}
			}

			return false;
		}
	}


	private static final class EqualsPredicate<T> extends BaseCondition<T> {
		private final T base;

		private EqualsPredicate(T base) {
			this.base = base;
		}


		@Override
		protected boolean check(T obj) {
			if (base == obj) {
				return true;
			}
			if (base == null) {
				return false; // because obj cannot be null here (see previous if condition)
			}

			if (areNumbers(base, obj)) {
				return eqNumbers(base, obj);
			}

			if (obj != null && obj.getClass().isEnum()) {
				return castEnum(obj.getClass(), base).equals(obj);
			}

			return base.equals(obj);
		}
	}





	private static class BlankPredicate extends BaseCondition<Object> {
		@Override public boolean check(Object input) {
			if (input == null) {
				return true;
			}
			if (input instanceof CharSequence) {
				return ((CharSequence)input).length() == 0;
			}
			if (input instanceof Collection) {
				return ((Collection<?>)input).isEmpty();
			}
			if (input instanceof Map) {
				return ((Map<?, ?>)input).isEmpty();
			}
			if (input instanceof Iterable) {
				return ((Iterable<?>)input).iterator().hasNext();
			}
			if (input.getClass().isArray()) {
				return ((Object[])input).length == 0;
			}
			if (input instanceof File) {
				return ((File)input).length() == 0;
			}
			return false;
		}
	}



	/**
	 * Casts value to generic type {@code T}. The purpose of this method is to localize scope of <code>{@literal @}SuppressWarnings("unchecked")</code>
	 * @param value the value to cast
	 * @param <T> the type
	 * @return casted value
	 */
	@SuppressWarnings("unchecked")
	private static <T> T cast(Object value) {
		return (T)value;
	}


	private static <T extends Enum<T>> T castEnum(Class<?> type, Object value) {
		@SuppressWarnings("unchecked")
		Class<T> enumType = (Class<T>)type;
		if (value instanceof String) {
			return (T)Enum.valueOf(enumType, (String)value);
		}
		if (value instanceof Number) {
			return (T)enumType.getEnumConstants()[((Number)value).intValue()];
		}
		if (type.isAssignableFrom(value.getClass())) {
			return cast(value);
		}
		throw new ClassCastException(format("Cannot cast value %s to enum", value));
	}


	private static boolean areNumbers(Object one, Object two) {
		return one instanceof Number && two instanceof Number;
	}


	private static boolean eqNumbers(Object one, Object two) {
		return ((Number)one).doubleValue() == ((Number)two).doubleValue();
	}

	private static int compNumbers(Object one, Object two) {
		return Double.compare(((Number)one).doubleValue(), ((Number)two).doubleValue());
	}
}
