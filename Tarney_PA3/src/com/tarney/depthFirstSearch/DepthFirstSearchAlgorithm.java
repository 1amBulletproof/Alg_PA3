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
	 * performs depth first search using a stack
	 * 
	 * @param	graph	ArrayList of vertexes: essentially a graph
	 * @return			returns the time the method took
	 */
	public static long depthFirstSearch(ArrayList<Vertex> graph) {
		long start = System.nanoTime();
		Stack<Vertex> stack = new Stack<>();
		
		for (Vertex vertex: graph) {
			vertex.setColor("white"); //no vertex has been visited yet
		}
		
		for ( Vertex vertex: graph) {
			if (vertex.getColor().equals("white")) {
				stack = depthFirstSearchVisit(graph, vertex, stack);
				while (!stack.empty()) {
					vertex = stack.pop();
					stack = depthFirstSearchVisit(graph, vertex, stack);
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
	 * @param	graph	ArrayList of vertexes: essentially a graph
	 * @param	vertex	vertex in graph which you wish to visit
	 * @param	stack	stack of vertexes yet to be visited
	 * @return			altered version of the input stack: there may be more vertexes added
	 */
	public static Stack<Vertex> depthFirstSearchVisit(ArrayList<Vertex> graph, Vertex vertex, Stack<Vertex> stackInput) {
		Stack<Vertex> stack = stackInput;
		vertex.setColor("grey"); //the vertex has been visited
		for (Vertex node: vertex.getAdjacencyList()) {
			if (node.getColor().equals("white")) { //has the node been visited?
				System.out.println(displayEdge(vertex, node) + " is a tree edge");
				stack.push(node); //node hasn't been visited, add it to the stack
			}
			else if (node.getColor().equals("grey")) { 
				System.out.println(displayEdge(vertex, node) + " is a back edge");
				
			}
			else {
				System.out.println(displayEdge(vertex, node) + " Ether a forward edge or a cross edge");
			}
		}
		vertex.setColor("black"); //node has been visited as has all its adjacent nodes
		return stack;
	}
	
	private static String displayEdge(Vertex origin, Vertex destination) {
		return "Edge = " + origin.getValue() + " --> " + destination.getValue();
	}
}
