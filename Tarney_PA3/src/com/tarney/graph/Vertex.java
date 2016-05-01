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
import java.util.Stack;

public class Vertex {

	private char nodeValue;
	private ArrayList<Vertex> adjacenyList = new ArrayList<>();
	private String color;
	private Stack<Vertex> parents = new Stack<>();
	
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
	
	public void addParent(Vertex parent) {
		this.parents.add(parent);
	}
	
	/*
	 * This node may be added to a stack multiple times because of several in-edges: each time we will track its parent
	 * or the vertex from which this edge comes so we can later classify each edge
	 */
	public Vertex getLastParent() {
		return parents.pop();
	}

	//delete any existing parents
	public void newParents() {
		this.parents = new Stack<>();
	}


	
	public void setAdjacencyList(ArrayList<Vertex> adjList) {
		this.adjacenyList = adjList;
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
