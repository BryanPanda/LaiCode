package deepCopyUndirectedGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Make a deep copy of an undirected graph, there could be cycles in the original graph.

public class DeepCopyUndirectedGraph {

	public List<GraphNode> copy(List<GraphNode> graph) {
		if (graph == null) {
			return null;
		}
		HashMap<GraphNode, GraphNode> map = new HashMap<>();
		for (GraphNode node : graph) {
			if (!map.containsKey(node)) {
				map.put(node, new GraphNode(node.key));
				dfs(node, map);
			}
		}
		return new ArrayList<GraphNode>(map.values());
	}

	private void dfs(GraphNode node, HashMap<GraphNode, GraphNode> map) {
		GraphNode copy = map.get(node);
		for (GraphNode neighbor : node.neighbors) {
			if (!map.containsKey(neighbor)) {
				map.put(neighbor, new GraphNode(neighbor.key));
				dfs(neighbor, map);
			}
			copy.neighbors.add(map.get(neighbor));
		}
	}

	// Time complexity is O(|V|+|E|),
	// Space complexity is O(|V|+|E|).
}
