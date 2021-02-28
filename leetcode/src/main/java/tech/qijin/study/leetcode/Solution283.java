package tech.qijin.study.leetcode;

/**
 * [283. 移动零](https://leetcode-cn.com/problems/move-zeroes/) 🔥
 * 同类问题：Solution26, Solution27
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0){
                nums[i] = nums[j];
                if (i != j) nums[j] = 0;
                i++;
            }
        }
    }

    public static void main(String[] args) {
        Solution283 solution283 = new Solution283();
        int[] nums = new int[]{0, 1, 0, 3, 12};
        solution283.moveZeroes(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}
