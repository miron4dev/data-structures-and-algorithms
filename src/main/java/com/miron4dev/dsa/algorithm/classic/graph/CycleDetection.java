package com.miron4dev.dsa.algorithm.classic.graph;

import java.util.ArrayList;
import java.util.List;

public class CycleDetection {

	private final List<Vertex> cycles = new ArrayList<>();

	public void detectCycle(List<Vertex> vertexList) {
		for (Vertex vertex : vertexList) {
			if (!vertex.isVisited()) {
				dfs(vertex);
			}
		}
	}

	private void dfs(Vertex vertex) {
		System.out.println("Start DFS on vertex " + vertex);

		vertex.setBeingVisited(true);

		for (Vertex neighbour : vertex.getNeighbours()) {
			if (neighbour.isBeingVisited()) {
				System.out.println("There is a cycle!");
				cycles.add(neighbour);
				return;
			}

			if (!neighbour.isVisited()) {
				System.out.println("Visiting vertex " + neighbour + " recursively..");
				neighbour.setVisited(true);
				dfs(neighbour);
			}
		}

		System.out.println("Finish DFS on vertex " + vertex);
		vertex.setBeingVisited(false);
		vertex.setVisited(true);
	}

	public boolean isCycleDetected() {
		return cycles.size() > 0;
	}

	public List<Vertex> getCycles() {
		return cycles;
	}
}
