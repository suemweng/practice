package Class2.String;

public class Shuffling {
    // "ABCDE12345" --> "A1B2C3D4E5"

    String convert(String input) {
        // corner case
        if (input == null || input.length() == 0) {
            return new String();
        }

        char[] array = input.toCharArray();
        convert(array, 0, array.length - 1);
        return new String(array);
    }

    void convert(char[] a, int left, int right) {
        // base case
        if (right - left <= 1) {
            return;
        }

        int size = right - left + 1;
        int mid = left + size * 1 / 2;
        int lmid = left + size * 1 / 4;
        int rmid = left + size * 3 / 4;

        reverse(a, lmid, mid - 1);
        reverse(a, mid, rmid - 1);
        reverse(a, lmid, rmid - 1);

        convert(a, left, left + (lmid - left) * 2 - 1);
        convert(a, left + (lmid - left) * 2, right);
    }

    void reverse(char[] a, int i, int j) {
        int left = i;
        int right = j;

        while (left < right) {
            char temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Shuffling obj = new Shuffling();

        String input = "ABCDE12345";
        String result = obj.convert(input);
        System.out.println(result);
    }

}

// TC: O(nlogn)
// SC: O(logn)
