package tech.qijin.study.leetcode.hash;

import java.util.*;

/**
 * [349. 两个数组的交集](https://leetcode-cn.com/problems/intersection-of-two-arrays/) 🔥
 * 方案一：hash计数
 * 方案二：排序 + 双指针
 */
public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set1 = toSet(nums1);
        Set<Integer> set2 = toSet(nums2);
        for (Integer ele : set1) {
            if (set2.contains(ele)) {
                ans.add(ele);
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    private Set<Integer> toSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set;
    }

    public static void main(String[] args) {
        // 输入：nums1 = [1,2,2,1], nums2 = [2,2]
        // 输出：[2]
        Solution349 solution349 = new Solution349();
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        System.out.println(Arrays.toString(solution349.intersection(nums1, nums2)));

        // 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        // 输出：[9,4]
        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(solution349.intersection(nums1, nums2)));
    }
}
