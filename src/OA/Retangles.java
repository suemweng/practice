package OA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Retangles {

    public boolean[] solution(int[][] operations) {

        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < operations.length; i++) {
            if (operations[i][0] == 0) {
                continue;
            }

            boolean pass = true;
            for (int j = 0; j < i; j++) {
                if (operations[j][0] == 0 && !canFit(operations,j, i)){
                    pass = false;
                    break;
                }
            }

            if (pass) {
                list.add(true);
            } else {
                list.add(false);
            }
        }

        boolean[] result = new boolean[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private boolean canFit(int[][] array, int out, int in) {

        return (array[out][1] >= array[in][1] && array[out][2] >= array[in][2])
                || (array[out][1] >= array[in][2] && array[out][2] >= array[in][1]);
    }

    public static void main(String[] args) {
        Retangles obj = new Retangles();

        int[][] operations = {{0,3,3},{0,5,2},{1,3,2},{1,2,4}};
        boolean[] result = obj.solution(operations);
        System.out.println(Arrays.toString(result));
    }
}
