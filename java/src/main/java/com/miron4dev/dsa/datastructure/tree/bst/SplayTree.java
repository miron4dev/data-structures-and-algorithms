package com.miron4dev.dsa.datastructure.tree.bst;

public class SplayTree<T extends Comparable<T>> extends BinarySearchTree<T> {

    @Override
    public void insert(T data) {
        BinaryNode<T> cursor = this.root;
        BinaryNode<T> parentNode = null;

        while (cursor != null) {
            parentNode = cursor;

            if (cursor.getData().compareTo(data) < 0) {
                cursor = cursor.getRightChild();
            } else {
                cursor = cursor.getLeftChild();
            }
        }

        cursor = new BinaryNode<>(data);
        cursor.setParent(parentNode);

        if (parentNode == null) {
            this.root = cursor;
        } else if (parentNode.getData().compareTo(cursor.getData()) < 0) {
            parentNode.setRightChild(cursor);
        } else {
            parentNode.setLeftChild(cursor);
        }

        splay(cursor);

        this.size++;
    }

    @Override
    public BinaryNode<T> find(T elem) {
        BinaryNode<T> node = super.find(elem);

        if (node != null) {
            splay(node);
        }

        return node;
    }

    private void splay(BinaryNode<T> node) {
        while (node.getParent() != null) {

            // ZIG CASE
            if (node.getParent().getParent() == null) {
                if (node.getParent().getLeftChild() == node) {
                    rightRotation(node.getParent());
                } else {
                    leftRotation(node.getParent());
                }
            }

            // ZIG-ZIG CASE
            else if (node.getParent().getLeftChild() == node && node.getParent().getParent().getLeftChild() == node.getParent()) {
                rightRotation(node.getParent().getParent());
                rightRotation(node.getParent());
            } else if (node.getParent().getRightChild() == node && node.getParent().getParent().getRightChild() == node.getParent()) {
                leftRotation(node.getParent().getParent());
                leftRotation(node.getParent());
            }

            // ZIG-ZAG CASE
            else if (node.getParent().getLeftChild() == node && node.getParent().getParent().getRightChild() == node.getParent()) {
                rightRotation(node.getParent());
                leftRotation(node.getParent());
            } else {
                leftRotation(node.getParent());
                rightRotation(node.getParent());
            }
        }
    }
}
