package com.miron4dev.dsa.datastructure.heap;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryHeapTest {

    @Test
    public void insert() {
        Heap<Integer> heap = new BinaryHeap<>(3);
        heap.insert(5);
        heap.insert(8);
        heap.insert(15);

        assertTrue(heap.isFull());
        assertEquals(3, heap.size());
    }

    @Test(expected = RuntimeException.class)
    public void insertFull() {
        Heap<Integer> heap = new BinaryHeap<>(1);
        heap.insert(5);
        assertTrue(heap.isFull());

        heap.insert(10);
    }

    @Test
    public void poll() {
        Heap<Integer> heap = new BinaryHeap<>(3);
        heap.insert(5);
        heap.insert(15);
        heap.insert(4);

        assertEquals(new Integer(15), heap.poll());
    }

    @Test
    public void pollEmpty() {
        Heap<Integer> heap = new BinaryHeap<>(1);
        heap.isEmpty();
        assertNull(heap.poll());
    }

    @Test
    public void getMax() {
        Heap<Integer> heap = new BinaryHeap<>(3);
        heap.insert(5);
        heap.insert(15);
        heap.insert(4);

        assertEquals(new Integer(15), heap.getMax());
    }

    @Test
    public void getMin() {
        Heap<Integer> heap = new BinaryHeap<>(3);
        heap.insert(5);
        heap.insert(15);
        heap.insert(4);

        assertEquals(new Integer(4), heap.getMin());
    }

    @Test
    public void sort() {
        Heap<Integer> heap = new BinaryHeap<>(3);
        heap.insert(5);
        heap.insert(15);
        heap.insert(4);

        assertTrue(heap.isFull());
        assertEquals(3, heap.size());

        Integer[] expected = new Integer[]{4, 5, 15};
        assertArrayEquals(expected, heap.sort());

        assertTrue(heap.isFull());
        assertEquals(3, heap.size());
    }
}