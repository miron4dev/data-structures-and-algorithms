package com.miron4dev.dsa.algorithm.linkedlist;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.miron4dev.dsa.datastructure.linkedlist.singly.SinglyListNode;

public class OddEvenLinkedListUnitTest {

	private final OddEvenLinkedList<Integer> oddEvenLinkedList = new OddEvenLinkedList<>();

	@Test
	public void solution() {
		SinglyListNode<Integer> head = SinglyListNode.build(1, 2, 3, 4, 5);
		SinglyListNode<Integer> expected = SinglyListNode.build(1, 3, 5, 2, 4);

		SinglyListNode<Integer> actual = oddEvenLinkedList.solution(head);
		assertEquals(expected, actual);
	}
}