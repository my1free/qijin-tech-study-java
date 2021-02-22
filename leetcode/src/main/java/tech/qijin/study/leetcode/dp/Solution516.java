package tech.qijin.study.leetcode.dp;

/**
 * [516. 最长回文子序列](https://leetcode-cn.com/problems/longest-palindromic-subsequence/) 🔥🔥
 */
public class Solution516 {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >=0; i--){
            for (int j = i; j < s.length(); j++){
                if (j - i <= 1) {
                    dp[i][j] += s.charAt(i) == s.charAt(j) ? (j - i + 1) : 1;
                }else if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i+1][j-1], Math.max(dp[i][j-1], dp[i+1][j]));
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        String s = "bbbab";
        Solution516 solution516 = new Solution516();
        System.out.println(solution516.longestPalindromeSubseq(s) == 4);
    }
}
