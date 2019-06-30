package com.miron4dev.dsa.algorithm.leetcode.string;

/**
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * You may assume all the characters consist of printable ascii characters.
 */
public class Reverse {

	private final char[] chars;

	public Reverse(String str) {
		this.chars = str.toCharArray();
	}

	public void reverse() {
		for (int i = 0; i < chars.length / 2; i++) {
			char temp = chars[i];
			chars[i] = chars[chars.length - i - 1];
			chars[chars.length - i - 1] = temp;
		}
	}

	public void recursionReverse() {
		helper(0, chars.length - 1);
	}

	public String getString() {
		return new String(chars);
	}

	private void helper(int start, int end) {
		if (start >= end) {
			return;
		}

		char temp = chars[start];
		chars[start] = chars[end];
		chars[end] = temp;

		helper(++start, --end);
	}
}
