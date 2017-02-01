package deepCopyUndirectedGraph;

import java.util.ArrayList;
import java.util.List;

// Make a deep copy of an undirected graph, there could be cycles in the original graph.

public class GraphNode {

	public int key;
	public List<GraphNode> neighbors;

	public GraphNode(int key) {
		this.key = key;
		this.neighbors = new ArrayList<GraphNode>();
	}

}
