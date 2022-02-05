package Class2.String;

public class RemoveSpaces {

    public String removeSpaces(String input) {

        // corner case
        if (input.isEmpty()) {
            return input;
        }

        char[] array = input.toCharArray();

        int i = 0;
        int j = 0;

        while (j < array.length) {

            if (array[j] != ' ') {
                array[i++] = array[j++];
            } else if (i > 0 && array[i - 1] != ' ') {
                array[i++] = array[j++];
            } else {
                j++;
            }
        }

        // post-processing
        if (i > 0 && array[i - 1] == ' ') {
            i--;
        }

        return new String(array, 0, i);
    }

    public static void main(String[] args){
        RemoveSpaces obj = new RemoveSpaces();

        String input = "   abc   de  ";
        String result = obj.removeSpaces(input);
        System.out.println(result);

    }
}
