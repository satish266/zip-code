package com.sonoma.challenge.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ZipRangeExceptionTest {

	@Test
	public void testWithEmptyArgs() {
		ZipRangeException exception = new ZipRangeException();
		Assertions.assertNotNull(exception);
	}

	@Test
	public void testWithArg() {
		ZipRangeException exception = new ZipRangeException("message");
		Assertions.assertNotNull(exception);
	}

	@Test
	public void testWithArgs() {
		ZipRangeException exception = new ZipRangeException("message", "details");
		Assertions.assertNotNull(exception);
	}
}
