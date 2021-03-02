package tech.qijin.study.leetcode;

import java.util.Arrays;

/**
 * [59. 螺旋矩阵 II](https://leetcode-cn.com/problems/spiral-matrix-ii/) 🔥🔥
 * 关键点： 考虑边界边界边界
 */
public class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int i = 0;
        int j = -1;
        int value = 0;
        while (true) {
            if (value >= n * n) break;
            for (j = j + 1; !isEnd(ans, i, j, n); j++) {
                value++;
                ans[i][j] = value;
            }
            j = j - 1;
            for (i = i + 1; !isEnd(ans, i, j, n); i++) {
                value++;
                ans[i][j] = value;
            }
            i = i - 1;
            for (j = j - 1; !isEnd(ans, i, j, n); j--) {
                value++;
                ans[i][j] = value;
            }
            j = j + 1;
            for (i = i - 1; !isEnd(ans, i, j, n); i--) {
                value++;
                ans[i][j] = value;
            }
            i = i + 1;
        }
        return ans;
    }

    private boolean isEnd(int[][] ans, int i, int j, int n) {
        if (i < 0 || i >= n) return true;
        if (j < 0 || j >= n) return true;
        if (ans[i][j] != 0) return true;
        return false;
    }

    public static void main(String[] args) {
        Solution59 solution59 = new Solution59();
        for (int[] a : solution59.generateMatrix(5)) {
            System.out.println(Arrays.toString(a));
        }
    }
}
