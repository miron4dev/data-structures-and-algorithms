package com.miron4dev.dsa.datastructure.tree.bst.rb;

import com.miron4dev.dsa.datastructure.tree.Tree;
import com.miron4dev.dsa.datastructure.tree.bst.BinarySearchTreeUnitTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RedBlackTreeTest extends BinarySearchTreeUnitTest {

    @Test
    public void insertWithLeftLeftCaseRotation() {
        Tree<Integer> tree = new RedBlackTree<>();
        tree.insert(5);
        tree.insert(4);
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);

        assertEquals("1 -> 2 -> 3 -> 4 -> 5 -> ", tree.toString());
    }

    @Test
    public void insertWithRightRightCaseRotation() {
        Tree<Integer> tree = new RedBlackTree<>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);

        assertEquals("1 -> 2 -> 3 -> 4 -> 5 -> ", tree.toString());
    }

    @Test
    public void insertWithLeftRightCaseRotation() {
        Tree<Integer> tree = new RedBlackTree<>();

        tree.insert(2);
        tree.insert(1);
        tree.insert(6);
        tree.insert(4);
        tree.insert(5);

        assertEquals("1 -> 2 -> 4 -> 5 -> 6 -> ", tree.toString());
    }

    @Test
    public void insertWithRightLeftCaseRotation() {
        Tree<Integer> tree = new RedBlackTree<>();

        tree.insert(2);
        tree.insert(1);
        tree.insert(6);
        tree.insert(4);
        tree.insert(3);

        assertEquals("1 -> 2 -> 3 -> 4 -> 6 -> ", tree.toString());
    }
}