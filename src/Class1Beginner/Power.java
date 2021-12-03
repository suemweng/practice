/* 538. Calculate a to the power of b (naive)

Example:
a = 3, b = 4  Return 81
a = 4, b = 2  Return 16


Assumption: a > 0, b > 0
Note: don’t worry about time complexity for now.


 */

public class Power {

    public static int power(int a, int b) {
        int p = 1;
        for (int i = 1; i <= b; i++) {
            p *= a;
        }
        return p;
    }

    public static void main(String[] args) {
        int a = 4;
        int b = 2;
        int p = power(a, b);
        System.out.println(p);
    }

}
