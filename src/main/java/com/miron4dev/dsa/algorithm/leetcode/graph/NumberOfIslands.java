package com.miron4dev.dsa.algorithm.leetcode.graph;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * <p>
 * You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {

	public int solve(char[][] grid) {
		int counter = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					counter++;
					traverse(grid, i, j);
				}
			}
		}
		return counter;
	}

	private void traverse(char[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
			return;
		}
		grid[i][j] = '0';
		traverse(grid, i - 1, j);
		traverse(grid, i + 1, j);
		traverse(grid, i, j - 1);
		traverse(grid, i, j + 1);
	}
}
