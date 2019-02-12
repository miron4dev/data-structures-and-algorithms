package com.miron4dev.dsa.algorithm.graph.traversal;

import java.util.LinkedList;
import java.util.Queue;

import com.miron4dev.dsa.algorithm.graph.Vertex;

public class BreadthFirstSearch implements GraphTraversal {

	@Override
	public void traverse(Vertex root) {
		Queue<Vertex> queue = new LinkedList<>();

		root.setVisited(true);
		queue.add(root);

		while (!queue.isEmpty()) {
			Vertex vertex = queue.poll();

			for (Vertex neighbour : vertex.getNeighbours()) {
				if (!neighbour.isVisited()) {
					queue.add(neighbour);
					neighbour.setVisited(true);
				}
			}
		}
	}
}
