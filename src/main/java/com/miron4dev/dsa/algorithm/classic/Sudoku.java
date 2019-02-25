package com.miron4dev.dsa.algorithm.classic;

public class Sudoku {

    private static final int BOARD_SIZE = 9;
    private static final int BOX_SIZE = 3;

    private final int[][] sudokuTable;

    public Sudoku(int[][] sudokuTable) {
        this.sudokuTable = sudokuTable;
    }

    public int[][] solve() {
        if (!solve(0, 0)) {
            return null;
        }
        printSolution();
        return sudokuTable;
    }

    private boolean solve(int row, int col) {
        if (row == BOARD_SIZE && ++col == BOARD_SIZE) {
            return true;
        }

        if (row == BOARD_SIZE) {
            row = 0;
        }

        if (sudokuTable[row][col] != 0) {
            return solve(row + 1, col);
        }

        for (int number = 1; number <= 9; number++) {
            if (isValidPosition(row, col, number)) {
                sudokuTable[row][col] = number;

                if (solve(row + 1, col)) {
                    return true;
                }

                sudokuTable[row][col] = 0;
            }
        }
        return false;
    }

    private boolean isValidPosition(int row, int col, int number) {
        // the given number is already in the row
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (sudokuTable[row][i] == number) {
                return false;
            }
        }

        // the given number is already in the column
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (sudokuTable[i][col] == number) {
                return false;
            }
        }

        // the given number is already in the 3x3 grid
        int gridRowOffset = (row / 3) * BOX_SIZE;
        int gridColOffset = (col / 3) * BOX_SIZE;

        for (int i = 0; i < BOX_SIZE; i++) {
            for (int j = 0; j < BOX_SIZE; j++) {
                if (sudokuTable[gridRowOffset + i][gridColOffset + j] == number) {
                    return false;
                }
            }
        }

        return true;
    }

    private void printSolution() {
        for (int i = 0; i < sudokuTable.length; i++) {
            for (int j = 0; j < sudokuTable[0].length; j++) {
                System.out.print(sudokuTable[i][j] + " ");
            }
            System.out.println();
        }
    }
}
