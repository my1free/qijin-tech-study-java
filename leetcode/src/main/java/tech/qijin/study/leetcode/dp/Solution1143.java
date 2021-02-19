package tech.qijin.study.leetcode.dp;

/**
 * [1143. 最长公共子序列](https://leetcode-cn.com/problems/longest-common-subsequence/) 🔥🔥
 */
public class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == "" || text2 == "") return 0;
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for (int i = 1; i<=text1.length(); i++){
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        Solution1143 solution1143 = new Solution1143();
        System.out.println(3 == solution1143.longestCommonSubsequence(text1, text2));
    }
}
