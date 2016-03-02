package org.funckit.util;

import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;

/**
 * This is just a trivial wrapper that transforms {@link Iterator} into {@link Iterable}.
 * This class is lazy, it does not copy anything, does not call
 * any method of {@link Iterator} itself. This is not the same as using Guava's
 * {@code ImmutableList.copyOf()} that indeed creates copy, i.e. runs iterator until its end.
 */
public class IterableIterator<T> implements Iterable<T>, Closeable {
	private final Iterator<T> iterator;

	private IterableIterator(Iterator<T> iterator) {
		if (iterator == null) {
			throw new NullPointerException();
		}
		this.iterator = iterator;
	}

	@Override
	public Iterator<T> iterator() {
		return iterator;
	}

	public static <T> Iterable<T> of(Iterator<T> it) {
		return new IterableIterator<T>(it);
	}

	@Override
	public void close() throws IOException {
		if (iterator instanceof Closeable) {
			Closeable closable = (Closeable)iterator;
			closable.close();
		}
	}
}
