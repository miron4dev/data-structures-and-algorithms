package com.miron4dev.dsa.datastructure.tree.bst;

import com.miron4dev.dsa.datastructure.tree.Node;

public class BinaryNode<T extends Comparable<T>> implements Node<T> {

	private final T data;

	private BinaryNode<T> leftChild;
	private BinaryNode<T> rightChild;

	public BinaryNode(T data) {
		this.data = data;
	}

	public BinaryNode(T data, BinaryNode<T> leftChild, BinaryNode<T> rightChild) {
		this(data);
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	@Override
	public T getData() {
		return data;
	}

	@Override
	public boolean isLeaf() {
		return leftChild == null && rightChild == null;
	}

	@Override
	public int size() {
		int size = 1;
		if (leftChild != null) {
			size += leftChild.size();
		}
		if (rightChild != null) {
			size += rightChild.size();
		}
		return size;
	}

	@Override
	public int height() {
		int leftHeight = leftChild != null ? leftChild.height() : 0;
		int rightHeight = rightChild != null ? rightChild.height() : 0;
		return 1 + Math.max(leftHeight, rightHeight);
	}

	@Override
	public int getBalance() {
		int leftHeight = leftChild != null ? leftChild.height() : 0;
		int rightHeight = rightChild != null ? rightChild.height() : 0;
		return leftHeight - rightHeight;
	}

	@Override
	public boolean isBalanced() {
		if (leftChild != null && !leftChild.isBalanced()) {
			return false;
		}

		if (rightChild != null && !rightChild.isBalanced()) {
			return false;
		}
		return Math.abs(getBalance()) <= 1;
	}

	@Override
	public String toString() {
		return data.toString();
	}

	@Override
	public boolean equals(Object anotherNode) {
		if (this == anotherNode)
			return true;

		if (anotherNode == null || getClass() != anotherNode.getClass()) {
			return false;
		}

		return equals(this, (BinaryNode<T>) anotherNode);
	}

	@Override
	public int hashCode() {
		int result = 1;

		result = 31 * result + (leftChild != null ? leftChild.hashCode() : 0);
		result = 31 * result + (rightChild != null ? rightChild.hashCode() : 0);
		result = 31 * result + data.hashCode();

		return result;
	}

	public BinaryNode<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinaryNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	public BinaryNode<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinaryNode<T> rightChild) {
		this.rightChild = rightChild;
	}

	private boolean equals(BinaryNode<T> node1, BinaryNode<T> node2) {
		if (node1 == null || node2 == null) {
			return node1 == node2;
		}

		if (node1.getData().compareTo(node2.getData()) != 0) {
			return false;
		}

		return equals(node1.getLeftChild(), node2.getLeftChild()) && equals(node1.getRightChild(), node2.getRightChild());
	}
}
