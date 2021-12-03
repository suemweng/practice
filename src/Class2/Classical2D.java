/*Q2
Given a 2D matrix that contains integers only, which each row is sorted in ascending order. The first element of next row is larger than (or equal to) the last element of previous row.

Given a target number, returning the position that the target locates within the matrix. If the target number does not exist in the matrix, return {-1, -1}.

Assumptions:

The given matrix is not null, and has size of N * M, where N >= 0 and M >= 0.

Examples:

matrix = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10} }

target = 7, return {1, 2}

target = 6, return {-1, -1} to represent the target number does not exist in the matrix.
 */
/*
import java.util.Arrays;


public class Classical2D {

  public static int[] ifFind(int[][] matrix, int target){
      if(matrix==null || matrix.length==0 || matrix[0].length==0){
          return new int[] {-1,-1};
      }

      int m = matrix.length;
      int n = matrix[0].length;
      int left = 0;
      int right = m*n-1;

      while (left <= right){
          int mid = (left + right)/2;
          int i = mid / n;
          int j = mid % n;
          if (matrix[i][j]== target){
              return new int[] {i,j};
          } else if (matrix[i][j]<target){
              left = mid + 1;
          } else {
              right = mid -1;
          }
      }
      return new int[] {-1,-1};
  }

  public static void main (String[] args){
      int[][] matrix ={{1,3,4,6,7},{8,9,10,11,14},{15,17,19,20,23}};
      int target = 8;

      int[] l = ifFind(matrix,target);
      System.out.println(Arrays.toString(l));
  }
}

// Time Complexity O(log(m*n))
// Space Complexity O(1)

*/

import java.util.Arrays;

public class Classical2D {

    public static int[] binarySearch ( int[][] arr, int target ) {
        if ( arr.length == 0 || arr[0].length == 0 ) {
            return new int[] { -1, -1 };
        }

        int n = arr.length;
        int m = arr[0].length;
        int left = 0;
        int right = n * m - 1;

        while ( left <= right) {
            int mid = ( left + right ) / 2;
            int row  = mid / m;
            int col = mid % m;
            if ( arr[row][col] == target ) {
                return new int[] { row, col };
            } else if ( arr[row][col]  < target ) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }

        return new int[] { -1, -1 };

    }

    public static void main (String[] argos) {
        int[][] array = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10} };
        int target = 6;
        int[] index = binarySearch(array, target);
        System.out.println ( Arrays.toString ( index ) );



    }

}
