package com.miron4dev.dsa.algorithm.classic.graph;

import static org.junit.Assert.assertEquals;

import com.miron4dev.dsa.algorithm.leetcode.graph.NumberOfIslands;
import org.junit.Test;

public class NumberOfIslandsUnitTest {

	private final NumberOfIslands numberOfIslands = new NumberOfIslands();

	@Test
	public void solve() {
		char[][] grid = new char[][] {
				{ '1', '1', '0', '0', '0' },
				{ '1', '1', '0', '0', '0' },
				{ '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' }
		};

		assertEquals(3, numberOfIslands.solve(grid));
	}
}