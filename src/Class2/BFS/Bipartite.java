/**
 * Laicde 56. Bipartite
 *
 * Determine if an undirected graph is bipartite. A bipartite graph is one in which the nodes can be divided into two groups such that no nodes have direct edges to other nodes in the same group.
 *
 * Examples
 *
 * 1  --   2
 *
 *     /
 *
 * 3  --   4
 *
 * is bipartite (1, 3 in group 1 and 2, 4 in group 2).
 *
 * 1  --   2
 *
 *     /   |
 *
 * 3  --   4
 *
 * is not bipartite.
 *
 * Assumptions
 *
 * The graph is represented by a list of nodes, and the list of nodes is not null.
 */

package Class2.BFS;

import java.util.*;

public class Bipartite {

    // Data Structure: FIFO queue
    // Initialize: enqueue 1, color 1 with u
    // For each step:
    // Expand: dequeue the first element (x) of the queue
    // Generate: enqueue all the neighbors (y) and color them with the other color
    //          case 1: y is not generated before
    //                  color y with the other color than x
    //          case 2: y is generated before
    //                  case 2.1 y's color is the same as x's color, CONFLICT!
    //                  case 2.2: y's color is different from x's color, ignore


    // TC: O(|V| + |E|)
    // SC: O(|V|)

    public boolean isBipartite(List<GraphNode> graph) {
        // use 0 and 1 to denote two different groups
        // the map maintains for each node which group it belongs to
        Map<GraphNode, Integer> visited = new HashMap<>();

        // the graph can be represented by a list of nodes (if it is not guaranteed
        // to be connected). we have to do BFS from each of the nodes
        for (GraphNode node : graph) {
            if (!BFS(node, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean BFS(GraphNode node, Map<GraphNode, Integer> visited) {
        // if the node has been traversed, no need to do BFS again
        if (visited.containsKey(node)) {
            return true;
        }

        // never visited, means this node was not connected with any of the visited nodes, a separated node/group
        Queue<GraphNode> queue = new ArrayDeque<>();
        queue.offer(node);
        visited.put(node, 0);

        while (!queue.isEmpty()) {
            GraphNode cur = queue.poll();
            int curGroup = visited.get(cur);
            int neiGroup = curGroup == 0 ? 1 : 0;

            for (GraphNode nei : cur.neighbors) {
                // case 1
                if (!visited.containsKey(nei)) {
                    visited.put(nei, neiGroup);
                    queue.offer(nei);
                } else if (visited.get(nei) != neiGroup) {
                    // case 2.1
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Bipartite obj = new Bipartite();

        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        //node2.neighbors.add(node4);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        //node4.neighbors.add(node2);
        node4.neighbors.add(node3);

        List<GraphNode> graph = new ArrayList<>();
        graph.add(node1);
        graph.add(node2);
        graph.add(node3);
        graph.add(node4);

        System.out.println(obj.isBipartite(graph));
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
