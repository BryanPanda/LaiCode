package graph;

import java.util.LinkedList;

public class Graph {

	private int V; // number of vertices
	private int E; // number of edges
	private LinkedList<Integer>[] neighbors; // adjacency list representation

	// constructor
	public Graph(int V, int[][] edges) {
		if (V < 0)
			throw new IllegalArgumentException("Number of Vertices must be Non-negative.");
		this.V = V;
		this.E = 0;
		this.neighbors = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			neighbors[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < edges.length; i++) {
			int v = edges[i][0];
			int w = edges[i][1];
			addEdge(v, w);
		}
	}

	// getter methods
	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	private void validateVertex(int v) {
		if (v < 0 || v >= V) {
			throw new IndexOutOfBoundsException("Vertex " + v + "is not between 0 and " + (V - 1));
		}
	}

	public void addEdge(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		E++;
		neighbors[v].add(w);
		neighbors[w].add(v);
	}

	public Iterable<Integer> adj(int v) {
		validateVertex(v);
		return neighbors[v];
	}

	public int degree(int v) {
		validateVertex(v);
		return neighbors[v].size();
	}
}
