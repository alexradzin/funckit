package org.funckit.io;

import java.io.IOException;
import java.io.InputStream;

import org.funckit.common.BaseAction;
import org.funckit.common.BaseCondition;

public class StreamFunctions {
	public static final BaseAction<InputStream, Integer> available = new BaseAction<InputStream, Integer>() {
		@Override
		public Integer execute(InputStream in) {
			try {
				return in.available();
			} catch (IOException e) {
				throw new IllegalStateException(e);
			}
		}
	};
	
	
	
	public static final BaseCondition<InputStream> isAvailable = new BaseCondition<InputStream>() {
		@Override
		protected boolean check(InputStream p) {
			return available.perform(p) > 0;
		}
	};
}
