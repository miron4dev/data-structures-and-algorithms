package com.miron4dev.dsa.datastructure.linkedlist.singly;

/**
 * Definition for singly-linked list.
 */
public class SinglyListNode<T extends Comparable<T>> {

    private T value;
    private SinglyListNode<T> next;

    public SinglyListNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public SinglyListNode<T> getNext() {
        return next;
    }

    public void setNext(SinglyListNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object anotherNode) {
        if (this == anotherNode)
            return true;

        if (anotherNode == null || getClass() != anotherNode.getClass()) {
            return false;
        }

        return equals(this, (SinglyListNode<T>) anotherNode);
    }

    @Override
    public int hashCode() {
        int result = 1;

        result = 31 * result + value.hashCode();
        result = 31 * result + (next != null ? next.hashCode() : 0);

        return result;
    }

    private boolean equals(SinglyListNode<T> node1, SinglyListNode<T> node2) {
        if (node1 == null || node2 == null) {
            return node1 == node2;
        }

        if (node1.getValue().compareTo(node2.getValue()) != 0) {
            return false;
        }

        return equals(node1.getNext(), node2.getNext());
    }

}
