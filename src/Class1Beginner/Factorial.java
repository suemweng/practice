/* 537

求n的阶乘. Assumption, n > 1.
Example:
n = 3, return 6
n = 4, return 24
n = 5, return 120

 */


public class Factorial {
    public static int factorial(int n) {
        int f = 1;
        for (int i = n; i >= 1; i--) {
            f *= i;
        }
        return f;
    }


    public static void main (String[] args) {
        int n = 5;
        int f = factorial(n);
        System.out.println(f);
    }



}
