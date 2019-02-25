package com.miron4dev.dsa.algorithm.leetcode.hashtable;

import static org.junit.Assert.*;

import org.junit.Test;

public class LRUCacheUnitTest {

	@Test
	public void test() {
		LRUCache<Integer, Integer> cache = new LRUCache<>(2);

		cache.put(1, 1);
		cache.put(2, 2);
		assertEquals(new Integer(1), cache.get(1));
		cache.put(3, 3);
		assertNull(cache.get(2));
		cache.put(4, 4);
		assertNull(cache.get(1));
		assertEquals(new Integer(3), cache.get(3));
		assertEquals(new Integer(4), cache.get(4));
	}
}