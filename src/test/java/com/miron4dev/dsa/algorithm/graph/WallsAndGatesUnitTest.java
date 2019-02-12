package com.miron4dev.dsa.algorithm.graph;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class WallsAndGatesUnitTest {

	private static final int INF = Integer.MAX_VALUE;

	private final WallsAndGates wallsAndGates = new WallsAndGates();

	@Test
	public void solve() {
		int[][] rooms = new int[][] {
				{ INF, -1, 0, INF },
				{ INF, INF, INF, -1 },
				{ INF, -1, INF, -1 },
				{ 0, -1, INF, INF }
		};

		int[][] expected = new int[][] {
				{ 3, -1, 0, 1 },
				{ 2, 2, 1, -1 },
				{ 1, -1, 2, -1 },
				{ 0, -1, 3, 4 }
		};

		wallsAndGates.solve(rooms);

		assertArrayEquals(expected, rooms);
	}
}