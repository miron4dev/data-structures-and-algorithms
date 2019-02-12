package com.miron4dev.dsa.algorithm.graph.dijkstra;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {

	private final List<Edge> adjacenciesList = new ArrayList<>();
	private final String name;

	private boolean visited;
	private Vertex predecessor;
	private double distance = Double.MAX_VALUE;

	public Vertex(String name) {
		this.name = name;
	}

	public void addNeighbour(Edge edge) {
		this.adjacenciesList.add(edge);
	}

	public List<Edge> getAdjacenciesList() {
		return adjacenciesList;
	}

	public String getName() {
		return name;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Vertex getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(Vertex predecessor) {
		this.predecessor = predecessor;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public int compareTo(Vertex o) {
		return Double.compare(this.distance, o.distance);
	}
}
