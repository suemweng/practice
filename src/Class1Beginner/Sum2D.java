/*  543. Sum of 2D array

Given a two-dimensional array, calculate the sum of all its elements


Example:
array = {{ 2, 3}, {4, 5}, {1, 0}}
Return 15


Assumption: The 2D array is not null or empty. The 2D array is rectangular shape.

 */


public class Sum2D {

    public static int sum(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] arr = {{ 2, 3}, {4, 5}, {1, 0}};
        int sum = sum(arr);
        System.out.println(sum);


    }

}
