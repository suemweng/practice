/**
 * Laicode 626. Reverse Bits of 32-bit Integer
 *
 * Reverse bits of a 32-bit integer.
 *
 * Note: In different programming languages, integers might be implemented differently in terms of number of bits, signed, unsigned, etc. However it should not affect your implementation on this problem. In java, the type of input is long, but you just need to work on the last 32-bit and consider it as an unsigned 32-bit integer.
 *
 * Example 1:
 *
 * Input: 1234 (0b'00000000000000000000010011010010)
 *
 * Output: 1260388352 (0b'01001011001000000000000000000000)
 */

package Class2.BitOperation;

public class ReverseBits {

    public long reverseBits(long n) {

        for (int offset = 0; offset < 16; offset++) {
            long right = (n >> offset ) & 1L;
            long left = (n >> 31 - offset) & 1L;
            if (left != right) {
                n ^= (1L << offset);
                n ^= (1L << 31 - offset);
            }
        }
        return n;
    }

    public static void main(String[] args) {
        ReverseBits obj = new ReverseBits();

        long n = 1234;
        System.out.println(obj.reverseBits(n));
    }

}
