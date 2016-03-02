package org.funckit.lang;

import java.util.Calendar;
import java.util.Date;

import com.google.common.base.Function;

public class DateFunctions {
	public static final Function<Long, Date> date = new Function<Long, Date>() {
		@Override
		public Date apply(Long timestamp) {
			return new Date(timestamp);
		}
	};

	public static final Function<Date, Long> time = new Function<Date, Long>() {
		@Override
		public Long apply(Date date) {
			return date.getTime();
		}
	};

	public static final Function<Long, java.sql.Date> sqlDate = new Function<Long, java.sql.Date>() {
		@Override
		public java.sql.Date apply(Long timestamp) {
			return new java.sql.Date(timestamp);
		}
	};

	public static final Function<java.sql.Date, Long> sqlTime = new Function<java.sql.Date, Long>() {
		@Override
		public Long apply(java.sql.Date date) {
			return date.getTime();
		}
	};
	
	public static final Function<Date, java.sql.Date> toSqlDate = new Function<Date, java.sql.Date>() {
		@Override
		public java.sql.Date apply(Date date) {
			return new java.sql.Date(date.getTime());
		}
	};
	
	public static final Function<java.sql.Date, Date> fromSqlDate = new Function<java.sql.Date, Date>() {
		@Override
		public Date apply(java.sql.Date date) {
			return new Date(date.getTime());
		}
	};
	

	public static final Function<Date, Calendar> calendarForDate = new Function<Date, Calendar>() {
		@Override
		public Calendar apply(Date date) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar;
		}
	};

	public static final Function<Long, Calendar> calendarForTime = new Function<Long, Calendar>() {
		@Override
		public Calendar apply(Long millis) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(millis);
			return calendar;
		}
	};
	
}
