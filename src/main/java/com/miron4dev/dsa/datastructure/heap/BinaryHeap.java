package com.miron4dev.dsa.datastructure.heap;

import java.util.Arrays;

public class BinaryHeap<T extends Comparable<T>> implements Heap<T> {

    private final int capacity;
    private Object[] heap;
    private int heapSize;

    public BinaryHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new Object[capacity];
    }

    public BinaryHeap() {
        this(10);
    }

    @Override
    public void insert(T data) {
        if (isFull()) {
            throw new RuntimeException("Could not insert to heap because it's full");
        }

        heap[heapSize] = data;

        heapSize++;

        fixUp(heapSize - 1);
    }

    @Override
    public T poll() {
        T max = getMax();

        if (max == null) {
            return null;
        }

        swap(0, heapSize - 1);

        heapSize--;

        fixDown(0);

        return max;
    }

    @Override
    public T getMax() {
        return heapSize > 0 ? (T) heap[0] : null;
    }

    @Override
    public T getMin() {
        return heapSize > 0 ? (T) heap[heapSize - 1] : null;
    }

    @Override
    public T[] sort() {
        Object[] heapCopy = Arrays.copyOf(heap, heapSize);
        int size = heapSize;

        T[] result = (T[]) new Comparable[size];
        for (int i = 0; i < size; i++) {
            result[i] = pollMin();
        }

        this.heap = heapCopy;
        this.heapSize = size;
        return result;
    }

    @Override
    public int size() {
        return heapSize;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean isFull() {
        return size() == capacity;
    }

    @Override
    public String toString() {
        return Arrays.toString(heap);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryHeap<?> that = (BinaryHeap<?>) o;
        return Arrays.equals(heap, that.heap);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(heap);
    }

    private void fixUp(int index) {
        int parentIndex = (index - 1) / 2;

        T value = (T) heap[index];
        T parentValue = (T) heap[parentIndex];

        if (index > 0 && value.compareTo(parentValue) > 0) {
            swap(index, parentIndex);
            fixUp(parentIndex);
        }
    }

    private void fixDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        // parent is always considered as largest
        int largestIndex = index;

        // left child is greater than largest
        if (leftChildIndex < heapSize && ((T) heap[leftChildIndex]).compareTo((T) heap[largestIndex]) > 0) {
            largestIndex = leftChildIndex;
        }

        // right child is greater than largest
        if (rightChildIndex < heapSize && ((T) heap[rightChildIndex]).compareTo((T) heap[largestIndex]) > 0) {
            largestIndex = rightChildIndex;
        }

        if (index != largestIndex) {
            swap(index, largestIndex);
            fixDown(largestIndex);
        }
    }

    private void swap(int index, int parentIndex) {
        Object temp = heap[index];
        heap[index] = heap[parentIndex];
        heap[parentIndex] = temp;
    }

    private T pollMin() {
        T min = getMin();

        if (min == null) {
            return null;
        }

        heap[--heapSize] = null;

        return min;
    }

}
