package tech.qijin.study.leetcode.list;

/**
 * [26. 删除排序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/) 🔥
 * 关键点：用一个 i 和一个 j 就够了
 */
public class Solution26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums.length;
        int pre = nums[0];
        int r = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != pre) {
                pre = nums[i];
                swap(nums, r, i);
                r++;
            }
        }
        return r;
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int t = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = t;
    }

    public static void main(String[] args) {
        // 给定 nums = [0,0,1,1,1,2,2,3,3,4],
        // 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
        Solution26 solution26 = new Solution26();
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(solution26.removeDuplicates(nums));
    }
}
