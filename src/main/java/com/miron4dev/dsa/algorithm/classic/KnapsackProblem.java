package com.miron4dev.dsa.algorithm.classic;

public class KnapsackProblem {

    private final int numOfItems;
    private final int capacity;
    private final int[] weights;
    private final int[] values;
    private final int[][] knapsackTable;

    public KnapsackProblem(int numOfItems, int capacity, int[] weights, int[] values) {
        this.numOfItems = numOfItems;
        this.capacity = capacity;
        this.weights = weights;
        this.values = values;
        this.knapsackTable = new int[numOfItems + 1][capacity + 1];
    }

    public int solve() {
        for (int i = 1; i <= numOfItems; i++) {
            for (int w = 0; w <= capacity; w++) {

                int notTakingItem = knapsackTable[i - 1][w];
                int takingItem = 0;

                if (weights[i - 1] <= w) {
                    takingItem = values[i - 1] + knapsackTable[i - 1][w - weights[i - 1]];
                }

                knapsackTable[i][w] = Math.max(notTakingItem, takingItem);
            }
        }
        return knapsackTable[numOfItems][capacity];
    }

    public int solveRecursively() {
        return knapsack(values.length - 1, capacity);
    }

    private int knapsack(int index, int weight) {
        if (index < 0) {
            return 0;
        }
        if (weights[index] > weight) {
            return knapsack(index - 1, weight);
        }
        return Math.max(
                knapsack(index - 1, weight),
                knapsack(index - 1, weight - weights[index]) + values[index]
        );
    }
}
