package graph;

import java.util.Deque;
import java.util.LinkedList;

public class DepthFirstPaths {

	private boolean[] marked; // marked[v] = true, means there is a s-v path
	private int[] edgeTo;
	private final int s; // source vertex

	// constructor
	public DepthFirstPaths(Graph G, int s) {
		this.s = s;
		edgeTo = new int[G.V()];
		marked = new boolean[G.V()];
		dfs2(G, s);
	}

	// getter methods
	public boolean marked(int v) {
		return marked[v];
	}

	// one implementation of dfs from v, using recursion
	private void dfs1(Graph G, int v) {
		marked[v] = true;
		System.out.println(v);
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				edgeTo[w] = v;
				dfs1(G, w);
			}
		}
	}

	// another implementation of dfs from v, using stack
	private void dfs2(Graph G, int v) {
		Deque<Integer> stack = new LinkedList<Integer>();
		stack.offerFirst(v);
		marked[v] = true;
		System.out.println(v);
		while (!stack.isEmpty()) {
			int node = stack.pollFirst();
			if (!marked[node]) {
				marked[node] = true;
				System.out.println(node);
			}
			for (int w : G.adj(node)) {
				if (!marked[w]) {
					edgeTo[w] = node;
					stack.offerFirst(w);
				}
			}
		}
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}

	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Deque<Integer> path = new LinkedList<Integer>();
		for (int x = v; x != s; x = edgeTo[x]) {
			path.offerFirst(x);
		}
		path.offerFirst(s);
		return path;
	}

	public static void main(String[] args) {
		int V = 7;
		int[][] edges = new int[][] { { 0, 1 }, { 0, 2 }, { 0, 5 }, { 0, 6 }, { 3, 4 }, { 3, 5 }, { 4, 5 }, { 4, 6 } };
		Graph G = new Graph(V, edges); // a graph with 7 nodes
		int s = 0;
		DepthFirstPaths solution = new DepthFirstPaths(G, s);
		for (int v = 0; v < G.V(); v++) {
			if (!solution.hasPathTo(v)) {
				System.out.print(s + " and " + v + " are not connected.\n");
			} else {
				System.out.print(s + " - " + v + " path: ");
				for (int x : solution.pathTo(v)) {
					if (x == s) {
						System.out.print(x);
					} else {
						System.out.print(" - " + x);
					}
				}
				System.out.println();
			}
		}
	}

}
