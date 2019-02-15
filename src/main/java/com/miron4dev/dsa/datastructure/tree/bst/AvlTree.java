package com.miron4dev.dsa.datastructure.tree.bst;

public class AvlTree<T extends Comparable<T>> extends BinarySearchTree<T> {

	@Override
	protected BinaryNode<T> recalculateNode(BinaryNode<T> node, T data) {
		if (node == null) {
			return null;
		}
		int balance = node.getBalance();

		if (balance > 1) {
			if (node.getLeftChild().getBalance() < 0) { // left-right case
				node.setLeftChild(leftRotation(node.getLeftChild()));
			}
			return rightRotation(node);
		}

		if (balance < -1) {
			if (node.getRightChild().getBalance() > 0) { //right-left case
				node.setRightChild(rightRotation(node.getRightChild()));
			}
			return leftRotation(node);
		}
		return node;
	}

	private BinaryNode<T> rightRotation(BinaryNode<T> node) {
		BinaryNode<T> tempLeftNode = node.getLeftChild();
		BinaryNode<T> t = tempLeftNode.getRightChild();

		tempLeftNode.setRightChild(node);
		node.setLeftChild(t);

		return tempLeftNode;
	}

	private BinaryNode<T> leftRotation(BinaryNode<T> node) {
		BinaryNode<T> tempRightNode = node.getRightChild();
		BinaryNode<T> t = tempRightNode.getLeftChild();

		tempRightNode.setLeftChild(node);
		node.setRightChild(t);

		return tempRightNode;
	}

}
