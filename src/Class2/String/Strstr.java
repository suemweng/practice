/**
 * Laicode 85. Determine If One String Is Another's Substring
 *
 * Determine if a small string is a substring of another large string.
 *
 * Return the index of the first occurrence of the small string in the large string.
 *
 * Return -1 if the small string is not a substring of the large string.
 *
 * Assumptions
 *
 * Both large and small are not null
 * If small is empty string, return 0
 * Examples
 *
 * “ab” is a substring of “bcabc”, return 2
 * “bcd” is not a substring of “bcabc”, return -1
 * "" is substring of "abc", return 0
 */

package Class2.String;

public class Strstr {

    // TC: O(n * (m - n))
    // SC: O(1)

    public int strstr(String large, String small) {

        if (small.length() == 0) {
            return 0;
        }

        if (large.length() < small.length()) {
            return -1;
        }

        // important: <=
        for (int i = 0; i <= large.length() - small.length(); i++) {
            if (large.substring(i, i + small.length()).equals(small)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Strstr obj = new Strstr();

        String large = "bcabc";
        String small = "ab";
        System.out.println(obj.strstr(large, small));

    }
}
