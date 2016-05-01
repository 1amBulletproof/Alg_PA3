/*
 * Represents a generic graph Node or Vertex
 * <p> Node may have variable direct links to other Vertex's</p>
 * <p> Node will have a char 
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
	
	public void changeColor(String newColor) {
		this.color = newColor;
	}
	
	public String getColor() {
		return this.color;
	}
	
	
}
