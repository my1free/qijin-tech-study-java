package tech.qijin.study.leetcode.dp;

public class Solution152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int ans = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(min * nums[i], Math.max(max * nums[i], nums[i]));
            min = Math.min(max * nums[i], Math.min(min * nums[i], nums[i]));
            ans = Math.max(ans, max);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, -2, 4};
        Solution152 solution152 = new Solution152();
        System.out.println(solution152.maxProduct(nums) == 6);
    }
}
