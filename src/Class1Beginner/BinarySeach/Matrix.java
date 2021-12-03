package Class1Beginner.BinarySeach;
import java.util.Arrays;

public class Matrix {
    public static int[] findTarget(int[][] arr, int target) {
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return new int[]{-1,-1};
        }

        int row = arr.length;
        int col = arr[0].length;
        int left = 0;
        int right = row * col - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int m = mid / col;
            int n = mid % col;
            if (arr[m][n] == target) {
                return new int[]{m,n};
            } else if (arr[m][n] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[][] array = {{1,2,3},{4,5,7},{8,9,10}};
        int target = 10;
        int[] index = findTarget(array,target);
        System.out.println(Arrays.toString(index));

    }
}
