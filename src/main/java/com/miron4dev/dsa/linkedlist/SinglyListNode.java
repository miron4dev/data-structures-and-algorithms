package com.miron4dev.dsa.linkedlist;

/**
 * Definition for singly-linked list.
 */
public class SinglyListNode<T> {

	private final T value;
	private SinglyListNode<T> next;

	public SinglyListNode(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public SinglyListNode<T> getNext() {
		return next;
	}

	public void setNext(SinglyListNode<T> next) {
		this.next = next;
	}

}
