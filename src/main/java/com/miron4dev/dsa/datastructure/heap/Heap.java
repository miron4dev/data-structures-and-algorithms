package com.miron4dev.dsa.datastructure.heap;

public interface Heap<T extends Comparable<T>> {

    void insert(T data);

    T poll();

    T getMax();

    T getMin();

    T[] sort();

    int size();

    boolean isEmpty();

    boolean isFull();
}
