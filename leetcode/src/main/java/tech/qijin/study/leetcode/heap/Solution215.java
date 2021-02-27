package tech.qijin.study.leetcode.heap;

/**
 * [215. 数组中的第K个最大元素](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/) 🔥🔥
 */
public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length < k) return 0;
        buildMinHeap(nums, k);
        for (int i = k; i < nums.length; i++) {
            if (nums[0] < nums[i]) {
                nums[0] = nums[i];
                heapAdjust(nums, 0, k);
            }
        }
        return nums[0];
    }

    private void buildMinHeap(int[] nums, int k) {
        for (int i = k / 2 - 1; i >= 0; i--) {
            heapAdjust(nums, i, k);
        }
    }

    private void heapAdjust(int[] nums, int i, int len) {
        while (i < len) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;
            int small = i;
            if (left < len && nums[left] < nums[i]) {
                small = left;
            }
            if (right < len && nums[right] < nums[small]) {
                small = right;
            }
            if (small != i) {
                int tmp = nums[small];
                nums[small] = nums[i];
                nums[i] = tmp;
            } else {
                break;
            }
            i = small;
        }
    }

    public static void main(String[] args) {
        Solution215 solution215 = new Solution215();
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(solution215.findKthLargest(nums, 2) == 5);
        nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(solution215.findKthLargest(nums, 4) == 4);
    }
}
