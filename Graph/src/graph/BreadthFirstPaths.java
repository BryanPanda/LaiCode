package graph;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstPaths {

	private boolean[] marked;
	private int[] edgeTo;
	private int[] distTo;

	// constructors
	public BreadthFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		distTo = new int[G.V()];
		for (int v = 0; v < G.V(); v++) {
			distTo[v] = Integer.MAX_VALUE;
		}
		bfs(G, s);
	}

	// getter methods
	public int distTo(int v) {
		return distTo[v];
	}

	// methods
	// bfs from a single source node s
	private void bfs(Graph G, int s) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(s);
		marked[s] = true;
		distTo[s] = 0;
		while (!queue.isEmpty()) {
			int v = queue.poll();
			System.out.println(v);
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					marked[w] = true;
					edgeTo[w] = v;
					distTo[w] = distTo[v] + 1;
					queue.offer(w);
				}
			}
		}
	}

	private boolean hasPathTo(int v) {
		return marked[v];
	}

	private Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v)) {
			return null;
		}
		Deque<Integer> stack = new LinkedList<Integer>();
		int x;
		for (x = v; distTo[x] != 0; x = edgeTo[x]) {
			stack.addFirst(x);
		}
		stack.addFirst(x);
		return stack;
	}

	public static void main(String[] args) {
		int V = 7;
		int[][] edges = new int[][] { { 0, 1 }, { 0, 2 }, { 0, 5 }, { 0, 6 }, { 3, 4 }, { 3, 5 }, { 4, 5 }, { 4, 6 } };
		Graph G = new Graph(V, edges); // a graph with 7 nodes
		int s = 0;
		BreadthFirstPaths solution = new BreadthFirstPaths(G, s);
		for (int v = 0; v < G.V(); v++) {
			if (solution.hasPathTo(v)) {
				System.out.print("Distance between " + s + " and " + v + " is " + solution.distTo(v) + ": ");
				for (int x : solution.pathTo(v)) {
					if (x == s) {
						System.out.print(x);
					} else {
						System.out.print(" - " + x);
					}
				}
				System.out.println();
			} else {
				System.out.println(s + " and " + v + " are not connected.\n");
			}
		}
	}

}
