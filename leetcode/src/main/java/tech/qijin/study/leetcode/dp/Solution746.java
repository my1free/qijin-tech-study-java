package tech.qijin.study.leetcode.dp;

/**
 * [746. 使用最小花费爬楼梯](https://leetcode-cn.com/problems/min-cost-climbing-stairs/) 🔥
 */
public class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length <= 2) return 0;
        int[] dp = new int[cost.length];
        dp[0] = cost[0]; dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    public static void main(String[] args) {
        int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        Solution746 solution746 = new Solution746();
        System.out.println(6 == solution746.minCostClimbingStairs(cost));
    }
}
