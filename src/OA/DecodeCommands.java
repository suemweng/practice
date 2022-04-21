package OA;

import java.util.Arrays;

public class DecodeCommands {

    public int[] solution(String[] commands) {

        String[] decode = new String[commands.length];

        for(int i = 0; i < commands.length; i++) {
            String str = commands[i];
            if (str.charAt(0) == '!') {
                int number = stringToNumber(str.substring(1));
                decode[i] = decode[number - 1];
            } else {
                decode[i] = commands[i];
            }
        }

        int[] count = new int[3];
        for (String str : decode) {
            if (str.equals("cp")) {
                count[0]++;
            } else if (str.equals("ls")) {
                count[1]++;
            } else {
                count[2]++;
            }
        }
        return count;
    }

    private int stringToNumber(String str) {
        int num = 0;
        for (char ch : str.toCharArray()) {
            num = num * 10 +  (ch - '0');
        }
        return num;
    }

    public static void main(String[] args) {
        DecodeCommands obj = new DecodeCommands();

        String[] commands = {"ls","cp","mv","mv","mv","!1","!3","!6"};
        int[] result = obj.solution(commands);
        System.out.println(Arrays.toString(result));
    }
}
