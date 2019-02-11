package com.miron4dev.dsa.graph.traversal;

import com.miron4dev.dsa.graph.Vertex;

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
