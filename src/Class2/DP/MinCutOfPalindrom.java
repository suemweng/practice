package Class2.DP;

public class MinCutOfPalindrom {

    public int minCuts(String input) {
        if (input == null || input.length() <= 1) {
            return 0;
        }

        char[] array = input.toCharArray();
        int[] minCut = new int[array.length + 1];
        minCut[0] = 0;
        minCut[1] = 0;

        // i represent substring length
        // j represent the cut before index j
        for (int i = 1; i <= array.length; i++){
            minCut[i] = i - 1; // worst case to separate all characters
            for (int j = 0; j < i; j++) {
                if (validPalindrome(array, j, i - 1)) {
                    if (j == 0) {
                        minCut[i] = 0;
                        break;
                    }
                    minCut[i] = Math.min(minCut[i], minCut[j] + 1);
                }
            }
        }
        return minCut[array.length];
    }

    // helper function to valid the substring [j, i-1] is palindrome
    private boolean validPalindrome(char[] array, int i, int j) {
        while (i < j) {
            if (array[i] != array[j]){
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinCutOfPalindrom obj = new MinCutOfPalindrom();

        String input = "ababbbabbababa";
        System.out.println(obj.minCuts(input));
    }
}
