package Class2.BFS;

import java.util.*;

public class CourseScheduleII {

    // Method 2: DFS -- hasCycle

    public int[] findOrderII(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int prereq = prerequisites[i][1];
            int course = prerequisites[i][0];
            graph.get(prereq).add(course);
        }

        int[] visited = new int[numCourses];
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, graph,visited, ans)) {
                return new int[0];
            }
        }

        int n = ans.size();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    private boolean hasCycle(int curr, List<List<Integer>> graph, int[] visited, List<Integer> ans) {
        if (visited[curr] == 1) { // there is a cycle
            return true;
        }

        if (visited[curr] == 2) { // there is no cycle
            return false;
        }

        visited[curr] = 1;
        for (int next : graph.get(curr)) {
            if (hasCycle(next, graph, visited, ans)) { // there is a cycle
                return true;
            }
        }

        visited[curr] = 2;
        ans.add(0, curr);
        return false;      // there is no cycle
    }

    // Method 2: DFS

    public int[] findOrderIII(int numCourses, int[][] prerequisites) {
        // Write your solution here
        // build map to store prerequisites
        List<List<Integer>> graph = buildGraph(prerequisites);

        // finished[] to record taken courses, index is the course #
        boolean[] finished = new boolean[numCourses];
        int[] result = new int[numCourses];
        return dfs(0, result, finished, graph) ? result : new int[0];
    }

    private boolean dfs(int index, int[] result, boolean[] finished, List<List<Integer>> graph) {
        // base case
        if (index == result.length) {
            return true;
        }

        // branches
        for (int i = 0; i < result.length; i++) {
            // skip taken courses
            if (finished[i]) {
                continue;
            }

            // use qualify() to check if all prerequisites of course i have been taken
            if (qualify(i, graph, finished)) {
                finished[i] = true;
                result[index] = i;
                if (dfs(index + 1, result, finished, graph)) {
                    return true;
                }
                finished[i] = false;
            }
        }
        return false;
    }

    private List<List<Integer>> buildGraph(int[][] prereq) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < prereq.length; i++) {
            graph.add(i, new ArrayList<>());
        }
        // List<Integer> contains all prerequisites of course i
        for (int i = 0; i < prereq.length; i++) {
              graph.get(prereq[i][0]).add(prereq[i][1]);
        }
        return graph;
    }

    private boolean qualify(int num, List<List<Integer>> graph, boolean[] finished) {
        for (Integer course : graph.get(num)) {
            if (!finished[course]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CourseScheduleII obj = new CourseScheduleII();

        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        int numCourses = 4;
        int[] result = obj.findOrderIII(numCourses,prerequisites);
        System.out.println(Arrays.toString(result));
    }
}
