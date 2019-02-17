package com.miron4dev.dsa.datastructure.tree.rb;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RedBlackTreeTest {


    @Test
    public void insertWithLeftLeftCaseRotation() {
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        tree.insert(5);
        tree.insert(4);
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);

        assertEquals("1 -> 2 -> 3 -> 4 -> 5 -> ", tree.toString());
    }

    @Test
    public void insertWithRightRightCaseRotation() {
        RedBlackTree<Integer> tree = new RedBlackTree<>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);

        assertEquals("1 -> 2 -> 3 -> 4 -> 5 -> ", tree.toString());
    }

    @Test
    public void insertWithLeftRightCaseRotation() {
        RedBlackTree<Integer> tree = new RedBlackTree<>();

        tree.insert(2);
        tree.insert(1);
        tree.insert(6);
        tree.insert(4);
        tree.insert(5);

        assertEquals("1 -> 2 -> 4 -> 5 -> 6 -> ", tree.toString());
    }

    @Test
    public void insertWithRightLeftCaseRotation() {
        RedBlackTree<Integer> tree = new RedBlackTree<>();

        tree.insert(2);
        tree.insert(1);
        tree.insert(6);
        tree.insert(4);
        tree.insert(3);

        assertEquals("1 -> 2 -> 3 -> 4 -> 6 -> ", tree.toString());
    }
}