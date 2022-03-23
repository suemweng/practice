/**
 * Laicode 132. Deep Copy Undirected Graph
 *
 * Make a deep copy of an undirected graph, there could be cycles in the original graph.
 *
 * Assumptions
 *
 * The given graph is not null
 */

package Class2.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeepCopyUGraph {

    // TC: O(|E| + |V|)
    // SC: O(|E| + |V|)

    public List<GraphNode> copy(List<GraphNode> graph) {

        if (graph == null) {
            return null;
        }

        Map<GraphNode, GraphNode> map = new HashMap<>();

        for (GraphNode node : graph) {
            if (!map.containsKey(node)) {
                map.put(node, new GraphNode(node.key));
            }
            dfs(node, map);
        }
        return new ArrayList<GraphNode>(map.values());
    }

    private void dfs(GraphNode seed, Map<GraphNode, GraphNode> map) {
        GraphNode copy = map.get(seed);
        for (GraphNode nei : seed.neighbors) {
            if (!map.containsKey(nei)) {
                map.put(nei, new GraphNode(nei.key));
                dfs(nei, map);
            }
            copy.neighbors.add(map.get(nei));
        }
    }

    class GraphNode {
       public int key;
       public List<GraphNode> neighbors;
       public GraphNode(int key) {
         this.key = key;
         this.neighbors = new ArrayList<GraphNode>();
       }
     }
}
