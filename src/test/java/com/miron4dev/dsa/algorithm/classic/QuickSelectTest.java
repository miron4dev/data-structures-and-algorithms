package com.miron4dev.dsa.algorithm.classic;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuickSelectTest {

    private final QuickSelect qs = new QuickSelect();

    @Test
    public void select() {
        int[] nums = {1, 5, 4, 8, -2};

        assertEquals(5, qs.selectKLargest(nums, 2));
    }
}