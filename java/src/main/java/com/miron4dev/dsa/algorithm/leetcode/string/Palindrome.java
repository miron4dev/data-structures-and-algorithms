package com.miron4dev.dsa.algorithm.leetcode.string;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 */
public class Palindrome {

	private static final char[] charMap = new char[256]; // works only for ASCII

	static {
		for (int i = 0; i < 10; i++) {
			charMap[i + '0'] = (char) (1 + i); // fill 0 .. 9 characters from 1 to 10
		}
		for (int i = 0; i < 26; i++) {
			charMap[i + 'a'] = charMap[i + 'A'] = (char) (11 + i); // fill a .. z, A .. Z characters from 11 to 36. lowerCase = upperCase
		}
	}

	private final String str;

	public Palindrome(String str) {
		this.str = str;
	}

	public boolean isPalindrome() {
		if (str.isEmpty()) {
			return true;
		}

		int start = 0;
		int end = str.length() - 1;
		char[] chars = str.toCharArray();

		while (start < end) {
			char a = charMap[chars[start]];
			char b = charMap[chars[end]];

			if (a == 0) {
				start++;
				continue;
			} else if (b == 0) {
				end--;
				continue;
			}

			if (a != b) {
				return false;
			}

			start++;
			end--;
		}
		return true;
	}
}
