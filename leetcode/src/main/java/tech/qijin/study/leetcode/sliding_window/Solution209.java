package tech.qijin.study.leetcode.sliding_window;

/**
 * [209. 长度最小的子数组](https://leetcode-cn.com/problems/minimum-size-subarray-sum/submissions/) 🔥🔥
 * 关键点：滑动窗口
 */
public class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        // 暴力法
//        return bruteFore(target, nums);
        // 滑动窗口
        return slidingWindow(target, nums);
    }

    // 滑动窗口，时间复杂度 O(N)
    private int slidingWindow(int target, int[] nums) {
        int i = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= target) {
                ans = Math.min(j - i + 1, ans);
                sum = sum - nums[i];
                i++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    // 暴力解法，时间复杂度 O(N²)
    private int bruteFore(int target, int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return 1;
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == target) {
                    if (ans == 0) {
                        ans = j - i + 1;
                    } else {
                        ans = Math.min(ans, j - i + 1);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution209 solution209 = new Solution209();
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(solution209.minSubArrayLen(7, nums));
        nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(solution209.minSubArrayLen(15, nums));
    }
}
