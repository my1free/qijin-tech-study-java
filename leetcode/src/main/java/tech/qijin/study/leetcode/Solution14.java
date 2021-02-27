package tech.qijin.study.leetcode;

/**
 * [14. 最长公共前缀](https://leetcode-cn.com/problems/longest-common-prefix/) 🔥
 * 关键点：归并 O(logN)
 */
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) return strs[start];
        if (start - end == 1) return findCommonPrefix(strs[start], strs[end]);
        int mid = (end - start) / 2 + start;
        return findCommonPrefix(longestCommonPrefix(strs, start, mid), longestCommonPrefix(strs, mid + 1, end));
    }

    private String findCommonPrefix(String s1, String s2) {
        int i = 0;
        while (true){
            if (i >= s1.length() || i >= s2.length()) {
                break;
            }
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }
            i++;
        }
        return s1.substring(0, i);
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        Solution14 solution14 = new Solution14();
        System.out.println(solution14.longestCommonPrefix(strs));
        strs = new String[]{"dog","racecar","car"};
        System.out.println(solution14.longestCommonPrefix(strs));
    }
}
