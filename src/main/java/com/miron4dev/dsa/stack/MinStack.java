package com.miron4dev.dsa.stack;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStack {

	private final Stack<Integer> supportingStack = new Stack<>();

	private Node tail;

	public void push(int elem) {
		if (supportingStack.isEmpty()) {
			supportingStack.push(elem);
		} else if (elem <= supportingStack.peek()) {
			supportingStack.push(elem);
		}

		Node node = new Node(elem);
		if (tail == null) {
			tail = node;
		} else {
			node.prev = tail;
			tail = node;
		}
	}

	public void pop() {
		if (tail == null) {
			return;
		}

		int elem = tail.value;

		tail = tail.prev;

		if (supportingStack.peek() == elem) {
			supportingStack.pop();
		}
	}

	public int top() {
		return tail.value;
	}

	public int getMin() {
		return supportingStack.peek();
	}

	private static class Node {

		private final int value;
		private Node prev;

		public Node(int value) {
			this.value = value;
		}
	}
}
