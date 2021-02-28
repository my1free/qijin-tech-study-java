package tech.qijin.study.leetcode;

/**
 * [66. 加一](https://leetcode-cn.com/problems/plus-one/) 🔥
 * 看看这个答案吧，很神: https://leetcode-cn.com/problems/plus-one/solution/java-shu-xue-jie-ti-by-yhhzw/
 */
public class Solution66 {
    public int[] plusOne(int[] digits) {
        int delta = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int v = digits[i] + delta + ((i == digits.length - 1) ? 1 : 0);
            digits[i] = v % 10;
            delta = v / 10;
        }
        if (delta != 0){
            int[] ans = new int[digits.length + 1];
            ans[0] = delta;
            for (int i = 1; i < ans.length; i++) {
                ans[i] = digits[i - 1];
            }
            digits = ans;
        }
        return digits;
    }

    public static void main(String[] args) {
        Solution66 solution66 = new Solution66();
        int[] digits = new int[]{1,2,3};
        solution66.plusOne(digits);
        for (int i : digits) {
            System.out.println(i);
        }
    }
}
