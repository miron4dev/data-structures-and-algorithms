package com.miron4dev.dsa.algorithm.classic.graph.traversal;

import com.miron4dev.dsa.algorithm.classic.graph.Vertex;

public class DepthFirstSearchRecursive implements GraphTraversal {

	@Override
	public void traverse(Vertex root) {
		root.setVisited(true);

		for (Vertex neighbour : root.getNeighbours()) {
			if (!neighbour.isVisited()) {
				traverse(neighbour);
			}
		}
	}
}
