/* Q4
Given a target integer T and an integer array A sorted in ascending order, find the index of the first occurrence of T in A or return -1 if there is no such index.

Assumptions

There can be duplicate elements in the array.

Examples

A = {1, 2, 3}, T = 2, return 1
A = {1, 2, 3}, T = 4, return -1
A = {1, 2, 2, 2, 3}, T = 2, return 1

Corner Cases

What if A is null or A of zero length? We should return -1 in this case.

 */
package Class2.BinarySearch;
public class First {
    public static int binarySearch(int[] array, int target) {
        if(array==null || array.length==0){
            return -1;
        }

        int left = 0;
        int right = array.length - 1;
        int mid;

        while (left < right ) {
            mid = (left + right) / 2;
            if (array[mid] < target) {
                left = mid + 1;
            } else if (array[mid] == target){
                right = mid;
            } else {
                right = mid - 1;
            }
        }

        if (array[left] == target) {
            return left;
        } else {
            return -1;
        }
    }

    public static void main (String[] args){
        int[] array = {1,2};
        int target = 3;
        int i = binarySearch(array,target);
        System.out.println(i);
    }
}
