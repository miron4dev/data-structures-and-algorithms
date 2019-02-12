package com.miron4dev.dsa.algorithm.linkedlist;

import com.miron4dev.dsa.datastructure.linkedlist.singly.SinglyListNode;

/**
 * Reverse a singly linked list.
 */
public class Reverse<T extends Comparable<T>> {

	public SinglyListNode<T> reverseIteratively(SinglyListNode<T> head) {
		SinglyListNode<T> previous = null;
		SinglyListNode<T> current = head;
		SinglyListNode<T> next;
		while (current != null) {
			next = current.getNext();
			current.setNext(previous);
			previous = current;
			current = next;
		}
		return previous;
	}

	public SinglyListNode<T> reverseRecursively(SinglyListNode<T> head) {
		if (head == null || head.getNext() == null) {
			return head;
		}

		SinglyListNode<T> first = reverseRecursively(head.getNext());
		head.getNext().setNext(head);
		head.setNext(null);
		return first;
	}
}
