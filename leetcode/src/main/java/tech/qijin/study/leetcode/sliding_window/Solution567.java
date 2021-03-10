package tech.qijin.study.leetcode.sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * [567. 字符串的排列](https://leetcode-cn.com/problems/permutation-in-string/) 🔥🔥
 */
public class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        if ("".equals(s1)) return true;
        if (s2.length() < s1.length()) return false;
        Set<Character> target = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int k = 0; k < s1.length(); k++) {
            target.add(s1.charAt(k));
        }
        for (int k = 0; k < s1.length(); k++) {
            add(s2, target, k, map);
        }
        if (map.size() == target.size()) return true;
        for (int i = s1.length(); i < s2.length(); i++) {
            remove(s2, i - s1.length(), map);
            add(s2, target, i, map);
            if (map.size() == target.size()) return true;
        }
        return false;
    }

    private void add(String s2, Set<Character> target, int k, Map<Character, Integer> map) {
        if (target.contains(s2.charAt(k))) {
            Integer value = map.get(s2.charAt(k));
            map.put(s2.charAt(k), value == null ? 1 : value + 1);
        }
    }

    private void remove(String s2, int k, Map<Character, Integer> map) {
        Integer value = map.get(s2.charAt(k));
        if (value == null) return;
        if (value == 1) {
            map.remove(s2.charAt(k));
            return;
        }
        map.put(s2.charAt(k), value - 1);
    }

    public static void main(String[] args) {
//        // 输入: s1 = "ab" s2 = "eidbaooo"
//        // 输出: True
//        // 解释: s2 包含 s1 的排列之一 ("ba").
//        String s1 = "ab";
//        String s2 = "eidbaooo";
        Solution567 solution567 = new Solution567();
//        System.out.println(solution567.checkInclusion(s1, s2) == true);
//
//        // 输入: s1= "ab" s2 = "eidboaoo"
//        // 输出: False
//        s1 = "ab";
//        s2 = "eidboaoo";
//        System.out.println(solution567.checkInclusion(s1, s2) == false);
//
//        // s1="adc" s2="dcda"
//        // true
//        s1 = "adc";
//        s2 = "dcda";
//        System.out.println(solution567.checkInclusion(s1, s2) == true);

        // s1="hello" s2="ooolleoooleh"
        String s1 = "hello";
        String s2 = "ooolleoooleh";
        System.out.println(solution567.checkInclusion(s1, s2) == false);
    }
}
