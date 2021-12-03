/* 536

Calculate the sum of all square numbers between 1 and n (inclusive).
Example:
n = 3. Return 1;
n = 10. Return 14 (1 + 4 + 9);

 */

public class SumSquares {

    public static int sumOfSquares( int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (n >= i * i) {
                sum += i * i;
            }
        }

        return sum;

    }


    public static void main ( String[] args){
        int n = 10000;
        int sum = sumOfSquares(n);
        System.out.println(sum);

    }

}
