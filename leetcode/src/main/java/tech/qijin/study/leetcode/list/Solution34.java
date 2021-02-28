package tech.qijin.study.leetcode.list;

/**
 * [34. 在排序数组中查找元素的第一个和最后一个位置](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/) 🔥🔥
 * 关键点：典型的二分
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = -1; ans[1] = -1;
        int low = 0; int high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] == target) {
                int p = mid-1;
                int q = mid + 1;
                while (p >= 0 && nums[p] == target) {
                    p--;
                }
                ans[0] = p + 1;
                while (q <= nums.length - 1 && nums[q] == target){
                    q++;
                }
                ans[1] = q - 1;
            }
            if (nums[mid] > target) high = mid - 1; else low = mid + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] ans = solution34.searchRange(nums, 8);
        for (int i : ans){
            System.out.println(i);
        }
    }
}
