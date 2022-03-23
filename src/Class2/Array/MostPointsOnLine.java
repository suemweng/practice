/**
 * Laicode 216. Most Points On A Line
 *
 * Given an array of 2D coordinates of points (all the coordinates are integers), find the largest number of points that can be crossed by a single line in 2D space.
 *
 * Assumptions
 *
 * The given array is not null and it has at least 2 points
 * Examples
 *
 * <0, 0>, <1, 1>, <2, 3>, <3, 3>, the maximum number of points on a line is 3(<0, 0>, <1, 1>, <3, 3> are on the same line)
 *
 */

package Class2.Array;

import java.util.HashMap;

public class MostPointsOnLine {

    public int most(Point[] points) {

        // Key insight
        // any line can be represented by a point and a slope
        // iterate each point and find their own max number on the same slope

        // TC: O(n^2)
        // SC: O(n)


        int result = 0;
        for (int i = 0; i < points.length; i++) {
            Point seed = points[i];
            int same = 1; // same <x,y>
            int sameX = 0; // special slope infinite;
            int most = 0;

            HashMap<Double, Integer> count = new HashMap<Double, Integer>();

            for (int j = 0; j < points.length; j++) {
                // same point
                if (i == j) {
                    continue;
                }

                Point temp = points[j];
                // same <x,y>
                if (seed.x == temp.x && seed.y == temp.y) {
                    same++;
                } else if (seed.x == temp.x)  {
                    sameX++;
                } else {
                    double slope = (temp.y - seed.y + 0.00) / (temp.x - seed.x);
                    if (!count.containsKey(slope)) {
                        count.put(slope, 1);
                    } else {
                        count.put(slope, count.get(slope) + 1);
                    }
                    most = Math.max(most, count.get(slope));
                }
            }
            most = Math.max(most, sameX) + same;
            result = Math.max(result, most);
        }
        return result;
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
        MostPointsOnLine obj = new MostPointsOnLine();

        Point[] points = new Point[3];
        points[0] = new Point(1,1);
        points[1] = new Point(2,3);
        points[2] = new Point(1,1);

        System.out.println(obj.most(points));
    }
}
