/* Q6
Given a target integer T, a non-negative integer K and an integer array A sorted in ascending order, find the K closest numbers to T in A. If there is a tie, the smaller elements are always preferred.

Assumptions

A is not null
K is guaranteed to be >= 0 and K is guaranteed to be <= A.length
Return

A size K integer array containing the K closest numbers(not indices) in A, sorted in ascending order by the difference between the number and T.

Examples

A = {1, 2, 3}, T = 2, K = 3, return {2, 1, 3} or {2, 3, 1}
A = {1, 4, 6, 8}, T = 3, K = 3, return {4, 1, 6}
 */
package Class2.BinarySearch;
import java.util.Arrays;


public class ClosestK {
    public static int[] binarySearch(int[] array, int target, int k){
        if(array==null || array.length==0){
            return array;
        }
        if (k==0){
            return new int[0];
        }


        int left = 0;
        int right = array.length-1;
        int mid;
        int[] list = new int[k];

        while(left < right -1){
            mid = (left + right)/2;
            if(array[mid]<=target){
                left = mid;
            } else {
                right = mid;
            }
        }

        for ( int i=0; i<k;i++ ){
             if( right>array.length-1 || left>=0 && target - array[left] <= array[right] - target){
                    list[i]=array[left];
                    left--;
                }else{
                 list[i]=array[right];
                 right++;
             }
        }
        return list;
    }

    public static void main (String[] args){
        int[] array = {1,3,5};
        int target = 10;
        int k = 3;
        int[] list = binarySearch(array,target,k);
        System.out.println(Arrays.toString(list));

    }
}



