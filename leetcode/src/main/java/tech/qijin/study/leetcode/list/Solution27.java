package tech.qijin.study.leetcode.list;

/**
 * [27. 移除元素](https://leetcode-cn.com/problems/remove-element/) 🔥
 * 关键点：
 * 方法一：逐步迭代，复制元素。j 的下标不要从 1 开始啊啊啊啊
 * 方法二：如果删除的数据比较少，方法一的效率不高。由于可以更改元素顺序，可以将待删除的元素移动到数组最后
 */
public class Solution27 {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == val) break;
            i++;
        }
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Solution27 solution27 = new Solution27();
        int[] nums = new int[]{3, 2, 2, 3};
        System.out.println(solution27.removeElement(nums, 3));
        nums = new int[]{4, 1, 2, 3, 5};
        System.out.println(solution27.removeElement(nums, 4));
    }
}
