/**
 * Laicode 292. String Abbreviation Matching
 *
 * Word “book” can be abbreviated to 4, b3, b2k, etc. Given a string and an abbreviation, return if the string matches the abbreviation.
 *
 * Assumptions:
 *
 * The original string only contains alphabetic characters.
 * Both input and pattern are not null.
 * Pattern would not contain invalid information like "a0a","0".
 * Examples:
 *
 * pattern “s11d” matches input “sophisticated” since “11” matches eleven chars “ophisticate”.
 */

package Class2.Recursion;

public class StringAbbrMatch {

    // Method 1: Recursive way
    // TC: O(n)
    // SC: O(n)
    public boolean match(String input, String pattern) {
        // Assumptions: input, pattern are not null
        return matchHelper(input, pattern, 0, 0);
    }

    private boolean matchHelper(String input, String pattern, int iIndex, int pIndex) {
        // base case
        // Only when we run out of input and pattern at the same time
        // there is a match
        if (pIndex == pattern.length() && iIndex == input.length()) {
            return true;
        } else if (pIndex >= pattern.length() || iIndex >= input.length()) {
            // if we run out of one of input and pattern, but there are still
            // some characters left for the other one, we cannot find the match
            return false;
        }

        // Case 1. if the current character in pattern is not a digit
        if (!isNumber(pattern.charAt(pIndex))) {
            if (input.charAt(iIndex) == pattern.charAt(pIndex)) {
                pIndex++;
                iIndex++;
            } else {
                return false;
            }
        } else {
            // Case 2. if the current character in pattern is a digit
            // we need to find in total what the number is
            int number = 0;
            while (pIndex < pattern.length() && isNumber(pattern.charAt(pIndex))) {
                number = number * 10 + (pattern.charAt(pIndex) - '0');
                pIndex++;
            }
            iIndex += number;
        }

        return matchHelper(input, pattern, iIndex, pIndex);

    }

    private boolean isNumber(char element) {
        if (element <= '9' && element >= '0') {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        StringAbbrMatch obj = new StringAbbrMatch();

        String input = "book";
        String pattern = "b2k";
        boolean result = obj.match(input, pattern);
        System.out.println(result);
    }
}
