package com.search;

import java.util.LinkedList;
import java.util.Queue;

// BFS is Breath First Search
public class BFS {

	public static void main(String[] args) {
		// Number of vertices in the graph
		int vertices = 5;

		// Create a graph
		Graph graph = new Graph(vertices);

		// Add edges to the graph
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 4);

		// Perform BFS traversal starting from vertex 0
		System.out.print("Breadth First Traversal starting from vertex 0: ");
		graph.bfs(0);
	}
}

//Class to represent a graph using adjacency list
class Graph {
	int vertices;
	LinkedList<Integer>[] adjList;

	@SuppressWarnings("unchecked")
	Graph(int vertices) {
		this.vertices = vertices;
		adjList = new LinkedList[vertices];
		for (int i = 0; i < vertices; ++i)
			adjList[i] = new LinkedList<>();
	}

	// Function to add an edge to the graph
	void addEdge(int u, int v) {
		adjList[u].add(v);
	}

	// Function to perform Breadth First Search on a graph
	// represented using adjacency list
	void bfs(int startNode) {
		
		// Create a queue to store edges
		Queue<Integer> queue = new LinkedList<>();
		// visited nodes
		boolean[] visited = new boolean[this.vertices];
		
		queue.add(startNode);
		visited[startNode] = true;
		
		while( !queue.isEmpty() ) {
			
			// Dequeue a vertex from queue and print it
			Integer vertex = queue.poll();
			System.out.print(vertex + " ");
			
			for( int edge : this.adjList[vertex] ) {
				
				// if it is false then it is not yet visited
				if(visited[edge] == false) {
					queue.add(edge);
					visited[edge] = true;
				}
			}
		}
	
	}
}
