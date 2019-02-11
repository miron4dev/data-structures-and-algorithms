package com.miron4dev.dsa.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a m x n 2D grid initialized with these three possible values.
 * <p>
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 */
public class WallsAndGates {

	public void solve(int[][] rooms) {
		if (rooms.length == 0 || rooms[0].length == 0) {
			return;
		}

		Queue<int[]> queue = new LinkedList<>();

		int rows = rooms.length;
		int cols = rooms[0].length;

		// put gates to the queue
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (rooms[i][j] == 0) {
					queue.add(new int[] { i, j });
				}
			}
		}

		// while we have a point to process
		// increment distance to nearest point by 1
		while (!queue.isEmpty()) {
			int[] point = queue.remove();

			int x = point[0];
			int y = point[1];

			if (x > 0 && rooms[x - 1][y] == Integer.MAX_VALUE) {
				rooms[x - 1][y] = rooms[x][y] + 1;
				queue.add(new int[] { x - 1, y });
			}

			if (y > 0 && rooms[x][y - 1] == Integer.MAX_VALUE) {
				rooms[x][y - 1] = rooms[x][y] + 1;
				queue.add(new int[] { x, y - 1 });
			}

			if (x < rooms.length - 1 && rooms[x + 1][y] == Integer.MAX_VALUE) {
				rooms[x + 1][y] = rooms[x][y] + 1;
				queue.add(new int[] { x + 1, y });
			}

			if (y < rooms[0].length - 1 && rooms[x][y + 1] == Integer.MAX_VALUE) {
				rooms[x][y + 1] = rooms[x][y] + 1;
				queue.add(new int[] { x, y + 1 });
			}
		}
	}
}
