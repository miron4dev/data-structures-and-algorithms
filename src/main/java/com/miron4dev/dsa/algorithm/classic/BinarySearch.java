package com.miron4dev.dsa.algorithm.classic;

/**
 * Search algorithm that finds the position of a target value within a sorted array.
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int start, int end) {
        if (end < start) {
            return -1;
        }

        int median = end + (start - end) / 2; // to avoid overflow error

        if (target < nums[median]) { // search in left part
            return search(nums, target, start, median - 1);
        } else if (target > nums[median]) { // search in right part
            return search(nums, target, median + 1, end);
        }
        return median;
    }
}
