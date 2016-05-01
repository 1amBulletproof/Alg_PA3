/*
 * test for Graph class
 * 
 * @author Brandon Tarney 4/30/2016
 * @version 1.0
 */

package com.tarney.graph;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.hamcrest.core.Is.is;


public class VertexTest {
	
	static Vertex vertex;
	static ArrayList<Vertex> adjacencyList;
	
	@BeforeClass
	public static void setup() {
		adjacencyList = new ArrayList<>();
		vertex = new Vertex('a', adjacencyList);
		adjacencyList.add(new Vertex('b'));
		adjacencyList.add(new Vertex('c'));
	}
	
	@Test
	public void testConstructor() {
		assertEquals(vertex.getValue(), 'a');
	}
	
	@Test
	public void testAdjacencyList() {
		assertEquals(vertex.getAdjacencyList().get(0).getValue(), 'b');
		assertEquals(vertex.getAdjacencyList().get(1).getValue(), 'c');
		adjacencyList = new ArrayList<>();
		adjacencyList.add(new Vertex('z'));
		vertex.setAdjacencyList(adjacencyList);
		assertEquals(vertex.getAdjacencyList().get(0).getValue(), 'z');
	}
	
	@Test
	public void testColor() {
		assertEquals(vertex.getColor(), "white");
		vertex.setColor("black");
		assertEquals(vertex.getColor(), "black");
	}
	
	
}
