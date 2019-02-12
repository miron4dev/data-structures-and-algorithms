package com.miron4dev.dsa.linkedlist.singly;

/**
 * Definition for singly-linked list.
 */
public class SinglyListNode<T> {

	private T value;
	private SinglyListNode<T> next;

	public SinglyListNode(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public SinglyListNode<T> getNext() {
		return next;
	}

	public void setNext(SinglyListNode<T> next) {
		this.next = next;
	}

}
