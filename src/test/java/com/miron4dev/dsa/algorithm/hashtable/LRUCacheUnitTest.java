package com.miron4dev.dsa.algorithm.hashtable;

import static org.junit.Assert.*;

import org.junit.Test;

public class LRUCacheUnitTest {

	@Test
	public void test() {
		LRUCache cache = new LRUCache(2);

		cache.put(1, 1);
		cache.put(2, 2);
		assertEquals(1, cache.get(1));
		cache.put(3, 3);
		assertEquals(-1, cache.get(2));
		cache.put(4, 4);
		assertEquals(-1, cache.get(1));
		assertEquals(3, cache.get(3));
		assertEquals(4, cache.get(4));
	}
}