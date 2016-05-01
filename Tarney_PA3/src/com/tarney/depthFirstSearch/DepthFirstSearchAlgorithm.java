/*
 * Various Depth First Search Methods
 * 
 * @author Brandon Tarney 4/28/2016
 * @version 1.0
 */

package com.tarney.depthFirstSearch;

import java.util.ArrayList;
import java.util.Stack;

import com.tarney.graph.Vertex;

public class DepthFirstSearchAlgorithm {

	/*
	 * performs depth first search using a stack, starting from the first vertex in the graph ArrayList
	 * 
	 * @param	graph	ArrayList of vertexes: essentially a graph
	 * @return			returns the time the method took
	 */
	public static long depthFirstSearch(ArrayList<Vertex> graph) {
		
		long start = System.nanoTime();
		Stack<Vertex> stack = new Stack<>();
		
		for (Vertex vertex: graph) {
			vertex.setColor("white");
			vertex.newParents();
		}
		
		Vertex childVertex;
		
		for ( Vertex vertex: graph) {
			
			if (vertex.getColor().equals("white")) {
				System.out.println("visiting: " + vertex.getValue());
				stack = depthFirstSearchVisit( vertex, stack);
				
				while (!stack.empty()) {
					childVertex = stack.pop();
					
					if (childVertex.getColor().equals("white")) {
						System.out.println(displayEdge(childVertex.getLastParent(), childVertex) + " is a tree edge");
						System.out.println("visiting: " + childVertex.getValue());
						stack = depthFirstSearchVisit( childVertex, stack);
					} 
					else if (childVertex.getColor().equals("black")) {
						System.out.println(displayEdge(childVertex.getLastParent(), childVertex) + " Ether a forward edge or a cross edge");
					}

				}
			}
		}
		
		long stop = System.nanoTime();
		long totalTime = stop-start;
		return totalTime;
	}

	/*
	 * Visits a vertex in a graph while performing DFS
	 * 
	 * <p> a white node hasn't been visisted, a grey node has been visited but not all of its adjacent nodes have been visited 
	 * and a black node has been visisted and all of its adjacent nodes has been visisted.
	 * 
	 * @param	graph	ArrayList of vertexes: essentially a graph
	 * @param	vertex	vertex in graph which you wish to visit
	 * @param	stack	stack of vertexes yet to be visited
	 * @return			altered version of the input stack: there may be more vertexes added
	 */
	public static Stack<Vertex> depthFirstSearchVisit(Vertex vertex, Stack<Vertex> stackInput) {
		Stack<Vertex> stack = stackInput;
		vertex.setColor("grey"); 
		for (Vertex node: vertex.getAdjacencyList()) {
			if (node.getColor().equals("white")) { 
				node.addParent(vertex);
				stack.push(node); 
			}
			else if (node.getColor().equals("grey")) { 
				node.addParent(vertex);
				System.out.println(displayEdge(node.getLastParent(), node) + " is a back edge");	
			}
			else {
				node.addParent(vertex);
				System.out.println(displayEdge(node.getLastParent(), node) + " Ether a forward edge or a cross edge");
			}
		}
		vertex.setColor("black");
		return stack;
	}
	
	private static String displayEdge(Vertex origin, Vertex destination) {
		return "Edge = " + origin.getValue() + " --> " + destination.getValue();
	}
}
