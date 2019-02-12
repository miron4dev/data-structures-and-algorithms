package com.miron4dev.dsa.datastructure.tree.bst;

import java.util.Objects;
import java.util.function.Consumer;

import com.miron4dev.dsa.datastructure.tree.Tree;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

	private BinaryNode<T> root;

	private int size;

	@Override
	public void insert(T data) {
		if (root == null) {
			root = new BinaryNode<>(data);
		} else {
			insertNode(data, root);
		}
		size++;
	}

	@Override
	public void delete(T data) {
		if (root != null) {
			root = deleteNode(data, root);

			size--;
		}
	}

	@Override
	public T getMax() {
		return getMax(1);
	}

	@Override
	public T getMax(int k) {
		return getKthMaximum(root, k).getData();
	}

	@Override
	public T getMin() {
		return getMin(1);
	}

	@Override
	public T getMin(int k) {
		if (root == null) {
			return null;
		}

		return getKthMinimum(root, k).getData();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public String toString() {
		if (root != null) {
			return inOrderTraversal(root);
		}
		return "null";
	}

	private void insertNode(T data, BinaryNode<T> node) {
		if (data.compareTo(node.getData()) < 0) {
			insertNode(data, node.getLeftChild(), node::setLeftChild);
		} else {
			insertNode(data, node.getRightChild(), node::setRightChild);
		}
	}

	private void insertNode(T data, BinaryNode<T> node, Consumer<BinaryNode<T>> setChild) {
		if (node != null) {
			insertNode(data, node);
		} else {
			BinaryNode<T> newNode = new BinaryNode<>(data);
			setChild.accept(newNode);
		}
	}

	private BinaryNode<T> deleteNode(T data, BinaryNode<T> node) {
		if (node == null) {
			return null;
		}

		if (data.compareTo(node.getData()) < 0) {
			node.setLeftChild(deleteNode(data, node.getLeftChild()));
		} else if (data.compareTo(node.getData()) > 0) {
			node.setRightChild(deleteNode(data, node.getRightChild()));
		} else {
			if (node.isLeaf()) {
				node = null;
			} else if (node.getLeftChild() == null) {
				node = node.getRightChild();
			} else if (node.getRightChild() == null) {
				node = node.getLeftChild();
			} else {
				BinaryNode<T> predecessor = getMostRightNode(node.getLeftChild());

				BinaryNode<T> leftChild = deleteNode(predecessor.getData(), node.getLeftChild());
				node = new BinaryNode<>(predecessor.getData(), leftChild, node.getRightChild());
			}
		}

		return node;
	}

	private BinaryNode<T> getMostRightNode(BinaryNode<T> node) {
		while (node.getRightChild() != null) {
			node = node.getRightChild();
		}
		return node;
	}

	private BinaryNode<T> getKthMinimum(BinaryNode<T> node, int k) {
		if (node == null) {
			return null;
		}
		int n = 1; // root node
		if (node.getLeftChild() != null) {
			n += node.getLeftChild().size();
		}

		if (n == k) {
			return node;
		} else if (n > k) {
			return getKthMinimum(node.getLeftChild(), k);
		}
		return getKthMinimum(node.getRightChild(), k - n);
	}

	private BinaryNode<T> getKthMaximum(BinaryNode<T> node, int k) {
		if (node == null) {
			return null;
		}

		int n = 1; // root node
		if (node.getRightChild() != null) {
			n += node.getRightChild().size();
		}

		if (n == k) {
			return node;
		} else if (n > k) {
			return getKthMaximum(node.getRightChild(), k);
		}
		return getKthMaximum(node.getLeftChild(), k - n);
	}

	private String inOrderTraversal(BinaryNode<T> node) {
		StringBuilder result = new StringBuilder();
		if (node.getLeftChild() != null) {
			result.append(inOrderTraversal(node.getLeftChild()));
		}

		result.append(node).append(" -> ");

		if (node.getRightChild() != null) {
			result.append(inOrderTraversal(node.getRightChild()));
		}

		return result.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		BinarySearchTree<?> that = (BinarySearchTree<?>) o;
		return Objects.equals(root, that.root);
	}

	@Override
	public int hashCode() {
		return root != null ? root.hashCode() : 0;
	}
}
