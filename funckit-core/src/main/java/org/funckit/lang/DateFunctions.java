package org.funckit.lang;

import java.util.Calendar;
import java.util.Date;

import org.funckit.common.BaseAction;

public class DateFunctions {
	public static final BaseAction<Long, Date> date = new BaseAction<Long, Date>() {
		@Override
		public Date execute(Long timestamp) {
			return new Date(timestamp);
		}
	};

	public static final BaseAction<Date, Long> time = new BaseAction<Date, Long>() {
		@Override
		public Long execute(Date d) {
			return d.getTime();
		}
	};

	public static final BaseAction<Long, java.sql.Date> sqlDate = new BaseAction<Long, java.sql.Date>() {
		@Override
		public java.sql.Date execute(Long timestamp) {
			return new java.sql.Date(timestamp);
		}
	};

	public static final BaseAction<java.sql.Date, Long> sqlTime = new BaseAction<java.sql.Date, Long>() {
		@Override
		public Long execute(java.sql.Date d) {
			return d.getTime();
		}
	};
	
	public static final BaseAction<Date, java.sql.Date> toSqlDate = new BaseAction<Date, java.sql.Date>() {
		@Override
		public java.sql.Date execute(Date d) {
			return new java.sql.Date(d.getTime());
		}
	};
	
	public static final BaseAction<java.sql.Date, Date> fromSqlDate = new BaseAction<java.sql.Date, Date>() {
		@Override
		public Date execute(java.sql.Date d) {
			return new Date(d.getTime());
		}
	};
	

	public static final BaseAction<Date, Calendar> calendarForDate = new BaseAction<Date, Calendar>() {
		@Override
		public Calendar execute(Date d) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(d);
			return calendar;
		}
	};

	public static final BaseAction<Long, Calendar> calendarForTime = new BaseAction<Long, Calendar>() {
		@Override
		public Calendar execute(Long millis) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(millis);
			return calendar;
		}
	};
	
}
