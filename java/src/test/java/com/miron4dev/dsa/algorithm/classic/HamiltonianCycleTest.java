package com.miron4dev.dsa.algorithm.classic;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class HamiltonianCycleTest {

    @Test
    public void solve() {
        int[][] matrix = {
                {0, 1, 1, 1, 0, 0},
                {1, 0, 1, 0, 1, 0},
                {1, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 0, 1},
                {0, 1, 0, 0, 0, 1},
                {0, 1, 1, 1, 1, 1},
        };
        HamiltonianCycle hc = new HamiltonianCycle(matrix);

        int[] expected = {0, 1, 4, 5, 2, 3};
        assertArrayEquals(expected, hc.solve());
    }

    @Test
    public void solveWithoutSolution() {
        int[][] matrix = {
                {0, 1, 0},
                {1, 0, 1},
                {0, 1, 0}
        };
        HamiltonianCycle hc = new HamiltonianCycle(matrix);

        assertNull(hc.solve());
    }
}