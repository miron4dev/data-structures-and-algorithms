package com.miron4dev.dsa.algorithm.classic;

public class Maze {

    private final int[][] maze;
    private final int[][] solutionTable;

    public Maze(int[][] maze) {
        this.maze = maze;
        this.solutionTable = new int[maze.length][maze[0].length];
    }

    public int[][] solve(int startX, int startY) {
        if (!solveMaze(startX, startY)) {
            return null;
        }

        return solutionTable;
    }

    private boolean solveMaze(int x, int y) {
        if (isFinished(x, y)) {
            return true;
        }

        if (isValid(x, y)) {
            solutionTable[x][y] = 1;

            if (solveMaze(x + 1, y)) {
                return true;
            }

            if (solveMaze(x, y + 1)) {
                return true;
            }

            if (solveMaze(x - 1, y)) {
                return true;
            }

            if (solveMaze(x, y - 1)) {
                return true;
            }

            solutionTable[x][y] = 0;
        }
        return false;
    }

    private boolean isFinished(int x, int y) {
        if (isOutOfRange(x) || isOutOfRange(y)) {
            return false;
        }

        return maze[x][y] == 2;
    }

    private boolean isValid(int x, int y) {
        if (isOutOfRange(x) || isOutOfRange(y)) {
            return false;
        }

        return solutionTable[x][y] != 1 && maze[x][y] != 1;
    }

    private boolean isOutOfRange(int n) {
        return n < 0 || n >= this.maze.length;
    }
}
