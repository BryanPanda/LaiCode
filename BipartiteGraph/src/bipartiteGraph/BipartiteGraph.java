package bipartiteGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// Determine if an undirected graph is bipartite. A bipartite graph is one in which
// the nodes can be divided into two groups such that no nodes have direct edges to
// other nodes in the same group.

public class BipartiteGraph {

	public boolean isBipartite(List<GraphNode> graph) {
		Map<GraphNode, Integer> visited = new HashMap<>();
		for (GraphNode node : graph) {
			if (!helper(node, visited)) {
				return false;
			}
		}
		return true;
	}

	// return true, if node has been visited, or node has not been visited,
	// but all its neighbors are in a different group
	public boolean helper(GraphNode node, Map<GraphNode, Integer> visited) {
		if (visited.containsKey(node)) {
			return true;
		}
		LinkedList<GraphNode> queue = new LinkedList<>();
		queue.offerLast(node);
		visited.put(node, 0);
		while (!queue.isEmpty()) {
			GraphNode cur = queue.pollFirst();
			for (GraphNode neighbor : cur.neighbors) {
				if (!visited.containsKey(neighbor)) {
					queue.offerLast(neighbor);
					visited.put(neighbor, 1 - visited.get(cur));
				} else {
					if (visited.get(neighbor) != 1 - visited.get(cur)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	// Time complexity is O(n+m).
	// Space complexity is O(n).

}
