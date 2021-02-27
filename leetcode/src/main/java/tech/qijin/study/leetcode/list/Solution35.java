package tech.qijin.study.leetcode.list;

/**
 * [35. 搜索插入位置](https://leetcode-cn.com/problems/search-insert-position/) 🔥
 * 关键点：二分，找对位置
 */
public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int low = 0; int high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) high = mid - 1;
            if (nums[mid] < target) low = mid + 1;
        }
        return low;
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * 你可以假设数组中无重复元素。
     *
     * 示例 1:
     *
     * 输入: [1,3,5,6], 5
     * 输出: 2
     * 示例 2:
     *
     * 输入: [1,3,5,6], 2
     * 输出: 1
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        Solution35 solution35 = new Solution35();
        System.out.println(solution35.searchInsert(nums, 5) == 2);
        nums = new int[]{1, 3, 5, 6};
        System.out.println(solution35.searchInsert(nums, 2) == 1);
    }

}
