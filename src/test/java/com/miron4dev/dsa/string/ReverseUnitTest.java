package com.miron4dev.dsa.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReverseUnitTest {

	@Test
	public void reverse() {
		Reverse reverse = new Reverse("hello");
		reverse.reverse();

		assertEquals("olleh", reverse.getString());
	}

	@Test
	public void recursionReverse() {
		Reverse reverse = new Reverse("hello");
		reverse.recursionReverse();

		assertEquals("olleh", reverse.getString());
	}
}