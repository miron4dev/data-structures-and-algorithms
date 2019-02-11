package com.miron4dev.dsa.graph.dijkstra;

public class Edge {

	private final double weight;
	private final Vertex startVertex;
	private final Vertex targetVertex;

	public Edge(double weight, Vertex startVertex, Vertex targetVertex) {
		this.weight = weight;
		this.startVertex = startVertex;
		this.targetVertex = targetVertex;
	}

	public double getWeight() {
		return weight;
	}

	public Vertex getStartVertex() {
		return startVertex;
	}

	public Vertex getTargetVertex() {
		return targetVertex;
	}
}
