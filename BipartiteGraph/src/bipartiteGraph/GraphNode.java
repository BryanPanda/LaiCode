package bipartiteGraph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {

	public int key;
	public List<GraphNode> neighbors;

	public GraphNode(int key) {
		this.key = key;
		neighbors = new ArrayList<>();
	}
}
