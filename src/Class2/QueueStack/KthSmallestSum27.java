package Class2.QueueStack;

import java.util.*;

public class KthSmallestSum27 {

    class Cell {
        int row;
        int col;
        int sum;

        public Cell(int row, int col, int sum) {
            this.row = row;
            this.col = col;
            this.sum = sum;
        }
    }

    public int kthSum(int[] A, int[] B, int k) {
        // Write your solution here

        PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, new Comparator<Cell>() {
            @Override
            public int compare(Cell c1, Cell c2) {
                if (c1.sum == c2.sum) {
                    return 0;
                }
                return c1.sum <= c2.sum ? -1 : 1;
            }
        });
        boolean[][] visited = new boolean[A.length][B.length];
        minHeap.offer(new Cell(0, 0, A[0] + B[0]));
        visited[0][0] = true;

        while (k > 1) {
            Cell cur = minHeap.poll();
            k--;
            if (cur.row + 1 < A.length && !visited[cur.row + 1][cur.col]) {
                minHeap.offer(new Cell(cur.row + 1, cur.col, A[cur.row + 1] + B[cur.col]));
                visited[cur.row + 1][cur.col] = true;
            }

            if (cur.col + 1 < B.length && !visited[cur.row][cur.col + 1]) {
                minHeap.offer(new Cell(cur.row, cur.col + 1, A[cur.row] + B[cur.col + 1]));
                visited[cur.row][cur.col + 1] = true;
            }
        }
        return minHeap.poll().sum;
    }

    public static void main(String[] args) {
        KthSmallestSum27 solution = new KthSmallestSum27();

        int[] one = {1,3,5};
        int[] two = {4,8};
        int k = 4;
        int result = solution.kthSum(one, two, k);
        System.out.println(result);

    }
}
