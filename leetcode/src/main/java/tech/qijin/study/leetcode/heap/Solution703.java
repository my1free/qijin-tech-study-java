package tech.qijin.study.leetcode.heap;

/**
 * [703. 数据流中的第 K 大元素](https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/) 🔥
 */
public class Solution703 {
    int[] heap;
    public Solution703(int k, int[] nums) {
        heap = new int[k];
        for (int i = 0; i < k; i++){
            if (i < nums.length) {
                heap[i] = nums[i];
            }else{
                heap[i] = Integer.MIN_VALUE;
            }
        }
        buildMinHeap(heap, k);
        for (int i = k; i < nums.length; i++){
            add(nums[i]);
        }
    }

    public int add(int val) {
        if (heap[0] < val){
            heap[0] = val;
            heapAdjust(heap, 0, heap.length);
        }
        return heap[0];
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
        // ["KthLargest", "add", "add", "add", "add", "add"]
        // [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
        int[] nums = new int[]{4, 5, 8, 2};
        Solution703 solution703 = new Solution703(3, nums);
        System.out.println(solution703.add(3) == 4);
        System.out.println(solution703.add(5) == 5);
        System.out.println(solution703.add(10) == 5);
        System.out.println(solution703.add(9) == 8);
        System.out.println(solution703.add(4) == 8);
    }
}
