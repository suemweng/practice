/**
 * Laicode 26. Kth Smallest Number In Sorted Matrix
 *
 * Given a matrix of size N x M. For each row the elements are sorted in ascending order, and for each column the elements are also sorted in ascending order. Find the Kth smallest number in it.
 *
 * Assumptions
 *
 * the matrix is not null, N > 0 and M > 0
 * K > 0 and K <= N * M
 * Examples
 *
 * { {1,  3,   5,  7},
 *
 *   {2,  4,   8,   9},
 *
 *   {3,  5, 11, 15},
 *
 *   {6,  8, 13, 18} }
 *
 * the 5th smallest number is 4
 * the 8th smallest number is 6
 */

package Class2.BFS;

import java.util.PriorityQueue;
import java.util.Comparator;

public class KthSmallest {

    public int kthSmallest(int[][] matrix, int k) {

        class Cell{
            int row;
            int col;
            int val;

            public Cell(int row, int col, int val) {
                this.row = row;
                this.col = col;
                this.val = val;
            }
        }


        int rows = matrix.length;
        int cols = matrix[0].length;

        PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, new Comparator<Cell>(){
            @Override
            public int compare(Cell o1, Cell o2) {
                if (o1.val == o2.val) {
                    return 0;
                }
                return o1.val < o2.val ? -1 : 1;
            }
        });

        minHeap.offer(new Cell(0,0,matrix[0][0]));
        boolean[][] visited = new boolean[rows][cols];
        visited[0][0] = true;

        while (k > 1) {
            Cell cur = minHeap.poll();
            if (cur.row + 1 < rows && !visited[cur.row + 1][cur.col]) {
                minHeap.offer(new Cell(cur.row + 1, cur.col, matrix[cur.row + 1][cur.col]));
                visited[cur.row + 1][cur.col] = true;
            }

            if (cur.col + 1 < cols && !visited[cur.row][cur.col + 1]) {
                minHeap.offer(new Cell(cur.row, cur.col + 1, matrix[cur.row][cur.col + 1]));
                visited[cur.row][cur.col + 1] = true;
            }
            k--;
        }

        return minHeap.poll().val;
    }

    public static void main(String[] args) {
        KthSmallest obj = new KthSmallest();
        int[][] matrix = {{1,2,3,4},{11,12,13,14},{15,16,17,18},{19,20,21,22}};
        int k = 4;
        int smallest = obj.kthSmallest(matrix, k);
        System.out.println(smallest);
    }
}

// TC: O(klogk) -- heap.offer() logk
// SC: O(mn + k) -- visited[][] + heap