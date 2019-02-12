package com.miron4dev.dsa.algorithm.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

public class TopologicalOrderingUnitTest {

	@Test
	public void dfs() {
		TopologicalOrdering topologicalOrdering = new TopologicalOrdering();

		List<Vertex> graph = new ArrayList<>();

		Vertex vertex0 = new Vertex("0");
		Vertex vertex1 = new Vertex("1");
		Vertex vertex2 = new Vertex("2");
		Vertex vertex3 = new Vertex("3");
		Vertex vertex4 = new Vertex("4");
		Vertex vertex5 = new Vertex("5");

		graph.add(vertex0);
		graph.add(vertex1);
		graph.add(vertex2);
		graph.add(vertex3);
		graph.add(vertex4);
		graph.add(vertex5);

		vertex2.addNeighbour(vertex3);

		vertex3.addNeighbour(vertex1);

		vertex4.addNeighbour(vertex0);
		vertex4.addNeighbour(vertex1);

		vertex5.addNeighbour(vertex0);
		vertex5.addNeighbour(vertex2);

		for (Vertex vertex : graph) {
			if (!vertex.isVisited()) {
				topologicalOrdering.dfs(vertex);
			}
		}

		Stack<Vertex> stack = topologicalOrdering.getStack();

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}