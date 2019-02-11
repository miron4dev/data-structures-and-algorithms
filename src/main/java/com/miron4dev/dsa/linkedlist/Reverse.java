package com.miron4dev.dsa.linkedlist;

/**
 * Reverse a singly linked list.
 */
public class Reverse {

	public ListNode reverseIteratively(ListNode head) {
		ListNode previous = null;
		ListNode current = head;
		ListNode next;
		while (current != null) {
			next = current.getNext();
			current.setNext(previous);
			previous = current;
			current = next;
		}
		return previous;
	}

	public ListNode reverseRecursively(ListNode head) {
		if (head == null) {
			return null;
		}

		if (head.getNext() == null) {
			return head;
		}

		ListNode first = reverseRecursively(head.getNext());
		head.getNext().setNext(head);
		head.setNext(null);
		return first;
	}
}
