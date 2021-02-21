package tech.qijin.study.leetcode.list;

import java.util.HashMap;
import java.util.Map;

/**
 * [169. 多数元素](https://leetcode-cn.com/problems/majority-element/) 🔥
 */
public class Solution169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i< nums.length; i++){
            int value = nums[i];
            if (map.get(value) == null){
                map.put(value, 1);
            }else{
                map.put(value, map.get(value) + 1);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            if (((Integer)entry.getValue()).intValue() > nums.length / 2) {
                return (Integer) entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3};
        Solution169 solution169 = new Solution169();
        System.out.println(solution169.majorityElement(nums) == 3);
        nums = new int[]{2,2,1,1,1,2,2};
        System.out.println(solution169.majorityElement(nums) == 2);
    }
}
