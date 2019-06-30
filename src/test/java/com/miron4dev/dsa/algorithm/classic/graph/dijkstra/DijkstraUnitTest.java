package com.miron4dev.dsa.algorithm.classic.graph.dijkstra;

import org.junit.Test;

public class DijkstraUnitTest {

	private final Dijkstra dijkstra = new Dijkstra();

	@Test
	public void getShortestPathTo() {
		Vertex vertex0 = new Vertex("A");
		Vertex vertex1 = new Vertex("B");
		Vertex vertex2 = new Vertex("C");

		vertex0.addNeighbour(new Edge(1, vertex0, vertex1));
		vertex0.addNeighbour(new Edge(3, vertex0, vertex2));
		vertex1.addNeighbour(new Edge(1, vertex1, vertex2));

		dijkstra.computePaths(vertex0);

		System.out.println(dijkstra.getShortestPathTo(vertex2));
	}

}