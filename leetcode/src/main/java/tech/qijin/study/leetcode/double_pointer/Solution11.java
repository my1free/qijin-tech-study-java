package tech.qijin.study.leetcode.double_pointer;

/**
 * [11. 盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/) 🔥🔥
 * 关键点：双指针，往中间走
 */
public class Solution11 {
    public int maxArea(int[] height) {
//        return bruteForce(height);
        return doublePointer(height);
    }

    private int doublePointer(int[] height) {
        int ans = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            ans = Math.max(ans, (r - l) * Math.min(height[l], height[r]));
            int tmp = height[l] <= height[r] ? l++ : r--;
        }
        return ans;
    }

    // 暴力破解法
    private int bruteForce(int[] height) {
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                ans = Math.max(ans, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        Solution11 solution11 = new Solution11();
        System.out.println(solution11.maxArea(height));
    }
}
