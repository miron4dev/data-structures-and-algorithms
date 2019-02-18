package com.miron4dev.dsa.datastructure.tree.bst;

import com.miron4dev.dsa.datastructure.tree.Tree;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeUnitTest {

    @Test
    public void insert() {
        Tree<Integer> tree = new BinarySearchTree<>();
        tree.insert(10);
        tree.insert(4);
        tree.insert(8);
        tree.insert(14);
        tree.insert(1);


        assertTrue(tree.isBalanced());

        assertEquals(5, tree.size());
    }

    @Test
    public void getMin() {
        Tree<Integer> tree = new BinarySearchTree<>();
        tree.insert(10);
        tree.insert(4);
        tree.insert(8);
        tree.insert(14);
        tree.insert(1);

        assertEquals(new Integer(1), tree.getMin());
    }

    @Test
    public void getMax() {
        Tree<Integer> tree = new BinarySearchTree<>();
        tree.insert(10);
        tree.insert(4);
        tree.insert(8);
        tree.insert(14);
        tree.insert(1);

        assertEquals(new Integer(14), tree.getMax());
    }

    @Test
    public void deleteLeaf() {
        Tree<Integer> tree = new BinarySearchTree<>();
        tree.insert(10);
        tree.insert(4);
        tree.insert(8);
        tree.insert(14);
        tree.insert(1);

        tree.delete(1);

        assertEquals(4, tree.size());
        assertEquals("4 -> 8 -> 10 -> 14 -> ", tree.toString());
    }

    @Test
    public void deleteWithLeftChild() {
        Tree<Integer> tree = new BinarySearchTree<>();
        tree.insert(10);
        tree.insert(4);
        tree.insert(14);
        tree.insert(1);

        tree.delete(4);

        assertEquals(3, tree.size());
        assertEquals("1 -> 10 -> 14 -> ", tree.toString());
    }

    @Test
    public void deleteWithRightChild() {
        Tree<Integer> tree = new BinarySearchTree<>();
        tree.insert(10);
        tree.insert(4);
        tree.insert(8);
        tree.insert(14);

        tree.delete(8);

        assertEquals(3, tree.size());
        assertEquals("4 -> 10 -> 14 -> ", tree.toString());
    }

    @Test
    public void deleteRoot() {
        Tree<Integer> tree = new BinarySearchTree<>();
        tree.insert(10);
        tree.insert(4);
        tree.insert(8);
        tree.insert(14);
        tree.insert(1);

        tree.delete(10);

        assertEquals(4, tree.size());
        assertEquals("1 -> 4 -> 8 -> 14 -> ", tree.toString());
    }

    @Test
    public void isBalancedTrue() {
        Tree<Integer> tree = new BinarySearchTree<>();
        tree.insert(10);
        tree.insert(4);
        tree.insert(8);
        tree.insert(14);
        tree.insert(1);

        assertTrue(tree.isBalanced());
    }

    @Test
    public void isBalancedFalse() {
        Tree<Integer> tree = new BinarySearchTree<>();
        tree.insert(1);
        tree.insert(4);
        tree.insert(8);
        tree.insert(14);

        assertFalse(tree.isBalanced());
    }

    @Test
    public void testToString() {
        Tree<Integer> tree = new BinarySearchTree<>();
        tree.insert(10);
        tree.insert(4);
        tree.insert(8);
        tree.insert(14);
        tree.insert(1);

        assertEquals("1 -> 4 -> 8 -> 10 -> 14 -> ", tree.toString());
    }

    @Test
    public void testEquals() {
        Tree<Integer> tree = new BinarySearchTree<>();
        tree.insert(10);
        tree.insert(4);
        tree.insert(8);
        tree.insert(14);
        tree.insert(1);

        Tree<Integer> bst2 = new BinarySearchTree<>();
        bst2.insert(10);
        bst2.insert(4);
        bst2.insert(8);
        bst2.insert(14);
        bst2.insert(1);

        assertEquals(bst2, tree);
    }

    @Test
    public void testNotEqualsBecauseOfOrder() {
        Tree<Integer> tree = new BinarySearchTree<>();
        tree.insert(10);
        tree.insert(4);
        tree.insert(8);
        tree.insert(14);
        tree.insert(1);

        Tree<Integer> bst2 = new BinarySearchTree<>();
        bst2.insert(10);
        bst2.insert(8);
        bst2.insert(4);
        bst2.insert(14);
        bst2.insert(1);

        assertNotEquals(bst2, tree);
    }

    @Test
    public void testNotEqualsBecauseValues() {
        Tree<Integer> tree = new BinarySearchTree<>();
        tree.insert(10);
        tree.insert(4);
        tree.insert(8);
        tree.insert(14);
        tree.insert(1);

        Tree<Integer> bst2 = new BinarySearchTree<>();
        bst2.insert(10);
        bst2.insert(4);
        bst2.insert(8);
        bst2.insert(14);

        assertNotEquals(bst2, tree);
    }

    @Test
    public void testHashCode() {
        Tree<Integer> tree = new BinarySearchTree<>();
        tree.insert(10);
        tree.insert(4);
        tree.insert(8);
        tree.insert(14);
        tree.insert(1);

        assertEquals(-1633904680, tree.hashCode());
    }

}