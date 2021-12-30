/*Q7
Given a target integer T and an integer array A sorted in ascending order, find the index of the smallest element in A that is larger than T or return -1 if there is no such index.

Assumptions
There can be duplicate elements in the array.


Examples
A = {1, 2, 3}, T = 1, return 1
A = {1, 2, 3}, T = 3, return -1
A = {1, 2, 2, 2, 3}, T = 1, return 1


Corner Cases
What if A is null or A of zero length? We should return -1 in this case.

 */

package Class2.BinarySearch;
public class SmallestLarge {

    public static int binarySearch(int[] array, int target) {
        if(array==null || array.length==0){
            return -1;
        }

        int left = 0;
        int right = array.length - 1;
        int mid;

        while (left < right - 1) {
            mid = (left + right) / 2;
            if (array[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (array[left] > target) {
            return left;
        } else if (array[right]>target) {
            return right;
        } else {
            return -1;
        }

    }

    public static void main(String[] args){
        int[] array = {2,2,2,3,4,4,4,5,5,5,5};
        int target = 4;
        int i = binarySearch(array, target);
        System.out.println(i);
    }
}
