/* Q5
Given a target integer T and an integer array A sorted in ascending order, find the index of the last occurrence of T in A or return -1 if there is no such index.

Assumptions

There can be duplicate elements in the array.

Examples

A = {1, 2, 3}, T = 2, return 1
A = {1, 2, 3}, T = 4, return -1
A = {1, 2, 2, 2, 3}, T = 2, return 3

Corner Cases

What if A is null or A is array of zero length? We should return -1 in this case.

 */

public class Last {
    public static int binarySearch(int[] array, int target){
        if(array==null || array.length==0){
            return -1;
        }

        int left=0;
        int right= array.length-1;
        int mid;

        while (left < right-1){
            mid = (left + right)/2;
            if (array[mid]>target){
                right = mid -1;
            } else{
                left = mid;
            }
        }

        //Post Processing
        if (array[right]==target){
            return right;
         } else if (array[left]==target){
            return left;
         } else {
            return -1;
        }
        }


    public static void main(String[] args){
        int[] array = {1,2,2,4,4,5,5,5};
        int target = 4;
        int i = binarySearch(array,target);
        System.out.println(i);
    }
}
