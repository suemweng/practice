/**
 * Leetcode 698
 */


package Class2.DFS;

import java.util.Arrays;

public class PartitionKSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        boolean[] used=new boolean[nums.length];
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
        }
        if(sum % k != 0)
            return false;
        int target = sum / k;
        if(nums[nums.length - 1] > target)
            return false;
        return dfs(nums,nums.length-1,target,0,k,used);
    }

    public static boolean dfs(int[] nums, int begin, int target, int curSum, int k, boolean[] used) {
        // base case - outer tree
        if(k == 1)
            return true;
        // base case - inner tree
        if(curSum == target)
            return dfs(nums,nums.length-1, target,0,k-1, used);


        for(int i = begin;i>=0;i--)
        {
            if(used[i]) {
                continue;
            }

            if(curSum+nums[i]>target) {
                continue;
            }

            used[i] = true;
            if(dfs(nums, i-1, target, curSum+nums[i], k, used)) {
                return true;
            }
            used[i] = false;
            while(i > 0 && nums[i-1] == nums[i]) {
                i--;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        PartitionKSubsets obj = new PartitionKSubsets();

        int[] nums = {4,5,9,3,10,2,10,7,10,8,5,9,4,6,4,9};
        int k = 5;
        System.out.println(obj.canPartitionKSubsets(nums, k));
    }
}
