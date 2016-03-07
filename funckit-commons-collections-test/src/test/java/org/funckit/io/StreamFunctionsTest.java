package org.funckit.io;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

public class StreamFunctionsTest {
	@Test
	public void notAvailableEmptyStream() {
		available(new ByteArrayInputStream(new byte[0]), 0);
	}

	private void available(InputStream in, int expected) {
		assertEquals(expected, StreamFunctions.available.execute(in).intValue());
	}
}
