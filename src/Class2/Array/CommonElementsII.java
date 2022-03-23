/**
 * Laicode 171. Common Elements In Three Sorted Array
 *
 * Find all common elements in 3 sorted arrays.
 *
 * Assumptions
 *
 * The 3 given sorted arrays are not null
 * There could be duplicate elements in each of the arrays
 * Examples
 *
 * A = {1, 2, 2, 3}, B = {2, 2, 3, 5}, C = {2, 2, 4}, the common elements are [2, 2]
 */

package Class2.Array;

import java.util.ArrayList;
import java.util.List;

public class CommonElementsII {

    public List<Integer> common(int[] a, int[] b, int[] c) {

        // Key insight: three pointers

        // TC: O(min(a, b, c))
        // SC: O(1)

        List<Integer> result = new ArrayList<>();

        if (a.length == 0 || b.length == 0 || c.length == 0) {
            return result;
        }

        int ai = 0;
        int bi = 0;
        int ci = 0;

        while (ai < a.length && bi < b.length && ci < c.length) {
            if (a[ai] == b[bi] && b[bi] == c[ci]) {
                result.add(a[ai]);
                ai++;
                bi++;
                ci++;
            } else if (a[ai] <= b[bi] && a[ai] <= c[ci]) {
                ai++;
            } else if (b[bi] <= a[ai] && b[bi] <= c[ci]) {
                bi++;
            } else {
                ci++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CommonElementsII obj = new CommonElementsII();

        int[] a = {1,2,2,3};
        int[] b = {2,2,3,5};
        int[] c = {2,2,4};

        System.out.println(obj.common(a,b,c));

    }
}
