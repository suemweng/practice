package Class2.MapSetHash;

import java.util.HashMap;
import java.util.Map;

public class HashUsing {

    public static void main(String[] args) {
        Map<String, Integer> employeeNumbers = new HashMap<>();
        employeeNumbers.put("yahoo", 1);
        System.out.println(employeeNumbers);

        employeeNumbers.put("google", 2);
        System.out.println(employeeNumbers);

        Integer yc = employeeNumbers.get("yahoo");
        System.out.println(employeeNumbers + " yc:" + yc);

        yc = employeeNumbers.put("yahoo", 5);
        System.out.println(employeeNumbers + " yc:" + yc);

        yc = employeeNumbers.get("yahoo");
        System.out.println(employeeNumbers + " yc:" + yc);

        Integer fc = employeeNumbers.get("facebook");
        System.out.println(employeeNumbers + " fc:" + fc);

        boolean fe = employeeNumbers.containsKey("facebook");
        System.out.println(employeeNumbers + " fe:" + fe);

        fc = employeeNumbers.remove("facebook");
        System.out.println(employeeNumbers + " fc:" + fc);

        Integer gc = employeeNumbers.remove("google");
        System.out.println(employeeNumbers + " gc:" + gc);
    }
}
