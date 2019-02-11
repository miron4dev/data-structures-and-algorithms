package com.miron4dev.dsa.string;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 */
public class FirstUniqueChar {

	private final String str;

	public FirstUniqueChar(String str) {
		this.str = str;
	}

	public int firstUniqChar() {
		int[] frequently = new int[26];
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			frequently[chars[i] - 'a'] = frequently[chars[i] - 'a'] + 1;
		}

		for (int i = 0; i < chars.length; i++) {
			if (frequently[chars[i] - 'a'] == 1) {
				return i;
			}
		}

		return -1;
	}
}
