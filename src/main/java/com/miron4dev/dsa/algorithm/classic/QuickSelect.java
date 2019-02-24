package com.miron4dev.dsa.algorithm.classic;

import java.util.Random;

/**
 * A selection algorithm to find the kth smallest element in an unordered list.
 */
public class QuickSelect {

    public int selectKLargest(int[] nums, int k) {
        return select(nums, k - 1, 0, nums.length - 1);
    }

    private int select(int[] nums, int k, int start, int end) {
        int pivotIndex = partition(nums, start, end);

        if (k == pivotIndex) {
            return nums[k];
        }
        
        if (k < pivotIndex) { // search in left part
            return select(nums, k, start, pivotIndex);
        }
        return select(nums, k, pivotIndex, end);
    }

    private int partition(int[] nums, int start, int end) {
        int pivotIndex = random(start, end);
        swap(nums, pivotIndex, end);

        for (int i = start; i < end; i++) {
            if (nums[i] > nums[end]) {
                swap(nums, i, start);
                start++;
            }
        }

        swap(nums, start, end);

        return start;
    }

    private void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }

    private int random(int start, int end) {
        return new Random().nextInt(end - start + 1) + start;
    }
}
