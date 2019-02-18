package com.miron4dev.dsa.datastructure.tree.bst.rb;

import com.miron4dev.dsa.datastructure.tree.bst.AbstractBinaryNode;

public class RedBlackNode<T extends Comparable<T>> extends AbstractBinaryNode<T, RedBlackNode<T>> {

    private RedBlackNode<T> parent;

    private Color color = Color.RED;

    public RedBlackNode(T data) {
        super(data);
    }

    public RedBlackNode(T data, RedBlackNode<T> leftChild, RedBlackNode<T> rightChild) {
        this(data);
        this.setLeftChild(leftChild);
        this.setRightChild(rightChild);
    }

    public RedBlackNode<T> getParent() {
        return parent;
    }

    public void setParent(RedBlackNode<T> parent) {
        this.parent = parent;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
