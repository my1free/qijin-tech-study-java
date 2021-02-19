package tech.qijin.study.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * [120. 三角形最小路径和](https://leetcode-cn.com/problems/triangle/) 🔥🔥
 */
public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        for (int j = 0; j < triangle.get(triangle.size() - 1).size(); j++) {
            dp[triangle.size() - 1][j] = triangle.get(triangle.size() - 1).get(j);
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
    public static void main(final String[] args) {
        Solution120 solution120 = new Solution120();
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        triangle.add(new ArrayList<Integer>(){{
            add(2);
        }});
        triangle.add(new ArrayList<Integer>(){{
            add(3);
            add(4);
        }});
        triangle.add(new ArrayList<Integer>(){{
            add(6);
            add(5);
            add(7);
        }});
        triangle.add(new ArrayList<Integer>(){{
            add(4);
            add(1);
            add(8);
            add(3);
        }});
        System.out.println(11 == solution120.minimumTotal(triangle));
    }
}
