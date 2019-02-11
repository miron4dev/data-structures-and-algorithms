package com.miron4dev.dsa.graph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CycleDetectionUnitTest {

	@Test
	public void detectCycle() {
		CycleDetection cycleDetection = new CycleDetection();

		Vertex vertex1 = new Vertex("1");
		Vertex vertex2 = new Vertex("2");
		Vertex vertex3 = new Vertex("3");
		Vertex vertex4 = new Vertex("4");
		Vertex vertex5 = new Vertex("5");
		Vertex vertex6 = new Vertex("6");

		vertex1.addNeighbour(vertex2);
		vertex1.addNeighbour(vertex3);
		vertex2.addNeighbour(vertex3);
		vertex4.addNeighbour(vertex1);
		vertex4.addNeighbour(vertex5);
		vertex5.addNeighbour(vertex6);
		vertex6.addNeighbour(vertex4);

		List<Vertex> vertexList = Arrays.asList(vertex1, vertex2, vertex3, vertex4, vertex5, vertex6);

		cycleDetection.detectCycle(vertexList);

		assertTrue(cycleDetection.isCycleDetected());
		assertEquals(1, cycleDetection.getCycles().size());
		assertEquals("4", cycleDetection.getCycles().get(0).getName());
	}

}