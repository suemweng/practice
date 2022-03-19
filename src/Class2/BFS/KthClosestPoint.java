/**
 * Laicode 194. Kth Closest Point To <0,0,0>
 *
 * Given three arrays sorted in ascending order. Pull one number from each array to form a coordinate <x,y,z> in a 3D space. Find the coordinates of the points that is k-th closest to <0,0,0>.
 *
 * We are using euclidean distance here.
 *
 * Assumptions
 *
 * The three given arrays are not null or empty, containing only non-negative numbers
 * K >= 1 and K <= a.length * b.length * c.length
 * Return
 *
 * a size 3 integer list, the first element should be from the first array, the second element should be from the second array and the third should be from the third array
 * Examples
 *
 * A = {1, 3, 5}, B = {2, 4}, C = {3, 6}
 * The closest is <1, 2, 3>, distance is sqrt(1 + 4 + 9)
 * The 2nd closest is <3, 2, 3>, distance is sqrt(9 + 4 + 9)
 */

package Class2.BFS;

import java.util.*;

public class KthClosestPoint {

    // Key insight:
    // create a class for each point

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
