package com.miron4dev.dsa.algorithm.leetcode.queue;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * <p>
 * Example:
 * <p>
 * <pre>
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 * </pre>
 */
public class MovingAverage {

	private final int sizeLimit;

	private Node head;
	private Node tail;

	private int size = 0;
	private int sum = 0;

	/**
	 * Initialize your data structure here.
	 */
	public MovingAverage(int size) {
		this.sizeLimit = size;
	}

	public double next(int val) {
		Node node = new Node(val);

		if (isFull()) {
			sum -= head.val;

			head = head.next;
			tail.next = node;
			tail = node;
		} else {
			Node last = tail;

			tail = node;

			if (last == null) {
				head = node;
			} else {
				last.next = node;
			}

			size++;
		}

		sum += val;

		return sum / (size * 1.0);
	}

	private boolean isFull() {
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
