package org.funckit.io;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class IterableInputStream implements Iterable<Integer>, Closeable {
	private final InputStream in;
	
	public IterableInputStream(InputStream in) {
		super();
		this.in = in;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			@Override
			public boolean hasNext() {
				try {
					return in.available() > 0;
				} catch (IOException e) {
					throw new IllegalStateException(e);
				}
			}

			@Override
			public Integer next() {
				try {
					return in.read();
				} catch (IOException e) {
					throw new IllegalStateException(e);
				}
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException("InputStream does not support data removing");
			}
		};
	}

	@Override
	public void close() throws IOException {
		in.close();
	}

	
	private class InputStreamIterator implements Iterator<Integer> {
		@Override
		public boolean hasNext() {
			try {
				return in.available() > 0;
			} catch (IOException e) {
				throw new IllegalStateException(e);
			}
		}

		@Override
		public Integer next() {
			try {
				return in.read();
			} catch (IOException e) {
				throw new IllegalStateException(e);
			}
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("InputStream does not support data removing");
		}
	}
	
	class InputStreamIteratorWithTail extends InputStreamIterator {
		private final int[] tail;
		private int tailIndex = -1;

		public InputStreamIteratorWithTail(byte[] tail) {
			super();
			
			this.tail = new int[tail.length];
			for (int i = 0; i < tail.length; i++) {
				this.tail[i] = tail[i];
			}
		}
		
		@Override
		public boolean hasNext() {
			if (tailIndex < 0) {
				return super.hasNext();
			}
			return tailIndex < tail.length - 1;
		}
		
		@Override
		public Integer next() {
			if (tailIndex < 0) {
				int b = super.next();
				if (b != -1) {
					return b;
				} 
				tailIndex = 0;
			}
			
			return tail[tailIndex++];
		}
	}
}
