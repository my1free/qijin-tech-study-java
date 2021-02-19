package tech.qijin.study.leetcode.sort;

/**
 * [912. 排序数组](https://leetcode-cn.com/problems/sort-an-array/) - 🔥🔥
 */
public class Solution912 {
    public int[] sortArray(int[] nums) {
        return nums;
    }

    // 快排
    private void quicksort(int[] nums) {
        //
    }

    // 堆排序
    private void heapsort(int[] nums) {
        //
    }

    // 归并排序
    private void mergesort(int[] nums) {
        //
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 1, 1, 2, 0, 0};
        Solution912 solution912 = new Solution912();
        solution912.sortArray(nums);
        System.out.println(nums[0] == 0);
        System.out.println(nums[1] == 0);
        System.out.println(nums[2] == 1);
        System.out.println(nums[3] == 1);
        System.out.println(nums[4] == 2);
        System.out.println(nums[5] == 5);
    }
}
