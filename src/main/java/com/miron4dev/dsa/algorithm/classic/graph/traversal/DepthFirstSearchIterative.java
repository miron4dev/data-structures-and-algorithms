package com.miron4dev.dsa.algorithm.classic.graph.traversal;

import java.util.Stack;

import com.miron4dev.dsa.algorithm.classic.graph.Vertex;

public class DepthFirstSearchIterative implements GraphTraversal {

	@Override
	public void traverse(Vertex root) {
		root.setVisited(true);

		Stack<Vertex> stack = new Stack<>();
		stack.add(root);

		while (!stack.isEmpty()) {
			Vertex vertex = stack.pop();

			for (Vertex neighbour : vertex.getNeighbours()) {
				if (!neighbour.isVisited()) {
					stack.add(neighbour);
					neighbour.setVisited(true);
				}
			}
		}
	}
}
