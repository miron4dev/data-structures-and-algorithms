package com.miron4dev.dsa.datastructure.tree.bst;

public class BinaryNode<T extends Comparable<T>> extends AbstractBinaryNode<T, BinaryNode<T>> {

    public BinaryNode(T data) {
        super(data);
    }

    public BinaryNode(T data, BinaryNode<T> leftChild, BinaryNode<T> rightChild) {
        this(data);
        this.setLeftChild(leftChild);
        this.setRightChild(rightChild);
    }
}
