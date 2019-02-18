package com.miron4dev.dsa.datastructure.tree.bst;

public class RedBlackTree<T extends Comparable<T>> extends AbstractBinarySearchTree<T, RedBlackNode<T>> {

    @Override
    protected RedBlackNode<T> createNode(T data, RedBlackNode<T> leftChild, RedBlackNode<T> rightChild) {
        return new RedBlackNode<>(data, leftChild, rightChild);
    }

    @Override
    public void insert(T data) {
        RedBlackNode<T> node = new RedBlackNode<>(data);
        root = insertNode(root, node);

        fixViolations(node);

        size++;
    }

    @Override
    public void delete(T data) {
        throw new UnsupportedOperationException("Not implemented");
    }

    private RedBlackNode<T> insertNode(RedBlackNode<T> root, RedBlackNode<T> node) {
        if (root == null) {
            return node;
        }

        if (node.getData().compareTo(root.getData()) < 0) {
            root.setLeftChild(insertNode(root.getLeftChild(), node));
            root.getLeftChild().setParent(node);
        } else {
            root.setRightChild(insertNode(root.getRightChild(), node));
            root.getRightChild().setParent(node);
        }

        return root;
    }

    protected void fixViolations(RedBlackNode<T> node) {
        RedBlackNode<T> parentNode;
        RedBlackNode<T> grandparentNode;

        while (node != root && node.getColor() != Color.BLACK && node.getParent().getColor() != Color.RED) {
            parentNode = node.getParent();
            grandparentNode = parentNode.getParent();

            if (parentNode == grandparentNode.getLeftChild()) {
                RedBlackNode<T> uncle = grandparentNode.getRightChild();

                if (uncle != null && uncle.getColor() == Color.RED) {
                    recolor(uncle, parentNode, grandparentNode);

                    node = grandparentNode;
                } else {
                    if (node == parentNode.getRightChild()) {
                        leftRotation(parentNode);
                        node = parentNode;
                        parentNode = node.getParent();
                    }
                    rightRotation(grandparentNode);

                    swapColors(parentNode, grandparentNode);

                    node = parentNode;
                }
            } else {
                RedBlackNode<T> uncle = grandparentNode.getLeftChild();

                if (uncle != null && uncle.getColor() == Color.RED) {
                    recolor(uncle, parentNode, grandparentNode);

                    node = grandparentNode;
                } else {
                    if (node == parentNode.getLeftChild()) {
                        rightRotation(parentNode);
                        node = parentNode;
                        parentNode = node.getParent();
                    }
                    leftRotation(grandparentNode);

                    swapColors(parentNode, grandparentNode);

                    node = parentNode;
                }
            }
        }

        if (root.getColor() == Color.RED) {
            root.setColor(Color.BLACK);
        }
    }

    private void recolor(RedBlackNode<T> uncle, RedBlackNode<T> parentNode, RedBlackNode<T> grandparentNode) {
        grandparentNode.setColor(Color.RED);
        parentNode.setColor(Color.BLACK);
        uncle.setColor(Color.BLACK);
    }

    private void swapColors(RedBlackNode<T> node1, RedBlackNode<T> node2) {
        Color tempColor = node1.getColor();
        node1.setColor(node2.getColor());
        node2.setColor(tempColor);
    }

}
