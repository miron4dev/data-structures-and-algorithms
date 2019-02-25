package com.miron4dev.dsa.algorithm.classic;

public class HamiltonianCycle {

    private final int[][] matrix;
    private final int[] hamiltonianPath;
    private final int numberOfVertexes;

    public HamiltonianCycle(int[][] matrix) {
        this.matrix = matrix;
        this.hamiltonianPath = new int[matrix.length];
        this.numberOfVertexes = matrix.length;

        this.hamiltonianPath[0] = 0;
    }

    public int[] solve() {
        if (!findFeasibleSolution(1)) {
            return null;
        }
        return hamiltonianPath;
    }

    private boolean findFeasibleSolution(int position) {
        if (position == numberOfVertexes) {
            return matrix[hamiltonianPath[position - 1]][hamiltonianPath[0]] == 1;
        }

        for (int vertexIndex = 1; vertexIndex < numberOfVertexes; vertexIndex++) {
            if (isFeasible(vertexIndex, position)) {
                hamiltonianPath[position] = vertexIndex;

                if (findFeasibleSolution(position + 1)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isFeasible(int vertexIndex, int actualPosition) {
        // whether two nodes are connected
        if (matrix[hamiltonianPath[actualPosition-1]][vertexIndex] == 0) {
            return false;
        }

        // whether we have visited it or not
        for (int i = 0; i < actualPosition; i++) {
            if (hamiltonianPath[i] == vertexIndex) {
                return false;
            }
        }
        return true;
    }


}
