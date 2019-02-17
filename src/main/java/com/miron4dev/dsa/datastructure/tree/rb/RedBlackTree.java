package com.miron4dev.dsa.datastructure.tree.rb;

public class RedBlackTree<T extends Comparable<T>> {

    private RedBlackNode<T> root;

    private int size;

    public void insert(T data) {
        RedBlackNode<T> node = new RedBlackNode<>(data);
        root = insertNode(root, node);

        fixViolations(node);

        size++;
    }

    @Override
    public String toString() {
        if (root != null) {
            return inOrderTraversal(root);
        }
        return "null";
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

    private void fixViolations(RedBlackNode<T> node) {
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

    private void rightRotation(RedBlackNode<T> node) {
        RedBlackNode<T> tempLeftNode = node.getLeftChild();
        node.setLeftChild(tempLeftNode.getRightChild());

        if (node.getLeftChild() != null) {
            node.getLeftChild().setParent(node);
        }

        rotation(node, tempLeftNode);

        tempLeftNode.setRightChild(node);
        node.setParent(tempLeftNode);
    }

    private void leftRotation(RedBlackNode<T> node) {
        RedBlackNode<T> tempRightNode = node.getRightChild();
        node.setRightChild(tempRightNode.getLeftChild());

        if (node.getRightChild() != null) {
            node.getRightChild().setParent(node);
        }

        rotation(node, tempRightNode);

        tempRightNode.setLeftChild(node);
        node.setParent(tempRightNode);

    }

    private void rotation(RedBlackNode<T> node, RedBlackNode<T> tempNode) {
        tempNode.setParent(node.getParent());

        if (tempNode.getParent() == null) {
            this.root = tempNode;
        } else if (node == tempNode.getParent().getLeftChild()) {
            node.getParent().setLeftChild(tempNode);
        } else {
            node.getParent().setRightChild(tempNode);
        }
    }

    private String inOrderTraversal(RedBlackNode<T> node) {
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
}
