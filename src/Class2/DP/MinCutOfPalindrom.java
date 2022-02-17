package Class2.DP;

public class MinCutOfPalindrom {

    public int minCut(String input) {

        int[] minCut = new int[input.length() + 1];
        minCut[0] = -1;

        // if(valid(substring(j, i)))   minCut[i] = min(minCut[j] + 1)   0 <= j < i
        for (int i = 1; i <= input.length(); i++) {
            minCut[i] = i - 1;
            for (int j = 0; j < i; j++) {
                if (validPalindrome(input.substring(j, i))) {
                    minCut[i] = Math.min(minCut[i], minCut[j] + 1);
                }
            }
        }
        return minCut[input.length()];
    }

    private boolean validPalindrome(String input) {
        char[] array = input.toCharArray();

        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            if (array[i] == array[j]) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinCutOfPalindrom obj = new MinCutOfPalindrom();

        String input = "zabbac";
        System.out.println(obj.minCut(input));
    }
}
