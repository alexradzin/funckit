package org.funckit.common;

import java.util.Arrays;

public abstract class BaseParamHolder {
	private final Object[] params;

	protected BaseParamHolder(Object... params) {
		this.params = Arrays.copyOf(params, params.length);
	}
	
	
	protected final Object[] getParameters() {
		return params;
	}
	
	@Override
	public int hashCode() {
		int code = getClass().hashCode();
		for (Object param : params) {
			code = 31 * code + (param == null ? 0 : param.hashCode());
		}
		return code;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!obj.getClass().equals(getClass())) {
			return false;
		}
		
		BaseParamHolder other = (BaseParamHolder)obj;
		
		return equals(params, other.params);
	}
	
	private boolean equals(Object[] one, Object[] two) {
		if (one == null) {
			return two == null;
		}
		// one is not null
		if (two == null) {
			return false;
		}
		if (one.length != two.length) {
			return false;
		}
		int n = one.length;
		for (int i = 0; i < n; i++) {
			if (!equals(one[i], two[i])) {
				return false;
			}
		}
		return true;
	}
	
	
	private boolean equals(Object one, Object two) {
		if (one == null) {
			return two == null;
		}
		// one is not null
		if (two == null) {
			return false;
		}
		return one.equals(two);
	}
	
}