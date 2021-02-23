package tech.qijin.study.leetcode.sort;

/**
 * [912. 排序数组](https://leetcode-cn.com/problems/sort-an-array/) - 🔥🔥
 */
public class Solution912 {
    public int[] sortArray(int[] nums) {
        heapsort(nums);
        return nums;
    }

    // 快排
    private void quicksort(int[] nums) {
        //
    }

    // 堆排序
    private void heapsort(int[] nums) {
        if (nums.length == 0) return;
        // 构建一个大顶堆
    }


    // 归并排序
    private void mergesort(int[] nums) {
        //
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
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
