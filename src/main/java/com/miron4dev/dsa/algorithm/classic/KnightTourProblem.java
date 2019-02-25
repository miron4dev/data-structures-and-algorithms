package com.miron4dev.dsa.algorithm.classic;

public class KnightTourProblem {
    
    private static final int[] X_MOVES = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] Y_MOVES = {1, 2,2, 1, -1, -2, -2, -1};
    private static final int POSSIBLE_MOVES = 8;

    private final int[][] chessTable;

    public KnightTourProblem(int n) {
        this.chessTable = new int[n][n];
    }
    
    public int[][] solve() {
        this.chessTable[0][0] = 1; // starting point
        if (!solve(2, 0, 0)) {
            return null;
        }
        return chessTable;
    }

    private boolean solve(int stepCount, int x, int y) {
        if (stepCount == this.chessTable.length * this.chessTable[0].length + 1) {
            return true;
        }
        for (int i = 0; i < POSSIBLE_MOVES; i++) {
            int nextX = x + X_MOVES[i];
            int nextY = y + Y_MOVES[i];

            if (isValidStep(nextX, nextY)) {
                this.chessTable[nextX][nextY] = stepCount;

                if (solve(stepCount + 1, nextX, nextY)) {
                    return true;
                }

                this.chessTable[nextX][nextY] = 0;
            }
        }

        return false;
    }

    private boolean isValidStep(int nextX, int nextY) {
        if (nextX < 0 || nextX >= this.chessTable.length) {
            return false;
        }

        if (nextY < 0 || nextY >= this.chessTable[0].length) {
            return false;
        }
        return this.chessTable[nextX][nextY] == 0;
    }
}
