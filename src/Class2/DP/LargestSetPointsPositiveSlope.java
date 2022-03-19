/**
 * Laicode 217. Largest Set Of Points With Positive Slope
 *
 * Given an array of 2D coordinates of points (all the coordinates are integers), find the largest number of points that can form a set such that any pair of points in the set can form a line with positive slope. Return the size of such a maximal set.
 *
 * Assumptions
 *
 * The given array is not null
 * Note: if there does not even exist 2 points can form a line with positive slope, should return 0.
 * Examples
 *
 * <0, 0>, <1, 1>, <2, 3>, <3, 3>, the maximum set of points are {<0, 0>, <1, 1>, <2, 3>}, the size is 3.
 */

package Class2.DP;

import java.util.Arrays;
import java.util.Comparator;

public class LargestSetPointsPositiveSlope {

    public int largest(Point[] points) {
        // Key insight
        // sort x, and find LAS in y

        // TC: O(n ^ 2)
        // SC: O(n)
        
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                return Integer.compare(p1.x, p2.x);
            }
        });

        int[] dp = new int[points.length];
        int max = 0;

        for (int i = 0; i < points.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                // important: be careful with the case of x1 = x2
                if (points[i].y > points[j].y && points[i].x > points[j].x) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max == 1 ? 0 : max;
    }

    static class Point {
       public int x;
       public int y;

       public Point(int x, int y) {
         this.x = x;
         this.y = y;
       }
    }

    public static void main(String[] args) {
        LargestSetPointsPositiveSlope obj = new LargestSetPointsPositiveSlope();

        Point[] points = new Point[4];
        points[0] = new Point(0,0);
        points[1] = new Point(1,1);
        points[2] = new Point(2,3);
        points[3] = new Point(3,3);

        System.out.println(obj.largest(points));
    }
}
