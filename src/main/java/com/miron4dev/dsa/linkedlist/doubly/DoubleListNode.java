package com.miron4dev.dsa.linkedlist.doubly;

public class DoubleListNode<T> {

	private T value;
	private DoubleListNode<T> prev;
	private DoubleListNode<T> next;

	public DoubleListNode(T value) {
		this.value = value;
	}

	public DoubleListNode(T value, DoubleListNode<T> prev, DoubleListNode<T> next) {
		this.value = value;
		this.prev = prev;
		this.next = next;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public DoubleListNode<T> getPrev() {
		return prev;
	}

	public void setPrev(DoubleListNode<T> prev) {
		this.prev = prev;
	}

	public DoubleListNode<T> getNext() {
		return next;
	}

	public void setNext(DoubleListNode<T> next) {
		this.next = next;
	}
}
