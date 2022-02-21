
import Class2.Practice17_2;

import java.util.*;
import java.lang.Math;

import Class2.Practice17_2.*;

class Test {


    public static void main(String[] args) {
        String temp = "";
        char[] array = temp.toCharArray();
        System.out.println(array.length);

    }

    public int kthSmallest(int[][] matrix, int k) {
        // Write your solution here
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
        }

        return minHeap.poll().val;
    }
}

