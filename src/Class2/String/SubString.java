package Class2.String;

public class SubString {

    // Method 1
    // TC: O(n * m)
    // SC: O(1)
    public int subString(String s1, String s2) {
        // corner case
        if ( s1 == null || s2 == null || s1.length() < s2.length()) {
            return -1;
        }

        for (int i = 0; i <= s1.length() - s2.length(); i++) {              // mistake: include ==
            int j = 0;
            while (j < s2.length() && s1.charAt(i + j) == s2.charAt(j)) {   // trick: not moving i, but add j to i
                j++;
            }

            if (j == s2.length()) {
                return i;
            }
        }
        return -1;
    }

    // Method 2: Rabin-Karp
    // TC: O(m + n) wc O(n*m)

    public static void main(String[] args) {
        SubString obj = new SubString();

        String s1 = "abcde";
        String s2 = "cde";
        int index = obj.subString(s1, s2);
        System.out.println(index);
    }
}
