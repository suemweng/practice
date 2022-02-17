/**
 * Laicode 87. Max Product Of Cutting Rope
 *
 * Given a rope with positive integer-length n, how to cut the rope into m integer-length parts with length p[0], p[1], ...,p[m-1], in order to get the maximal product of p[0]*p[1]* ... *p[m-1]? m is determined by you and must be greater than 0 (at least one cut must be made). Return the max product you can have.
 *
 * Assumptions
 *
 * n >= 2
 * Examples
 *
 * n = 12, the max product is 3 * 3 * 3 * 3 = 81(cut the rope into 4 pieces with length of each is 3).
 */

package Class2.DP;

public class MaxProductOfCuttingRope {

    public int maxProduct(int length) {


        int[] maxPro = new int[length + 1];
        maxPro[1] = 0;

        // maxPro[i] = max(max(j, maxPro[j]) * (i - j))  where 1 <= j < i
        for (int i = 2; i <= length; i++) {
            for (int j = 1; j <= i - 1; j++) {
                maxPro[i] = Math.max(maxPro[i], Math.max(j, maxPro[j]) * (i - j));
            }
        }

        return maxPro[length];
    }

    public static void main(String[] args) {
        MaxProductOfCuttingRope obj = new MaxProductOfCuttingRope();

        int length = 12;
        System.out.println(obj.maxProduct(length));
    }

}

// TC: O(n ^ 2)
// SC: O(n)