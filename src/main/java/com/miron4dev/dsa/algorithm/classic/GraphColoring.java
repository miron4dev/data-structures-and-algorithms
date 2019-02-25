package com.miron4dev.dsa.algorithm.classic;

public class GraphColoring {

    private final int[][] matrix;
    private final int numberOfColors;
    private final int numberOfVertexes;
    private final int[] colors;

    public GraphColoring(int[][] matrix, int numberOfColors) {
        this.matrix = matrix;
        this.numberOfColors = numberOfColors;
        this.numberOfVertexes = matrix.length;
        this.colors = new int[numberOfVertexes];
    }

    public boolean solve() {
        return solve(0);
    }

    private boolean solve(int nodeIndex) {
        if (nodeIndex == numberOfVertexes) {
            return true;
        }

        for (int colorIndex = 1; colorIndex <= numberOfColors; colorIndex++) {
            if (isColorValid(nodeIndex, colorIndex)) {
                colors[nodeIndex] = colorIndex;

                if (solve(nodeIndex + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isColorValid(int nodeIndex, int colorIndex) {
        for (int i = 0; i < numberOfVertexes; i++) {
            if (matrix[nodeIndex][i] == 1 && colorIndex == colors[i]) {
                return false;
            }
        }
        return true;
    }
}
