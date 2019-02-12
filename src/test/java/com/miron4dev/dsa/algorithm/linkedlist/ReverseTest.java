package com.miron4dev.dsa.algorithm.linkedlist;

import com.miron4dev.dsa.datastructure.linkedlist.singly.SinglyListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseTest {

    private final Reverse<Integer> reverse = new Reverse<>();

    @Test
    public void reverseIteratively() {
        SinglyListNode<Integer> root = createNode(1, 2, 3, 4, 5);


        SinglyListNode<Integer> expected = createNode(5, 4, 3, 2, 1);

        SinglyListNode<Integer> actual = reverse.reverseIteratively(root);
        assertEquals(expected, actual);
    }

    @Test
    public void reverseRecursively() {
        SinglyListNode<Integer> root = createNode(1, 2, 3, 4, 5);


        SinglyListNode<Integer> expected = createNode(5, 4, 3, 2, 1);

        SinglyListNode<Integer> actual = reverse.reverseRecursively(root);
        assertEquals(expected, actual);
    }

    private SinglyListNode<Integer> createNode(int... val) {
        SinglyListNode<Integer> root = new SinglyListNode<>(0);
        SinglyListNode<Integer> cursor = root;
        for (int i : val) {
            SinglyListNode<Integer> node = new SinglyListNode<>(i);
            cursor.setNext(node);
            cursor = node;
        }
        return root.getNext();
    }

}