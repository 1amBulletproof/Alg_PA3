/*
 * Represents a generic graph Node or Vertex
 * <p> Node may have variable direct links to other Vertex's</p>
 * <p> Node will have a char value</p>
 * <p> Node will have a color based on whether it has been visited in a depth-first-search:
 * <ul>
 * 		<li>white = not yet visited</li>
 * 		<li>grey = visited but not all adjacent nodes visited</li>
 * 		<li>black = visited and all adjacent nodes visited</li>
 * 
 * @author Brandon Tarney 4/30/2016
 * @version 1.0
 */

package com.tarney.graph;

import java.util.ArrayList;

public class Vertex {

	private char nodeValue;
	private ArrayList<Vertex> adjacenyList = new ArrayList<>();
	private String color;
	
	public Vertex (char nodeValue) {
		this.nodeValue = nodeValue;
		color = "white";
	}
	
	public Vertex (char nodeValue, ArrayList<Vertex> adjacencyList) {
		this.nodeValue = nodeValue;
		this.adjacenyList = adjacencyList;
		color = "white";
	}
	
	public char getValue() {
		return nodeValue;
	}
	
	public ArrayList<Vertex> getAdjacencyList() {
		return adjacenyList;
	}
	
	public void setColor(String newColor) {
		this.color = newColor;
	}
	
	public String getColor() {
		return this.color;
	}
	
	
}
