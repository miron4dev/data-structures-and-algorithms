package com.miron4dev.dsa.algorithm.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 */
public class LRUCache {

	private final Map<Integer, Entry> cache;
	private final int capacity;

	private Entry head;
	private Entry tail;

	public LRUCache(int capacity) {
		this.cache = new HashMap<>(capacity);
		this.capacity = capacity;
	}

	public int get(int key) {
		if (!cache.containsKey(key)) {
			return -1;
		}

		Entry entry = cache.get(key);

		remove(entry);
		add(entry);

		return entry.value;
	}

	public void put(int key, int value) {
		if (cache.containsKey(key)) {
			Entry entry = cache.get(key);
			entry.value = value;

			remove(entry);
			add(entry);
		} else {
			Entry entry = new Entry(key, value);

			if (cache.size() == capacity) {
				cache.remove(this.tail.key);
				remove(this.tail);
			}

			add(entry);
			cache.put(entry.key, entry);
		}
	}

	private void remove(Entry entry) {
		if (entry.prev != null) {
			entry.prev.next = entry.next;
		} else {
			this.head = entry.next;
		}

		if (entry.next != null) {
			entry.next.prev = entry.prev;
		} else {
			this.tail = entry.prev;
		}
	}

	private void add(Entry entry) {
		Entry prevHead = this.head;
		entry.next = prevHead;
		entry.prev = null;

		this.head = entry;

		if (prevHead == null) {
			this.tail = entry;
		} else {
			prevHead.prev = entry;
		}
	}

	private static class Entry {
		private int key;
		private int value;
		private Entry prev;
		private Entry next;

		public Entry(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
}