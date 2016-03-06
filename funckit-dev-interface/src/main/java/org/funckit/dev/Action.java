package org.funckit.dev;

public interface Action<P, R> {
	public R perform(P p);
}
