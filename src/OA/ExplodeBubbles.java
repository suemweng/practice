package OA;

import java.util.Arrays;

public class ExplodeBubbles {

    public int[][] solution(int[][] bubbles) {

        int rows = bubbles.length;
        int cols = bubbles[0].length;
        int[][] result = new int[rows][cols];
        for (int[] row : result) {
            Arrays.fill(row, -1);
        }


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                explode(bubbles, result, i, j);
                if (result[i][j] == -1) {
                    result[i][j] = bubbles[i][j];
                }
            }
        }

        for (int j = 0; j < result[0].length; j++) {
            sort(result, j);
        }

        return result;
    }

    private void explode(int[][] bubbles, int[][] result, int row, int col) {
        int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0,1}};
        int count = 0;
        for (int i = 0; i < direction.length; i++) {
            int row2 = row + direction[i][0];
            int col2 = col + direction[i][1];
            if (row2 >= 0 && row2 < bubbles.length && col2 >= 0 && col2 < bubbles[0].length) {
                if (bubbles[row][col] == bubbles[row2][col2]) {
                    count++;
                }
            }
        }

        if (count >= 2) {
            result[row][col] = 0;
            for (int i = 0; i < direction.length; i++) {
                int row2 = row + direction[i][0];
                int col2 = col + direction[i][1];
                if (row2 >= 0 && row2 < bubbles.length && col2 >= 0 && col2 < bubbles[0].length) {
                    if (bubbles[row][col] == bubbles[row2][col2]) {
                        result[row2][col2] = 0;;
                    }
                }
            }
        }
    }

    private void sort(int[][] array, int col) {
        int slow = array.length - 1;

        while (slow >= 0) {
            if (array[slow][col] != 0) {
                slow--;
                continue;
            }
            int fast = slow - 1;
            while (fast >= 0 && array[fast][col] == 0) {
                fast--;
            }

            if (fast >= 0) {
                swap(array, slow, fast, col);
                slow--;
            } else {
                return;
            }
        }
    }

    private void swap(int[][] array, int i, int j, int col) {
        int temp = array[i][col];
        array[i][col] = array[j][col];
        array[j][col] = temp;
    }

    public static void main(String[] args) {
        ExplodeBubbles obj = new ExplodeBubbles();

        int[][] bubbles = {{3,1,2,1},{1,1,1,4},{3,1,2,2},{3,3,3,4}};
        int[][] result = obj.solution(bubbles);
        for(int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
