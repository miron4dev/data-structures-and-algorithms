package com.miron4dev.dsa.algorithm.queue;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MovingAverageUnitTest {

	private static final double ASSERT_DELTA = 0.0001;

	@Test
	public void test() {
		MovingAverage m = new MovingAverage(3);
		assertEquals(1.0, m.next(1), ASSERT_DELTA);
		assertEquals(5.5, m.next(10), ASSERT_DELTA);
		assertEquals(4.66667, m.next(3), ASSERT_DELTA);
		assertEquals(6.0, m.next(5), ASSERT_DELTA);
	}

}