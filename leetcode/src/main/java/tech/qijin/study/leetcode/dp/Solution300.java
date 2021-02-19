package tech.qijin.study.leetcode.dp;

/**
 * [300. 最长递增子序列](https://leetcode-cn.com/problems/longest-increasing-subsequence/) 🔥🔥
 */
public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int ans = 1;
        int[] dp = new int[nums.length];
        for(int i = 0; i< nums.length; i++) dp[i] = 1;
        for(int i = 1; i< nums.length; i++){
            for (int j= 0; j < i; j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution300 solution300 = new Solution300();
        int[] nums = new int[]{0,1,0,3,2,3};
        System.out.println(solution300.lengthOfLIS(nums) == 4);
    }
}
