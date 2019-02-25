package com.miron4dev.dsa.algorithm.leetcode.linkedlist;

import com.miron4dev.dsa.datastructure.linkedlist.singly.SinglyListNode;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 * <p>
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 */
public class OddEvenLinkedList<T extends Comparable<T>> {

	public SinglyListNode<T> solution(SinglyListNode<T> head) {
		if (head == null || head.getNext() == null) {
			return head;
		}
		SinglyListNode<T> odd = head;
		SinglyListNode<T> even = head.getNext();
		SinglyListNode<T> evenHead = even;

		while (even != null && even.getNext() != null) {
			odd.setNext(even.getNext());
			odd = odd.getNext();
			even.setNext(odd.getNext());
			even = even.getNext();
		}
		odd.setNext(evenHead);
		return head;
	}
}
