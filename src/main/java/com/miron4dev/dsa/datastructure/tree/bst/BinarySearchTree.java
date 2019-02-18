package com.miron4dev.dsa.datastructure.tree.bst;

public class BinarySearchTree<T extends Comparable<T>> extends AbstractBinarySearchTree<T, BinaryNode<T>> {
    @Override
    protected BinaryNode<T> createNode(T data, BinaryNode<T> leftChild, BinaryNode<T> rightChild) {
        return new BinaryNode<>(data, leftChild, rightChild);
    }
}
