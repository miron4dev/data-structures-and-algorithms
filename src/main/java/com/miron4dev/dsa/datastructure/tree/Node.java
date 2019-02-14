package com.miron4dev.dsa.datastructure.tree;

public interface Node<T extends Comparable<T>> {

	T getData();

	boolean isLeaf();

	int size();

	int height();

	boolean isBalanced();
}
