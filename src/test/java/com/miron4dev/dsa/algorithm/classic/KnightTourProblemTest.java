package com.miron4dev.dsa.algorithm.classic;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class KnightTourProblemTest {

    @Test
    public void solve() {
        KnightTourProblem ktp = new KnightTourProblem(8);

        int[][] chessTable = {
                {1, 60, 39, 34, 31, 18, 9, 64},
                {38, 35, 32, 61, 10, 63, 30, 17},
                {59, 2, 37, 40, 33, 28, 19, 8},
                {36, 49, 42, 27, 62, 11, 16, 29},
                {43, 58, 3, 50, 41, 24, 7, 20},
                {48, 51, 46, 55, 26, 21, 12, 15},
                {57, 44, 53, 4, 23, 14, 25, 6},
                {52, 47, 56, 45, 54, 5, 22, 13}
        };
        assertArrayEquals(chessTable, ktp.solve());
    }

    @Test
    public void solveWithoutSolution() {
        KnightTourProblem ktp = new KnightTourProblem(4);

        assertNull(ktp.solve());
    }
}