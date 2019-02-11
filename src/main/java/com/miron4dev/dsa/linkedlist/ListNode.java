package com.miron4dev.dsa.linkedlist;

/**
 * Definition for singly-linked list.
 */
public class ListNode {

	private final int value;
	private ListNode next;

	public ListNode(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

}
