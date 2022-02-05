package Class2.String;

import java.util.Set;
import java.util.HashSet;

public class RemoveChars {
    // Assumption: input and t are not null
    public String remove(String input, String t) {

        // corner case
        if (input.length() == 0 || t.length() == 0) {
            return input;
        }

        // we need to know how to solve this problem with in-place way
        // Usually we can convert the immutable String into char[]
        char[] array = input.toCharArray();

        // Get set of all distinct characters in t
        // so that lookup operation will be efficient
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            set.add(t.charAt(i));
        }

        // [0, slow) contains the valid result
        // [fast, array.length) is the area to explore
        int slow = 0;
        for (int fast = 0; fast < input.length(); fast++) {
            // the exploring character can be put into the valid area
            // only if it's not in the set
            if (!set.contains(array[fast])) {
                array[slow++] = array[fast];
            }
        }

        // convert the char sub-array back to String object
        return new String(array, 0, slow);
    }

    public static void main(String[] args) {
        RemoveChars obj = new RemoveChars();

        String input = "abcd";
        String t = "ab";
        input = obj.remove(input, t);
        System.out.println(input);
    }
}

// TC: O(m + n) -- input.length() + t.length()
// SC: O(m + n) -- char array + set on heap

