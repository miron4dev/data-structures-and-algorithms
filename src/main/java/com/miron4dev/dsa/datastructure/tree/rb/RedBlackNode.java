package com.miron4dev.dsa.datastructure.tree.rb;

public class RedBlackNode<T extends Comparable<T>> {

    private final T data;

    private RedBlackNode<T> parent;
    private RedBlackNode<T> leftChild;
    private RedBlackNode<T> rightChild;

    private Color color = Color.RED;

    public RedBlackNode(T data) {
        this.data = data;
    }

    public RedBlackNode(T data, RedBlackNode<T> leftChild, RedBlackNode<T> rightChild) {
        this(data);
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public T getData() {
        return data;
    }

    public RedBlackNode<T> getParent() {
        return parent;
    }

    public void setParent(RedBlackNode<T> parent) {
        this.parent = parent;
    }

    public RedBlackNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(RedBlackNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public RedBlackNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(RedBlackNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return data.toString();
    }

}
