package com.miron4dev.dsa.algorithm.leetcode.linkedlist;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.miron4dev.dsa.datastructure.linkedlist.singly.SinglyListNode;

public class ReverseTest {

	private final Reverse<Integer> reverse = new Reverse<>();

	@Test
	public void reverseIteratively() {
		SinglyListNode<Integer> root = SinglyListNode.build(1, 2, 3, 4, 5);

		SinglyListNode<Integer> expected = SinglyListNode.build(5, 4, 3, 2, 1);

		SinglyListNode<Integer> actual = reverse.reverseIteratively(root);
		assertEquals(expected, actual);
	}

	@Test
	public void reverseRecursively() {
		SinglyListNode<Integer> root = SinglyListNode.build(1, 2, 3, 4, 5);

		SinglyListNode<Integer> expected = SinglyListNode.build(5, 4, 3, 2, 1);

		SinglyListNode<Integer> actual = reverse.reverseRecursively(root);
		assertEquals(expected, actual);
	}

}