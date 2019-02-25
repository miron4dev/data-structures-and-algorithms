package com.miron4dev.dsa.algorithm.classic;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GraphColoringTest {

    @Test
    public void solve() {
        int[][] matrix = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 1, 0},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 1, 0}
        };
        GraphColoring gc = new GraphColoring(matrix, 3);
        assertTrue(gc.solve());
    }

    @Test
    public void solveWithoutSolution() {
        int[][] matrix = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 1, 0},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 1, 0}
        };
        GraphColoring gc = new GraphColoring(matrix, 2);
        assertFalse(gc.solve());
    }
}