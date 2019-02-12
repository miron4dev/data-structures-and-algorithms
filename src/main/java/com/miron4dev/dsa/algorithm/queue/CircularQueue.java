package com.miron4dev.dsa.algorithm.queue;

/**
 * Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out)
 * principle and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".
 * <p>
 * One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full,
 * we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.
 * <p>
 * Your implementation should support following operations:
 * <p>
 * MyCircularQueue(k): Constructor, set the size of the queue to be k.
 * Front: Get the front item from the queue. If the queue is empty, return -1.
 * Rear: Get the last item from the queue. If the queue is empty, return -1.
 * enQueue(value): Insert an element into the circular queue. Return true if the operation is successful.
 * deQueue(): Delete an element from the circular queue. Return true if the operation is successful.
 * isEmpty(): Checks whether the circular queue is empty or not.
 * isFull(): Checks whether the circular queue is full or not.
 */
public class CircularQueue {

	private final int sizeLimit;

	private Node head;
	private Node tail;

	private int size = 0;

	/**
	 * Initialize your data structure here. Set the size of the queue to be k.
	 */
	public CircularQueue(int k) {
		this.sizeLimit = k;
	}

	/**
	 * Insert an element into the circular queue. Return true if the operation is successful.
	 */
	public boolean enQueue(int value) {
		if (isFull()) {
			return false;
		}

		Node last = tail;
		Node node = new Node(value);
		tail = node;

		if (last == null) {
			head = node;
		} else {
			last.next = node;
		}

		size++;
		return true;
	}

	/**
	 * Delete an element from the circular queue. Return true if the operation is successful.
	 */
	public boolean deQueue() {
		if (isEmpty()) {
			return false;
		}

		Node next = head.next;
		head = next;

		if (next == null) {
			tail = null;
		}

		size--;
		return true;
	}

	/**
	 * Get the front item from the queue.
	 */
	public int Front() {
		return isEmpty() ? -1 : head.val;
	}

	/**
	 * Get the last item from the queue.
	 */
	public int Rear() {
		return isEmpty() ? -1 : tail.val;
	}

	/**
	 * Checks whether the circular queue is empty or not.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Checks whether the circular queue is full or not.
	 */
	public boolean isFull() {
		return size == sizeLimit;
	}

	private static class Node {
		private final int val;

		private Node next;

		public Node(int val) {
			this.val = val;
		}
	}
}
