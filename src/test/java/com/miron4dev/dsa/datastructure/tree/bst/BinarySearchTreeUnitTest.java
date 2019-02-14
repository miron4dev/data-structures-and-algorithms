package com.miron4dev.dsa.datastructure.tree.bst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.miron4dev.dsa.datastructure.tree.Tree;

public class BinarySearchTreeUnitTest {

	@Test
	public void insert() {
		Tree<Integer> bst = new BinarySearchTree<>();
		bst.insert(10);
		bst.insert(4);
		bst.insert(8);
		bst.insert(14);
		bst.insert(1);

		assertEquals(5, bst.size());
	}

	@Test
	public void getMin() {
		Tree<Integer> bst = new BinarySearchTree<>();
		bst.insert(10);
		bst.insert(4);
		bst.insert(8);
		bst.insert(14);
		bst.insert(1);

		assertEquals(new Integer(1), bst.getMin());
	}

	@Test
	public void getMax() {
		Tree<Integer> bst = new BinarySearchTree<>();
		bst.insert(10);
		bst.insert(4);
		bst.insert(8);
		bst.insert(14);
		bst.insert(1);

		assertEquals(new Integer(14), bst.getMax());
	}

	@Test
	public void deleteLeaf() {
		Tree<Integer> bst = new BinarySearchTree<>();
		bst.insert(10);
		bst.insert(4);
		bst.insert(8);
		bst.insert(14);
		bst.insert(1);

		bst.delete(1);

		assertEquals(4, bst.size());
		assertEquals("4 -> 8 -> 10 -> 14 -> ", bst.toString());
	}

	@Test
	public void deleteWithLeftChild() {
		Tree<Integer> bst = new BinarySearchTree<>();
		bst.insert(10);
		bst.insert(4);
		bst.insert(14);
		bst.insert(1);

		bst.delete(4);

		assertEquals(3, bst.size());
		assertEquals("1 -> 10 -> 14 -> ", bst.toString());
	}

	@Test
	public void deleteWithRightChild() {
		Tree<Integer> bst = new BinarySearchTree<>();
		bst.insert(10);
		bst.insert(4);
		bst.insert(8);
		bst.insert(14);

		bst.delete(8);

		assertEquals(3, bst.size());
		assertEquals("4 -> 10 -> 14 -> ", bst.toString());
	}

	@Test
	public void deleteRoot() {
		Tree<Integer> bst = new BinarySearchTree<>();
		bst.insert(10);
		bst.insert(4);
		bst.insert(8);
		bst.insert(14);
		bst.insert(1);

		bst.delete(10);

		assertEquals(4, bst.size());
		assertEquals("1 -> 4 -> 8 -> 14 -> ", bst.toString());
	}

	@Test
	public void isBalancedTrue() {
		Tree<Integer> bst = new BinarySearchTree<>();
		bst.insert(10);
		bst.insert(4);
		bst.insert(8);
		bst.insert(14);
		bst.insert(1);

		assertTrue(bst.isBalanced());
	}

	@Test
	public void isBalancedFalse() {
		Tree<Integer> bst = new BinarySearchTree<>();
		bst.insert(1);
		bst.insert(4);
		bst.insert(8);
		bst.insert(14);

		assertFalse(bst.isBalanced());
	}

	@Test
	public void testToString() {
		Tree<Integer> bst = new BinarySearchTree<>();
		bst.insert(10);
		bst.insert(4);
		bst.insert(8);
		bst.insert(14);
		bst.insert(1);

		assertEquals("1 -> 4 -> 8 -> 10 -> 14 -> ", bst.toString());
	}

	@Test
	public void testEquals() {
		Tree<Integer> bst = new BinarySearchTree<>();
		bst.insert(10);
		bst.insert(4);
		bst.insert(8);
		bst.insert(14);
		bst.insert(1);

		Tree<Integer> bst2 = new BinarySearchTree<>();
		bst2.insert(10);
		bst2.insert(4);
		bst2.insert(8);
		bst2.insert(14);
		bst2.insert(1);

		assertEquals(bst2, bst);
	}

	@Test
	public void testNotEqualsBecauseOfOrder() {
		Tree<Integer> bst = new BinarySearchTree<>();
		bst.insert(10);
		bst.insert(4);
		bst.insert(8);
		bst.insert(14);
		bst.insert(1);

		Tree<Integer> bst2 = new BinarySearchTree<>();
		bst2.insert(10);
		bst2.insert(8);
		bst2.insert(4);
		bst2.insert(14);
		bst2.insert(1);

		assertNotEquals(bst2, bst);
	}

	@Test
	public void testNotEqualsBecauseValues() {
		Tree<Integer> bst = new BinarySearchTree<>();
		bst.insert(10);
		bst.insert(4);
		bst.insert(8);
		bst.insert(14);
		bst.insert(1);

		Tree<Integer> bst2 = new BinarySearchTree<>();
		bst2.insert(10);
		bst2.insert(4);
		bst2.insert(8);
		bst2.insert(14);

		assertNotEquals(bst2, bst);
	}

	@Test
	public void testHashCode() {
		Tree<Integer> bst = new BinarySearchTree<>();
		bst.insert(10);
		bst.insert(4);
		bst.insert(8);
		bst.insert(14);
		bst.insert(1);

		assertEquals(-1633904680, bst.hashCode());
	}

}