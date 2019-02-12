package com.miron4dev.dsa.algorithm.graph.traversal;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.miron4dev.dsa.algorithm.graph.Vertex;

public class DepthFirstSearchIterativeUnitTest {

	private final DepthFirstSearchIterative dfs = new DepthFirstSearchIterative();

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

		dfs.traverse(root);

		boolean allVertexesAreVisited = root.isVisited() && root.getNeighbours().stream().allMatch(Vertex::isVisited);
		assertTrue(allVertexesAreVisited);
	}
}