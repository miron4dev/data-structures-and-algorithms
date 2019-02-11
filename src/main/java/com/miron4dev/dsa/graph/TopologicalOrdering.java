package com.miron4dev.dsa.graph;

import java.util.Stack;

public class TopologicalOrdering {

	private final Stack<Vertex> stack = new Stack<>();

	public void dfs(Vertex root) {
		root.setVisited(true);

		for (Vertex neighbour : root.getNeighbours()) {
			if (!neighbour.isVisited()) {
				dfs(neighbour);
			}
		}

		stack.push(root);
	}

	public Stack<Vertex> getStack() {
		return stack;
	}
}
