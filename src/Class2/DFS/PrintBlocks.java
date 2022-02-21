/**
 * LaiOffer MidTerm
 *
 * Given an integer n, print/output all possible ways of writing n pairs of if blocks with correct indentation.
 *
 * Say n=2 output should be
 *
 *
 *
 * if {
 *
 * }
 *
 * if {
 *
 * }
 *
 * <newline>
 *
 * if {
 *
 *   if {// here should exist two spaces before each inner block
 *
 *   }
 *
 * }
 */

package Class2.DFS;

public class PrintBlocks {
    public void printBlocks(int n) {
        if (n <= 0) {
            return;
        }

        char[] array = new char[n * 2];
        permutationOfBlocks(array, 0, n, n);
    }

    // left represents how many '{' we still have
    // right represents how many '}' we still have
    private void permutationOfBlocks(char[] array, int index, int left, int right) {
        // base case
        if (index == array.length) {
            printBlock(array);
            return;
        }

        if (left > 0) {
            array[index] = '{';
            permutationOfBlocks(array, index + 1, left - 1, right);
        }

        if (right > left) {
            array[index] = '}';
            permutationOfBlocks(array, index + 1, left, right - 1);
        }

    }

    private void printBlock(char[] array) {
        int space = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '{') {
                printSpace(space);
                System.out.println("if {");
                space += 2;
            }

            if (array[i] == '}') {
                space -= 2;
                printSpace(space);
                System.out.println("}");
            }
        }
        System.out.println();
    }

    private void printSpace(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        PrintBlocks obj = new PrintBlocks();

        int n = 3;
        obj.printBlocks(n);
    }
}

// TC: O(2 ^ 2n * n ^ 2)
// SC: O(2n)