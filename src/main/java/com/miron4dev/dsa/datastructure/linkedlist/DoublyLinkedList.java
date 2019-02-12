package com.miron4dev.dsa.datastructure.linkedlist;

import java.util.AbstractList;

public class DoublyLinkedList<T> extends AbstractList<T> {

	private DoubleListNode<T> head;
	private DoubleListNode<T> tail;
	private int size = 0;

	@Override
	public T get(int index) {
		validateIndex(index);

		return getNode(index).getValue();
	}

	@Override
	public void add(int index, T element) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}

		if (index == 0) {
			linkFirst(element);
		} else if (index == size) {
			linkLast(element);
		} else {
			DoubleListNode<T> cur = getNode(index);
			DoubleListNode<T> prev = cur.getPrev();

			DoubleListNode<T> newNode = new DoubleListNode<>(element, prev, cur);

			prev.setNext(newNode);
			cur.setPrev(newNode);
		}

		size++;
	}

	@Override
	public T remove(int index) {
		validateIndex(index);

		DoubleListNode<T> cur = getNode(index);
		DoubleListNode<T> prev = cur.getPrev();
		DoubleListNode<T> next = cur.getNext();

		if (prev == null) {
			head = next;
		} else {
			prev.setNext(next);
			cur.setPrev(null);
		}

		if (next == null) {
			tail = prev;
		} else {
			next.setPrev(prev);
			cur.setNext(null);
		}

		size--;
		return cur.getValue();
	}

	@Override
	public T set(int index, T element) {
		validateIndex(index);

		DoubleListNode<T> node = getNode(index);
		T oldValue = node.getValue();
		node.setValue(element);
		return oldValue;
	}

	@Override
	public int size() {
		return size;
	}

	private void validateIndex(int index) {
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException();
		}
	}

	private DoubleListNode<T> getNode(int index) {
		DoubleListNode<T> current = head;
		int counter = 0;
		while (counter != index) {
			current = current.getNext();
			counter++;
		}
		return current;
	}

	private void linkFirst(T element) {
		DoubleListNode<T> prevHead = head;
		DoubleListNode<T> node = new DoubleListNode<>(element, null, prevHead);

		head = node;

		if (prevHead == null) {
			this.tail = node;
		} else {
			prevHead.setPrev(node);
		}
	}

	private void linkLast(T element) {
		DoubleListNode<T> prevTail = tail;
		DoubleListNode<T> node = new DoubleListNode<>(element, prevTail, null);

		tail = node;

		if (prevTail == null) {
			this.head = node;
		} else {
			prevTail.setNext(node);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		DoubleListNode<T> current = head;

		while (current != null) {
			sb.append(current.getValue()).append(" <-> ");

			current = current.getNext();

		}
		return sb.toString();
	}
}
