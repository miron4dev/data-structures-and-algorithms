package com.miron4dev.dsa.algorithm.stack;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class DailyTemperaturesUnitTest {

	@Test
	public void solve() {
		DailyTemperatures dailyTemperatures = new DailyTemperatures();
		int[] temperatures = new int[] { 73, 74, 75, 71, 69, 72, 76, 73 };

		int[] expected = new int[] { 1, 1, 4, 2, 1, 1, 0, 0 };

		assertArrayEquals(expected, dailyTemperatures.solve(temperatures));
	}
}