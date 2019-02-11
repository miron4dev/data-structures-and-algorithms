package com.miron4dev.dsa.stack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinStackUnitTest {

	@Test
	public void test() {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);

		assertEquals(-3, minStack.getMin());
		minStack.pop();
		assertEquals(0, minStack.top());
		assertEquals(-2, minStack.getMin());
	}

}