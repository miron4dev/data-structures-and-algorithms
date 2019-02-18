package com.miron4dev.dsa.datastructure.tree.bst;

import com.miron4dev.dsa.datastructure.tree.Tree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class SplayTreeTest extends BinarySearchTreeUnitTest {

    @Test
    public void insert() {
        Tree<Integer> tree = new SplayTree<>();

        tree.insert(10);
        assertEquals(new Integer(10), tree.getRoot().getData());

        tree.insert(4);
        assertEquals(new Integer(4), tree.getRoot().getData());

        tree.insert(8);
        assertEquals(new Integer(8), tree.getRoot().getData());

        tree.insert(14);
        assertEquals(new Integer(14), tree.getRoot().getData());

        tree.insert(1);
        assertEquals(new Integer(1), tree.getRoot().getData());

        assertFalse(tree.isBalanced());

        assertEquals(5, tree.size());
    }

    @Test
    public void find() {
        Tree<Integer> tree = new SplayTree<>();
        tree.insert(10);
        tree.insert(4);
        tree.insert(8);
        tree.insert(14);
        tree.insert(1);

        // last inserted item
        assertEquals(new Integer(1), tree.getRoot().getData());

        assertEquals(tree.find(10), tree.getRoot());
        assertEquals(tree.find(4), tree.getRoot());
        assertEquals(tree.find(8), tree.getRoot());
        assertEquals(tree.find(14), tree.getRoot());
        assertEquals(tree.find(1), tree.getRoot());
    }
}