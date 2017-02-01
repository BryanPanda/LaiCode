package graph;

import java.util.Deque;
import java.util.LinkedList;

public class DepthFirstSearch {
	private boolean[] marked; // marked[v] = true, means there is a s-v path
	private int count; // number of vertices that are connected to s

	// constructor
	public DepthFirstSearch(Graph G, int s) {
		marked = new boolean[G.V()];
		dfs1(G, s);
	}

	// getter methods
	public boolean marked(int v) {
		return marked[v];
	}

	public int count(int v) {
		return count;
	}

	// one implementation of dfs from v, using recursion
	private void dfs1(Graph G, int v) {
		count++;
		marked[v] = true;
		System.out.println(v);
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs1(G, w);
			}
		}
	}

	// another implementation of dfs from v, using stack
	private void dfs2(Graph G, int v) {
		Deque<Integer> stack = new LinkedList<Integer>();
		stack.offerFirst(v);
		count++;
		marked[v] = true;
		System.out.println(v);
		while (!stack.isEmpty()) {
			int node = stack.pollFirst();
			if (!marked[node]) {
				count++;
				marked[node] = true;
				System.out.println(node);
			}
			for (int w : G.adj(node)) {
				if (!marked[w]) {
					stack.offerFirst(w);
				}
			}
		}
	}

	public static void main(String[] args) {
		int V = 7;
		int[][] edges = new int[][] { { 0, 1 }, { 0, 2 }, { 0, 5 }, { 0, 6 }, { 3, 4 }, { 3, 5 }, { 4, 5 }, { 4, 6 } };
		Graph G = new Graph(V, edges); // a graph with 7 nodes
		int s = 0;
		DepthFirstSearch solution = new DepthFirstSearch(G, s);
		System.out.println("Number of nodes that are connected with node " + s + " is " + solution.count(s) + ".");
	}

}
