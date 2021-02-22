package tech.qijin.study.leetcode.dp;

/**
 * [5. 最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring/) 🔥🔥
 */
public class Solution5 {
    /**
     * Step1 状态定义：dp[i][j]表示i~j为下标的字符串是否是回文字符串
     * Step2 状态转移方程：if (s.charAt(i-1) == s.charAt(j+1)) dp[i][j] = dp[i+1][j-1]
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == "") return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        // 初始化
        for (int i = 0; i < s.length(); i++){
                dp[i][i] = true;
        }
        int min = 0; int max = 0;
        // 状态转移方程
        for (int i = s.length() - 1; i >= 0; i--){
            for (int j = i+1; j < s.length(); j++){
                if (j - i <= 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                }else{
                    dp[i][j] = false;
                }
                if (dp[i][j] && j-i > max-min){
                    min = i;
                    max = j;
                }
            }
        }
        return s.substring(min, max+1);
    }

    public static void main(String[] args) {
        String s = "babad";
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.longestPalindrome(s));
        s = "cbbd";
        System.out.println(solution5.longestPalindrome(s));
    }
}
