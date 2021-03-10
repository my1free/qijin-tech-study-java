package tech.qijin.study.leetcode.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * [242. 有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/) 🔥
 * 关键点：
 * 方案一：hash计数
 * 方案二：排序，然后判断排序后的字符串是否相等
 */
public class Solution242 {
    public boolean isAnagram(String s, String t) {
//        return hash(s, t);
        return sort(s, t);
    }

    private boolean hash(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        add(map1, s);
        add(map2, t);
        return equals(map1, map2);
    }

    private boolean sort(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        return new String(sc).equals(new String(tc));
    }

    private void add(Map<Character, Integer> map, String s) {
        for (Character c : s.toCharArray()) {
            if (map.get(c) != null) {
                map.put(c, map.get(c) + 1);
            }else{
                map.put(c, 1);
            }
        }
    }

    private boolean equals(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        if (map1.size() != map2.size()) {
            return false;
        }
        for (Map.Entry entry : map1.entrySet()) {
            if (map2.get(entry.getKey()) == null
                || !map2.get(entry.getKey()).equals(entry.getValue()))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution242 solution242 = new Solution242();
        // 输入: s = "anagram", t = "nagaram"
        // 输出: true
        String s = "anagram";
        String t = "nagaram";
        System.out.println(solution242.isAnagram(s, t) == true);

        // 输入: s = "rat", t = "car"
        // 输出: false
        s = "rat";
        t = "car";
        System.out.println(solution242.isAnagram(s, t) == false);
    }
}
