package com.miron4dev.dsa.linkedlist.singly;

import java.util.AbstractList;

public class SinglyLinkedList<T> extends AbstractList<T> {

	private SinglyListNode<T> head;
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

		SinglyListNode<T> node = new SinglyListNode<>(element);

		if (head == null) {
			this.head = node;
		} else {
			SinglyListNode<T> prev = getNode(index - 1);
			SinglyListNode<T> next = prev.getNext();

			prev.setNext(node);
			node.setNext(next);
		}

		size++;
	}

	@Override
	public T remove(int index) {
		validateIndex(index);

		T elem;
		if (index == 0) {
			elem = head.getValue();
			head = head.getNext();
		} else {
			SinglyListNode<T> prev = getNode(index - 1);
			SinglyListNode<T> next = prev.getNext();

			prev.setNext(next.getNext());

			elem = next.getValue();
		}
		size--;
		return elem;
	}

	@Override
	public T set(int index, T element) {
		validateIndex(index);

		SinglyListNode<T> node = getNode(index);
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

	private SinglyListNode<T> getNode(int index) {
		SinglyListNode<T> current = head;
		int counter = 0;
		while (counter != index) {
			current = current.getNext();
			counter++;
		}
		return current;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		SinglyListNode<T> current = head;

		while (current != null) {
			sb.append(current.getValue()).append(" -> ");

			current = current.getNext();

		}
		return sb.toString();
	}
}
