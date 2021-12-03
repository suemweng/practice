/*  635. Sum of Squares

Problem: Give an array list of integer, calculate the sum of squares of all its elements.
Note: return 0 if the list is null or empty.


Example:
list = {1,2,3} → returns 14 (14=1*1+2*2+3*3)


 */

package Class1Beginner;
import java.util.ArrayList;
import java.util.List;

public class SumSquares2 {

    public static int sumOfSquare(List<Integer> list) {

        if(list == null) {
            return 0;
        }
        int sum = 0;
        for( int i = 0; i<list.size (); i++){
            sum += list.get(i) * list.get(i);
        }
        return sum;
    }

    public static void main(String[] argos) {
        List<Integer> list = new ArrayList<Integer>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
        int sum = sumOfSquare(list);
        System.out.println(sum);

    }
}
