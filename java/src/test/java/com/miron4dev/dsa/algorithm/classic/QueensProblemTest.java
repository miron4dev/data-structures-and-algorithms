package com.miron4dev.dsa.algorithm.classic;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueensProblemTest {

    @Test
    public void solve() {
        QueensProblem qp = new QueensProblem(8);

        int[][] expected = new int[][] {
                {1, 0, 0, 0, 0, 0, 0, 0 },
                {0, 0, 0, 0, 0, 0, 1, 0 },
                {0, 0, 0, 0, 1, 0, 0, 0 },
                {0, 0, 0, 0, 0, 0, 0, 1 },
                {0, 1, 0, 0, 0, 0, 0, 0 },
                {0, 0, 0, 1, 0, 0, 0, 0 },
                {0, 0, 0, 0, 0, 1, 0, 0 },
                {0, 0, 1, 0, 0, 0, 0, 0 },
        };
        assertArrayEquals(expected, qp.solve());
    }
}