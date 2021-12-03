/*Q1 x2
Given a target integer T and an integer array A sorted in ascending order, find the index i such that A[i] == T or return -1 if there is no such index.

Assumptions

There can be duplicate elements in the array, and you can return any of the indices i such that A[i] == T.

Examples

A = {1, 2, 3, 4, 5}, T = 3, return 2
A = {1, 2, 3, 4, 5}, T = 6, return -1
A = {1, 2, 2, 2, 3, 4}, T = 2, return 1 or 2 or 3

Corner Cases

What if A is null or A is of zero length? We should return -1 in this case.
 */

/*
public class Classical {

    public static int binarySearch(int[] array,int target){
        if(array==null || array.length==0){
            return -1;
        }

        int left = 0;
        int right = array.length-1;
        int mid;

        while (left <=right){
            mid = (left + right)/2;
            if(array[mid]==target){
                return mid;
            }else if (array[mid]<target){
                left = mid +1;
            } else {
                right = mid -1;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        int[] a = {1,5};
        int target = 5;
        int mid = binarySearch(a,target);
        System.out.println(mid);
    }
}

*/

public class Classical {

    public static int binarySearch ( int[] arr, int target) {

        if ( arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;
        int mid;

        while ( left <= right) {
            mid = left + (right - left) / 2;
            if ( arr[mid] == target) {
                return mid;
            } else if ( arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main (String[] args){

        int[] array = {1,2,2,2,3,4};
        int target = 2;
        int index = binarySearch ( array, target);
        System.out.println ( index );


    }
}
