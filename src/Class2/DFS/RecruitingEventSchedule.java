package Class2.DFS;

import java.util.ArrayList;
import java.util.List;

public class RecruitingEventSchedule {

    public List<String> allPossibleSchedules(String input) {

        // Key insight:
        // stop the dfs at index == length - 1

        // TC: O(2 ^ n * n)
        // SC: O(n) -- call stack

        List<String> result = new ArrayList<>();

        if (input == null || input.length() == 0) {
            return result;
        }

        StringBuilder sb = new StringBuilder();
        dfs(0, sb, input, result);
        return result;
    }

    private void dfs(int index, StringBuilder sb, String input, List<String> result) {
        int sbLen = sb.length();

        if (index == input.length() - 1) {
            sb.append(input.charAt(input.length() - 1));
            result.add(sb.toString());
            sb.setLength(sbLen);
            return;
        }

        sb.append(input.charAt(index));
        dfs(index + 1, sb, input, result);

        sb.append('x');
        dfs(index + 1, sb, input, result);
        sb.setLength(sbLen);
    }

    public static void main(String[] args) {
        RecruitingEventSchedule obj = new RecruitingEventSchedule();

        String input = "ABCD";
        System.out.println(obj.allPossibleSchedules(input));
    }
}
