package com.miron4dev.dsa.algorithm.leetcode.linkedlist;

import com.miron4dev.dsa.datastructure.linkedlist.singly.SinglyListNode;

/**
 * Given a singly linked list, determine if it is a palindrome.
 */
public class Palindrome<T extends Comparable<T>> {

	private final SinglyListNode<T> list;

	public Palindrome(SinglyListNode<T> list) {
		this.list = list;
	}

	public boolean isPalindrome() {
		SinglyListNode<T> slow = list;
		SinglyListNode<T> fast = list;

		while (fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}

		if (fast != null) {
			slow = slow.getNext();
		}
		slow = new Reverse<T>().reverseIteratively(slow);

		fast = list;
		while (slow != null) {
			if (slow.getValue().compareTo(fast.getValue()) != 0) {
				return false;
			}
			slow = slow.getNext();
			fast = fast.getNext();
		}
		return true;
	}
}
