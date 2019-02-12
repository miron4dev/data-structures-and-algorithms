package com.miron4dev.dsa.datastructure.linkedlist.doubly;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class DoublyLinkedListUnitTest {


	@Test
	public void add() {
		List<Integer> list = new DoublyLinkedList<>();
		list.add(3);
		list.add(2);
		list.add(5);
		list.add(15);
		list.add(8);

		assertEquals(5, list.size());

		assertEquals("3 <-> 2 <-> 5 <-> 15 <-> 8 <-> ", list.toString());
	}

	@Test
	public void get() {
		List<Integer> list = new DoublyLinkedList<>();
		list.add(3);
		list.add(2);
		list.add(5);
		list.add(15);
		list.add(8);

		assertEquals(new Integer(3), list.get(0));
		assertEquals(new Integer(2), list.get(1));
		assertEquals(new Integer(5), list.get(2));
		assertEquals(new Integer(15), list.get(3));
		assertEquals(new Integer(8), list.get(4));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void getWithIncorrectIndex() {
		List<Integer> list = new DoublyLinkedList<>();
		list.add(3);

		list.get(1);
	}

	@Test
	public void removeMiddle() {
		List<Integer> list = new DoublyLinkedList<>();
		list.add(3);
		list.add(2);
		list.add(5);
		list.add(15);
		list.add(8);

		assertEquals(new Integer(5), list.remove(2));

		assertEquals(4, list.size());


		assertEquals("3 <-> 2 <-> 15 <-> 8 <-> ", list.toString());
	}

	@Test
	public void removeFirst() {
		List<Integer> list = new DoublyLinkedList<>();
		list.add(3);
		list.add(2);
		list.add(5);
		list.add(15);
		list.add(8);

		assertEquals(new Integer(3), list.remove(0));

		assertEquals(4, list.size());


		assertEquals("2 <-> 5 <-> 15 <-> 8 <-> ", list.toString());
	}

	@Test
	public void removeLast() {
		List<Integer> list = new DoublyLinkedList<>();
		list.add(3);
		list.add(2);
		list.add(5);
		list.add(15);
		list.add(8);

		assertEquals(new Integer(8), list.remove(4));

		assertEquals(4, list.size());


		assertEquals("3 <-> 2 <-> 5 <-> 15 <-> ", list.toString());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void removeWithIncorrectIndex() {
		List<Integer> list = new DoublyLinkedList<>();
		list.add(3);

		list.remove(1);
	}

	@Test
	public void set() {
		List<Integer> list = new DoublyLinkedList<>();
		list.add(3);
		list.add(2);
		list.add(5);
		list.add(15);
		list.add(8);


		assertEquals(new Integer(5), list.set(2, 100));

		assertEquals(5, list.size());

		assertEquals("3 <-> 2 <-> 100 <-> 15 <-> 8 <-> ", list.toString());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void setWithIncorrectIndex() {
		List<Integer> list = new DoublyLinkedList<>();
		list.add(3);

		list.set(1, 2);
	}

}