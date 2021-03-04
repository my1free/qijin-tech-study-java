package tech.qijin.study.leetcode.sliding_window;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * [567. 字符串的排列](https://leetcode-cn.com/problems/permutation-in-string/) 🔥🔥
 */
public class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        Set<Character> set = new HashSet<Character>();
        for (Character c : s1.toCharArray()) {
            set.add(c);
        }
        int count = 0;
        for (int i = 0; i < s2.length(); i++) {
            if (i > 0 && s2.charAt(i) == s2.charAt(i - 1)) continue;
            if (set.contains(s2.charAt(i))) {
                count++;
            }else {
                if (count == set.size()){
                    return true;
                }else{
                    count = 0;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // 输入: s1 = "ab" s2 = "eidbaooo"
        // 输出: True
        // 解释: s2 包含 s1 的排列之一 ("ba").
        String s1 = "ab";
        String s2 = "eidbaooo";
        Solution567 solution567 = new Solution567();
        System.out.println(solution567.checkInclusion(s1, s2));

        // 输入: s1= "ab" s2 = "eidboaoo"
        // 输出: False
        s1 = "ab";
        s2 = "eidboaoo";
        System.out.println(solution567.checkInclusion(s1, s2));
    }
}
