package com.miron4dev.dsa.algorithm.linkedlist;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.miron4dev.dsa.datastructure.linkedlist.singly.SinglyListNode;

public class PalindromeUnitTest {

	@Test
	public void isPalindromeTrue() {
		SinglyListNode<Integer> list = SinglyListNode.build(1, 2, 3, 2, 1);
		Palindrome<Integer> palindrome = new Palindrome<>(list);

		assertTrue(palindrome.isPalindrome());
	}

	@Test
	public void isPalindromeFalse() {
		SinglyListNode<Integer> list = SinglyListNode.build(1, 2);
		Palindrome<Integer> palindrome = new Palindrome<>(list);

		assertFalse(palindrome.isPalindrome());
	}

}