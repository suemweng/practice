package Class1Beginner;/*  544. Design an accumulator

Design an accumulator, which can take a new integer using function “add”, and can return the sum of all taken integers up to now using function “sum”.

 */


public class Accumulator {
    public void add(int x) {
        sum += x;
    }
    public int sum() {
        return sum;
    }
    int sum;
}
