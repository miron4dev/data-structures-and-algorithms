package com.miron4dev.dsa.algorithm.classic;

/**
 * The problem of placing N chess queens on an N×N chessboard so that no two queens threaten each other;
 * thus, a solution requires that no two queens share the same row, column, or diagonal.
 */
public class QueensProblem {


    private final int[][] chessTable;
    private final int numOfQueens;

    public QueensProblem(int numOfQueens) {
        this.numOfQueens = numOfQueens;
        this.chessTable = new int[numOfQueens][numOfQueens];
    }

    public int[][] solve() {
        setQueens(0);
        printSolution();
        return chessTable;
    }

    private boolean setQueens(int colIndex) {
        if (colIndex == numOfQueens) {
            return true;
        }

        for (int rowIndex = 0; rowIndex < numOfQueens; rowIndex++) {
            if (isValid(rowIndex, colIndex)) {
                chessTable[rowIndex][colIndex] = 1;

                if (setQueens(colIndex + 1)) {
                    return true;
                }

                // backtracking
                chessTable[rowIndex][colIndex] = 0;
            }
        }

        return false;
    }

    private boolean isValid(int rowIndex, int colIndex) {
        return isHorizontalValid(rowIndex, colIndex) && isDiagonalValid(rowIndex, colIndex);
    }

    private boolean isHorizontalValid(int rowIndex, int colIndex) {
        for (int i = 0; i < colIndex; i++) {
            if (chessTable[rowIndex][i] == 1) {
                return false;
            }
        }
        return true;
    }

    private boolean isDiagonalValid(int rowIndex, int colIndex) {
        for (int i = rowIndex, j = colIndex; i >= 0 && j >= 0; i--, j--) {
            if (chessTable[i][j] == 1) {
                return false;
            }
        }

        for (int i = rowIndex, j = colIndex; i < chessTable.length && j >= 0; i++, j--) {
            if (chessTable[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private void printSolution() {
        for (int rowIndex = 0; rowIndex < chessTable.length; rowIndex++) {
            for (int colIndex = 0; colIndex < chessTable.length; colIndex++) {
                System.out.print(chessTable[rowIndex][colIndex]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
