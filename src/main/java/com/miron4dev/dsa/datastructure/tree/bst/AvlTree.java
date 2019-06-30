package com.miron4dev.dsa.datastructure.tree.bst;

public class AvlTree<T extends Comparable<T>> extends BinarySearchTree<T> {

    @Override
    protected BinaryNode<T> recalculateNode(BinaryNode<T> node) {
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

}
