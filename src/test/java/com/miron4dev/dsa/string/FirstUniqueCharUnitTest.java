package com.miron4dev.dsa.string;

import static org.junit.Assert.*;

import org.junit.Test;

public class FirstUniqueCharUnitTest {

	@Test
	public void firstUniqChar() {
		assertEquals(0, new FirstUniqueChar("leetcode").firstUniqChar());

		assertEquals(2, new FirstUniqueChar("loveleetcode").firstUniqChar());
	}
}