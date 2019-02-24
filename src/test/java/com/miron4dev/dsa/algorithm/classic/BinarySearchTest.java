package com.miron4dev.dsa.algorithm.classic;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    private final BinarySearch bs = new BinarySearch();

    @Test
    public void search() {
        int[] nums = {1, 2, 4, 8, 9, 10};

        assertEquals(3, bs.search(nums, 8));
    }

    @Test
    public void searchNotFound() {
        int[] nums = {1, 2, 4, 8, 9, 10};

        assertEquals(-1, bs.search(nums, 13));
    }
}