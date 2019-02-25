package com.miron4dev.dsa.algorithm.classic;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class MazeTest {

    @Test
    public void solve() {
        int[][] matrix = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {1, 1, 0, 2, 1}
        };
        Maze maze = new Maze(matrix);

        int[][] expected = {
                {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0}
        };
        assertArrayEquals(expected, maze.solve(1, 1));
    }

    @Test
    public void solveWithoutSolution() {
        int[][] matrix = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 1, 1, 1},
                {1, 1, 0, 2, 1}
        };
        Maze maze = new Maze(matrix);
        assertNull(maze.solve(1, 1));
    }
}