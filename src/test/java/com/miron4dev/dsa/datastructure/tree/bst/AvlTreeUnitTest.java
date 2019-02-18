package com.miron4dev.dsa.datastructure.tree.bst;

import com.miron4dev.dsa.datastructure.tree.Tree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AvlTreeUnitTest extends BinarySearchTreeUnitTest {

    @Test
    public void insertWithLeftLeftCaseRotation() {
        Tree<Integer> tree = new AvlTree<>();
        tree.insert(5);
        tree.insert(4);
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);

        assertTrue(tree.isBalanced());

        assertEquals("1 -> 2 -> 3 -> 4 -> 5 -> ", tree.toString());
    }

    @Test
    public void insertWithRightRightCaseRotation() {
        Tree<Integer> tree = new AvlTree<>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);

        assertTrue(tree.isBalanced());

        assertEquals("1 -> 2 -> 3 -> 4 -> 5 -> ", tree.toString());
    }

    @Test
    public void insertWithLeftRightCaseRotation() {
        Tree<Integer> tree = new AvlTree<>();

        tree.insert(2);
        tree.insert(1);
        tree.insert(6);
        tree.insert(4);
        tree.insert(5);

        assertTrue(tree.isBalanced());

        assertEquals("1 -> 2 -> 4 -> 5 -> 6 -> ", tree.toString());
    }

    @Test
    public void insertWithRightLeftCaseRotation() {
        Tree<Integer> tree = new AvlTree<>();

        tree.insert(2);
        tree.insert(1);
        tree.insert(6);
        tree.insert(4);
        tree.insert(3);

        assertTrue(tree.isBalanced());

        assertEquals("1 -> 2 -> 3 -> 4 -> 6 -> ", tree.toString());
    }

    @Test
    public void deleteWithLeftLeftCaseRotation() {
        Tree<Integer> tree = new AvlTree<>();
        tree.insert(3);
        tree.insert(2);
        tree.insert(4);
        tree.insert(1);

        tree.delete(4);

        assertTrue(tree.isBalanced());

        assertEquals("1 -> 2 -> 3 -> ", tree.toString());
    }

    @Test
    public void deleteWithRightRightCaseRotation() {
        Tree<Integer> tree = new AvlTree<>();
        tree.insert(3);
        tree.insert(1);
        tree.insert(4);
        tree.insert(5);

        tree.delete(5);

        assertTrue(tree.isBalanced());

        assertEquals("1 -> 3 -> 4 -> ", tree.toString());
    }

    @Test
    public void deleteWithLeftRightCaseRotation() {
        Tree<Integer> tree = new AvlTree<>();

        tree.insert(4);
        tree.insert(3);
        tree.insert(5);
        tree.insert(2);

        tree.delete(5);

        assertTrue(tree.isBalanced());

        assertEquals("2 -> 3 -> 4 -> ", tree.toString());
    }

    @Test
    public void deleteWithRightLeftCaseRotation() {
        Tree<Integer> tree = new AvlTree<>();

        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.insert(3);

        tree.delete(1);

        assertTrue(tree.isBalanced());

        assertEquals("2 -> 3 -> 4 -> ", tree.toString());
    }

}