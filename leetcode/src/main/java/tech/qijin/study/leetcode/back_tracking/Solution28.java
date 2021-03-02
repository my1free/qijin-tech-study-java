package tech.qijin.study.leetcode.back_tracking;

/**
 * [28. 实现 strStr()](https://leetcode-cn.com/problems/implement-strstr/) 🔥
 * 大名鼎鼎的 KMP 算法。但是我不会
 */
public class Solution28 {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;
        if (haystack.equals("")) return -1;
        if (haystack.length() < needle.length()) return -1;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) != needle.charAt(0)){
                continue;
            }
            int j = 0;
            for ( ;j < needle.length(); j++) {
                if (i + j >= haystack.length()) return -1;
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        // 输入: haystack = "hello", needle = "ll"
        // 输出: 2
        String haystack = "hello";
        String needle = "ll";
        Solution28 solution28 = new Solution28();
        System.out.println(solution28.strStr(haystack, needle));
        // 输入: haystack = "aaaaa", needle = "bba"
        // 输出: -1
        haystack = "aaaaa";
        needle = "bba";
        System.out.println(solution28.strStr(haystack, needle));

        haystack = "";
        needle = "";
        System.out.println(solution28.strStr(haystack, needle));
    }
}
