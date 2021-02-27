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
        buildMaxHeap(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapAdjust(nums, 0, i - 1);
        }
    }

    private void buildMaxHeap(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            heapAdjust(nums, i, nums.length);
        }
    }

    private void heapAdjust(int[] nums, int i, int len) {
        while (i < len) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;
            int large = i;
            if (left < len && nums[left] > nums[i]){
                large = left;
            }
            if (right < len && nums[right] > nums[large]) {
                large = right;
            }
            if (large != i) {
                swap(nums, large, i);
                i = large;
            } else {
                break;
            }
        }
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
        int[] nums = new int[]{5, 1, 1, 2, 0, 7};
        Solution912 solution912 = new Solution912();
        solution912.sortArray(nums);
        for (int num : nums) {
            System.out.println(num);
        }
        System.out.println(nums[0] == 0);
        System.out.println(nums[1] == 0);
        System.out.println(nums[2] == 1);
        System.out.println(nums[3] == 1);
        System.out.println(nums[4] == 2);
        System.out.println(nums[5] == 5);
    }
}
