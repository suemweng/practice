/**
 * Laicod 12. Fibonacci Number
 *
 * Get the Kth number in the Fibonacci Sequence. (K is 0-indexed, the 0th Fibonacci number is 0 and the 1st Fibonacci number is 1).
 *
 * Examples
 *
 * 0th fibonacci number is 0
 * 1st fibonacci number is 1
 * 2nd fibonacci number is 1
 * 3rd fibonacci number is 2
 * 6th fibonacci number is 8
 * Corner Cases
 *
 * What if K < 0? in this case, we should always return 0.
 * Is it possible the result fibonacci number is overflowed? We can assume it will not be overflowed when we solve this problem
 * on this online judge, but we should also know that it is possible to get an overflowed number, and sometimes we will need to use something like BigInteger.
 */

package Class2.DP;

public class FibonacciII {

    public long fibonacci(int K) {

        if (K <= 0) {
            return 0;
        }

        long dp1 = 0;
        long dp2 = 1;
        while (K > 1) {
            long dp3 = dp1 + dp2;
            dp1 = dp2;
            dp2 = dp3;
            K--;
        }

        return dp2;
    }

    public static void main(String[] args) {
        FibonacciII obj = new FibonacciII();

        int K = 6;
        System.out.println(obj.fibonacci(K));
    }
}

// TC: O(K)
// SC: O(1)