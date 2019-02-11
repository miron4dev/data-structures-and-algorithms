package com.miron4dev.dsa.tree;

public interface Tree<T extends Comparable<T>> {

	/**
	 * Performs insert operation.
	 *
	 * @param item item to insert.
	 */
	void insert(T item);

	/**
	 * Performs delete operation. If there is no item in the tree, then does nothing.
	 *
	 * @param item item to delete.
	 */
	void delete(T item);

	/**
	 * Returns maximal element in the tree.
	 *
	 * @return see description.
	 */
	T getMax();

	/**
	 * Returns k-th maximal element in the tree.
	 *
	 * @param k some value that must be less or equal to the Tree's size.
	 * @return see description.
	 * @see #size()
	 */
	T getMax(int k);

	/**
	 * Returns minimal element in the tree.
	 *
	 * @return see description.
	 */
	T getMin();

	/**
	 * Returns k-th minimal element in the tree.
	 *
	 * @param k some value that must be less or equal to the Tree's size.
	 * @return see description.
	 * @see #size()
	 */
	T getMin(int k);

	/**
	 * Returns the Tree's size.
	 *
	 * @return see description.
	 */
	int size();
}
