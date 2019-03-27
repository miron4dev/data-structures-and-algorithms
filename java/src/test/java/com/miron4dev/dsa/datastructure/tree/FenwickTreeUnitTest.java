package com.miron4dev.dsa.datastructure.tree;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FenwickTreeUnitTest {

	@Test
	public void sumFromTheBeginning() {
		int[] nums = { 3, 2, -1, 6, 5, 4, -3, 3, 7, 2, 3 };
		FenwickTree tree = new FenwickTree(nums);

		assertEquals(4, tree.sum(2));
	}

	@Test
	public void sumOfTheMiddle() {
		int[] nums = { 3, 2, -1, 6, 5, 4, -3, 3, 7, 2, 3 };
		FenwickTree tree = new FenwickTree(nums);

		assertEquals(12, tree.sum(8, 10));
	}
}