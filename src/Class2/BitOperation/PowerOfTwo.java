/**
 * Laicode 74. Power Of Two
 *
 * Determine if a given integer is power of 2.
 *
 * Examples
 *
 * 16 is power of 2 (2 ^ 4)
 * 3 is not
 * 0 is not
 * -1 is not
 */

package Class2.BitOperation;

public class PowerOfTwo {

    public boolean isPowerOfTwo(int number) {
        // corner check
        if (number <= 0) {
            return false;
        }

        while ((number & 1) == 0) {
            number = number >> 1;
        }

        return number == 1;

    }

    public static void main(String[] args) {
        PowerOfTwo obj = new PowerOfTwo();

        int number = 16;
        System.out.println(obj.isPowerOfTwo(number));
    }
}
