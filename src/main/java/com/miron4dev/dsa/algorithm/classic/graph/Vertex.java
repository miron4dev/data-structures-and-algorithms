package com.miron4dev.dsa.algorithm.classic.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	private final String name;
	private boolean visited;
	private boolean beingVisited;
	private final List<Vertex> neighbours = new ArrayList<>();

	public Vertex(String name) {
		this.name = name;
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

	public boolean isBeingVisited() {
		return beingVisited;
	}

	public void setBeingVisited(boolean beingVisited) {
		this.beingVisited = beingVisited;
	}

	public void addNeighbour(Vertex vertex) {
		neighbours.add(vertex);
	}

	public List<Vertex> getNeighbours() {
		return neighbours;
	}

	@Override
	public String toString() {
		return name;
	}

}
