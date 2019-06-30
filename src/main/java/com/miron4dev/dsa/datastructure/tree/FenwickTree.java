package com.miron4dev.dsa.datastructure.tree;

/**
 * Data structure that can efficiently update elements and calculate prefix sums in a table of numbers.
 */
public class FenwickTree {

	private final int[] fenwickTree;

	public FenwickTree(int[] nums) {
		// first item is always 0
		this.fenwickTree = new int[nums.length + 1];
		construct(nums);
	}

	/**
	 * Returns sum of the integers in the range [start:index].
	 *
	 * @param startIndex start index.
	 * @param endIndex   end index.
	 * @return see description.
	 */
	public int sum(int startIndex, int endIndex) {
		return sum(endIndex) - sum(startIndex - 1);
	}

	/**
	 * Returns sum of the integers in the range [0:index].
	 *
	 * @param index index.
	 * @return see description.
	 */
	public int sum(int index) {
		// index start with 0 but we always start with 1
		index++;

		int sum = 0;

		while (index > 0) {
			sum += this.fenwickTree[index];

			index = parent(index);
		}

		return sum;
	}

	/**
	 * Constructs the Fenwick Tree from the original array of integers.
	 *
	 * @param nums array of integers.
	 */
	private void construct(int[] nums) {
		for (int i = 1; i <= nums.length; i++) {
			update(i, nums[i - 1]);
		}
	}

	/**
	 * Updates an existing item in the tree with index and value accordingly.
	 *
	 * @param index index.
	 * @param num   item.
	 */
	private void update(int index, int num) {
		while (index < this.fenwickTree.length) {
			this.fenwickTree[index] += num;
			index = next(index);
		}
	}

	/**
	 * Returns index of the item on the left.
	 *
	 * @param index index.
	 * @return see description.
	 */
	private int next(int index) {
		return index + (index & -index);
	}

	/**
	 * Returns index of the item on the right (parent).
	 *
	 * @param index index.
	 * @return see description.
	 */
	private int parent(int index) {
		return index - (index & -index);
	}
}
