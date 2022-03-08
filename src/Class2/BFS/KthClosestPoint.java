package Class2.BFS;

import java.util.*;

public class KthClosestPoint {

    class Element{
        int x;
        int y;
        int z;
        int dist;

        public Element(int x, int y, int z, int dist) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.dist = dist;
        }
    }

    public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
        // Write your solution here

        // set up PQ minHeap
        PriorityQueue<Element> minHeap = new PriorityQueue<>(new Comparator<Element>() {
            @Override
            public int compare(Element e1, Element e2) {
                return Integer.compare(e1.dist, e2.dist);
            }
        });
        minHeap.offer(new Element(0, 0, 0, dist(0, 0, 0, a, b, c)));
        Set<String> visited = new HashSet<>();
        visited.add("000");
        List<Integer> result = new ArrayList<>();

        while (!minHeap.isEmpty()) {
            Element cur = minHeap.poll();
            k--;
            if (k == 0) {
                result.add(a[cur.x]);
                result.add(b[cur.y]);
                result.add(c[cur.z]);
                return result;
            }
            if (cur.x + 1 < a.length && visited.add("" + (cur.x + 1) + cur.y + cur.z)) {
                minHeap.offer(new Element(cur.x + 1, cur.y, cur.z, dist(cur.x + 1, cur.y, cur.z, a, b, c)));
            }
            if (cur.y + 1 < b.length && visited.add("" + cur.x + (cur.y + 1) + cur.z)) {
                minHeap.offer(new Element(cur.x, cur.y + 1, cur.z, dist(cur.x, cur.y + 1, cur.z, a, b, c)));
            }
            if (cur.z + 1 < c.length && visited.add("" + cur.x + cur.y + (cur.z + 1))) {
                minHeap.offer(new Element(cur.x, cur.y, cur.z + 1, dist(cur.x, cur.y, cur.z + 1, a, b, c)));
            }

        }
        return result;
    }

    private int dist(int x, int y, int z, int[] a, int[] b, int[] c) {
        return a[x] * a[x] + b[y] * b[y] + c[z] * c[z];
    }

    public static void main(String[] args) {
        KthClosestPoint obj = new KthClosestPoint();

        int[] a = {1,2,3};
        int[] b = {2,4};
        int[] c = {1,2};
        int k = 10;
        System.out.println(obj.closest(a, b, c, k));
    }
}
