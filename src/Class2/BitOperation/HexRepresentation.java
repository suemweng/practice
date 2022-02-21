/** easy
 * Laicode 78. Hexadecimal Representation
 *
 * Generate the hexadecimal representation for a given non-negative integer number as a string. The hex representation should start with "0x".
 *
 * There should not be extra zeros on the left side.
 *
 * Examples
 *
 * 0's hex representation is "0x0"
 * 255's hex representation is "0xFF"
 */

package Class2.BitOperation;

public class HexRepresentation {

    public String hex(int number) {
        // corner case
        if (number == 0) {
            return "0x0";
        }

        // using StringBuilder so append operation is more efficient
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            int remainder = number % 16;
            if (remainder < 10) {
                sb.append(remainder);
            } else {
                sb.append((char)(remainder - 10 + 'A'));
            }
            // number >>>= 4;
            number /= 16;
        }
        return "0x" + sb.reverse().toString();

    }

    public static void main(String[] args) {
        HexRepresentation obj = new HexRepresentation();

        int number = 15;
        System.out.println(obj.hex(number));
    }
}

// TC: O(n)
// SC: O(1)