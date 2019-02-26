package com.miron4dev.dsa.algorithm.classic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnapsackProblemTest {

    @Test
    public void solve() {
        int[] weights = {4, 2, 3};
        int[] values = {10, 4, 7};

        KnapsackProblem kp = new KnapsackProblem(3, 5, weights, values);
        assertEquals(11, kp.solve());
    }

    @Test
    public void solveRecursively() {
        int[] weights = {4, 2, 3};
        int[] values = {10, 4, 7};

        KnapsackProblem kp = new KnapsackProblem(3, 5, weights, values);
        assertEquals(11, kp.solveRecursively());
    }
}