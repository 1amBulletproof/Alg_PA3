/*
 * Main method which runs DFS using a stack and printing the edges
 * 
 * @author Brandon Tarney 4/28/2016
 * @version 1.0
 */

package com.tarney.main;

import java.util.ArrayList;

import static com.tarney.depthFirstSearch.DepthFirstSearchAlgorithm.*;

import com.tarney.graph.Vertex;

public class MainStackDFS {

	public static void main(String[] args) {
		
		ArrayList<Vertex> graph = initializeGraph();
		
		printGraph(graph);
		
		System.out.println("\n---Graph Depth First Search---\n");
		
		depthFirstSearch(graph);
		
	}

	//Print the nodes and connections of a graph to console
	private static void printGraph(ArrayList<Vertex> graph) {
		System.out.print("---GRAPH PRINT START---");
		for (Vertex vertex: graph) {
			System.out.println("\n\n" + vertex.getValue());
			System.out.print("Adjacent nodes: ");
			for (Vertex v: vertex.getAdjacencyList()) {
				System.out.print(v.getValue() + " ");
			}
		}
		System.out.println("\n\n---GRAPH PRINT END---\n\n");
	}
	
	/*
	 * hard-coded implementation/creation of a graph
	 * <p> The default implementation below creates a graph similar to 
	 * the graph on page 605 of the textbook CLRS Algorithms</p>
	 * 
	 * @return		ArrayList of vertexes (essentially a graph)
	 */
	public static ArrayList<Vertex> initializeGraph() {
		Vertex uVertex = new Vertex('u');
		Vertex vVertex = new Vertex('v');
		Vertex wVertex = new Vertex('w');
		Vertex xVertex = new Vertex('x');
		Vertex yVertex = new Vertex('y');
		Vertex zVertex = new Vertex('z');
		
		Vertex[] uAdjacencyList = {xVertex, vVertex};
		uVertex.setAdjacencyList(createArrayList( uAdjacencyList ));
		
		Vertex[] vAdjacencyList = {yVertex};
		vVertex.setAdjacencyList(createArrayList( vAdjacencyList ));
		
		Vertex[] wAdjacencyList = {zVertex, yVertex};
		wVertex.setAdjacencyList(createArrayList( wAdjacencyList ));
		
		Vertex[] xAdjacencyList = {vVertex};
		xVertex.setAdjacencyList(createArrayList( xAdjacencyList ));
		
		Vertex[] yAdjacencyList = {xVertex};
		yVertex.setAdjacencyList(createArrayList( yAdjacencyList ));
		
		Vertex[] zAdjacencyList = {zVertex};
		zVertex.setAdjacencyList(createArrayList( zAdjacencyList ));

		Vertex[] graph = { uVertex, vVertex, wVertex, xVertex, yVertex, zVertex};
		return createArrayList( graph );

	}
	
	/*
	 * Create an ArrayList of Vertexes an array of Vertexes
	 * 
	 * @param	adjacentVertexes	array of vertexes
	 * @return	an ArrayList of  vertexes (adjacency list essentially)
	 */
	public static ArrayList<Vertex> createArrayList(Vertex[] adjacentVertexes) {
		ArrayList<Vertex> vertexesList = new ArrayList<>();
		for (int counter = 0; counter < adjacentVertexes.length; counter ++ ) {
			vertexesList.add(adjacentVertexes[counter]);
		}
		return vertexesList;
	}

}
