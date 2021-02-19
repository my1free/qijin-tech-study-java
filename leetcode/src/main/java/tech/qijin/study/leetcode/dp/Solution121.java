package tech.qijin.study.leetcode.dp;

public class Solution121 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }else {
                ans = Math.max(ans, prices[i] - minPrice);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        Solution121 solution121 = new Solution121();
        System.out.println(solution121.maxProfit(prices) == 5);
        prices = new int[]{7, 6, 4, 3, 1};
        System.out.println(solution121.maxProfit(prices) == 0);
    }
}
