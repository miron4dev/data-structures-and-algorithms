package com.miron4dev.dsa.datastructure.tree.bst;

import com.miron4dev.dsa.datastructure.tree.Node;
import com.miron4dev.dsa.datastructure.tree.Tree;

import java.util.Objects;

abstract class AbstractBinarySearchTree<T extends Comparable<T>, N extends AbstractBinaryNode<T, N>> implements Tree<T> {

    protected N root;
    protected int size;

    protected abstract N createNode(T data, N leftChild, N rightChild);

    @Override
    public void insert(T data) {
        root = insertNode(root, data);

        size++;
    }

    @Override
    public void delete(T data) {
        if (!isEmpty()) {
            root = deleteNode(data, root);

            size--;
        }
    }

    @Override
    public N find(T elem) {
        N node = root;

        while (node != null) {
            if (node.getData().compareTo(elem) > 0) {
                node = node.getLeftChild();
            } else if (node.getData().compareTo(elem) < 0) {
                node = node.getRightChild();
            } else {
                break;
            }
        }
        return node;
    }

    @Override
    public Node<T> getRoot() {
        return root;
    }

    @Override
    public T getMax() {
        return getMax(1);
    }

    @Override
    public T getMax(int k) {
        return getKthMaximum(root, k).getData();
    }

    @Override
    public T getMin() {
        return getMin(1);
    }

    @Override
    public T getMin(int k) {
        if (isEmpty()) {
            return null;
        }

        return getKthMinimum(root, k).getData();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean isBalanced() {
        return isEmpty() || root.isBalanced();
    }

    @Override
    public String toString() {
        if (!isEmpty()) {
            return inOrderTraversal(root);
        }
        return "null";
    }

    protected N recalculateNode(N node) {
        return node;
    }

    protected N rightRotation(N node) {
        N tempLeftNode = node.getLeftChild();
        node.setLeftChild(tempLeftNode.getRightChild());

        if (node.getLeftChild() != null) {
            node.getLeftChild().setParent(node);
        }

        rotation(node, tempLeftNode);

        tempLeftNode.setRightChild(node);
        node.setParent(tempLeftNode);

        return tempLeftNode;
    }

    protected N leftRotation(N node) {
        N tempRightNode = node.getRightChild();
        node.setRightChild(tempRightNode.getLeftChild());

        if (node.getRightChild() != null) {
            node.getRightChild().setParent(node);
        }

        rotation(node, tempRightNode);

        tempRightNode.setLeftChild(node);
        node.setParent(tempRightNode);

        return tempRightNode;
    }

    private void rotation(N node, N tempNode) {
        tempNode.setParent(node.getParent());

        if (tempNode.getParent() == null) {
            this.root = tempNode;
        } else if (node == tempNode.getParent().getLeftChild()) {
            node.getParent().setLeftChild(tempNode);
        } else {
            node.getParent().setRightChild(tempNode);
        }
    }

    private N insertNode(N node, T data) {
        if (node == null) {
            return createNode(data, null, null);
        }

        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(insertNode(node.getLeftChild(), data));
        } else {
            node.setRightChild(insertNode(node.getRightChild(), data));
        }

        return recalculateNode(node);
    }

    private N deleteNode(T data, N node) {
        if (node == null) {
            return null;
        }

        if (data.compareTo(node.getData()) < 0) { // go to the left
            node.setLeftChild(deleteNode(data, node.getLeftChild()));
        } else if (data.compareTo(node.getData()) > 0) { // go to the right
            node.setRightChild(deleteNode(data, node.getRightChild()));
        } else { // MATCH FOUND!
            if (node.isLeaf()) {
                node = null; // just remove
            } else if (node.getLeftChild() == null) {
                node = node.getRightChild(); // connect next right child
            } else if (node.getRightChild() == null) {
                node = node.getLeftChild(); // connect next left child
            } else {
                // swap with the greatest node of the left child
                N predecessor = getMostRightNode(node.getLeftChild());

                N leftChild = deleteNode(predecessor.getData(), node.getLeftChild());
                node = createNode(predecessor.getData(), leftChild, node.getRightChild());
            }
        }

        return recalculateNode(node);
    }

    private N getMostRightNode(N node) {
        while (node.getRightChild() != null) {
            node = node.getRightChild();
        }
        return node;
    }

    private N getKthMinimum(N node, int k) {
        if (node == null) {
            return null;
        }
        int n = 1; // root node
        if (node.getLeftChild() != null) {
            n += node.getLeftChild().size();
        }

        if (n == k) {
            return node;
        } else if (n > k) {
            return getKthMinimum(node.getLeftChild(), k);
        }
        return getKthMinimum(node.getRightChild(), k - n);
    }

    private N getKthMaximum(N node, int k) {
        if (node == null) {
            return null;
        }

        int n = 1; // root node
        if (node.getRightChild() != null) {
            n += node.getRightChild().size();
        }

        if (n == k) {
            return node;
        } else if (n > k) {
            return getKthMaximum(node.getRightChild(), k);
        }
        return getKthMaximum(node.getLeftChild(), k - n);
    }

    private String inOrderTraversal(N node) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractBinarySearchTree<?, ?> that = (AbstractBinarySearchTree<?, ?>) o;
        return Objects.equals(root, that.root);
    }

    @Override
    public int hashCode() {
        return isEmpty() ? 0 : root.hashCode();
    }
}
