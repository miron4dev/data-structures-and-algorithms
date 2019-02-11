package com.miron4dev.dsa.graph.traversal;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.miron4dev.dsa.graph.Vertex;

public class BreadthFirstSearchUnitTest {

	private final BreadthFirstSearch bfs = new BreadthFirstSearch();

	@Test
	public void traverse() {
		Vertex root = new Vertex("S");
		Vertex vertex1 = new Vertex("1");
		Vertex vertex2 = new Vertex("2");
		Vertex vertex3 = new Vertex("3");
		Vertex vertex4 = new Vertex("4");
		Vertex vertex5 = new Vertex("5");

		root.addNeighbour(vertex1);
		root.addNeighbour(vertex2);

		vertex1.addNeighbour(vertex3);
		vertex2.addNeighbour(vertex3);
		vertex2.addNeighbour(vertex4);
		vertex3.addNeighbour(vertex5);

		bfs.traverse(root);

		boolean allVertexesAreVisited = root.isVisited() && root.getNeighbours().stream().allMatch(Vertex::isVisited);
		assertTrue(allVertexesAreVisited);
	}

}