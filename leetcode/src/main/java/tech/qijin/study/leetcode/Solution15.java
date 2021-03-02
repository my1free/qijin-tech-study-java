package tech.qijin.study.leetcode;

import java.util.*;

/**
 * [15. 三数之和](https://leetcode-cn.com/problems/3sum/) 🔥🔥
 * 关键点：比较适合双指针法。去重位置要正确
 */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int h = nums.length - 1;
            while (l < h) {
                if (nums[i] + nums[l] + nums[h] > 0) {
                    h--;
                    continue;
                }
                if (nums[i] + nums[l] + nums[h] < 0) {
                    l++;
                    continue;
                }
                if (nums[i] + nums[l] + nums[h] == 0) {
                    List<Integer> t = new ArrayList<>();
                    t.add(nums[i]);
                    t.add(nums[l]);
                    t.add(nums[h]);
                    ans.add(t);
                    while (l < h && nums[h] == nums[h - 1]) h--;
                    while (l < h && nums[l] == nums[l + 1]) l++;
                    l++;
                    h--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(solution15.threeSum(nums));
        nums = new int[]{-2, 0, 0, 2, 2};
        System.out.println(solution15.threeSum(nums));
        // [[-5,1,4],[-4,0,4],[-4,1,3],[-2,-2,4],[-2,1,1],[0,0,0]]
        nums = new int[]{-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        System.out.println(solution15.threeSum(nums));
    }
}
