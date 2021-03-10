package tech.qijin.study.leetcode.hash;

/**
 * [383. 赎金信](https://leetcode-cn.com/problems/ransom-note/) 🔥
 * 关键点：26个字符数组
 */
public class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] charCount = new int[26];
        for (Character c : magazine.toCharArray()) {
            charCount[c - 'a']++;
        }
        for (Character c : ransomNote.toCharArray()) {
            charCount[c - 'a']--;
            if (charCount[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution383 solution383 = new Solution383();
        // 输入：ransomNote = "a", magazine = "b"
        // 输出：false
        String ransomNote = "a";
        String magazine = "b";
        System.out.println(solution383.canConstruct(ransomNote, magazine) == false);
        // 输入：ransomNote = "aa", magazine = "ab"
        // 输出：false
        ransomNote = "aa";
        magazine = "ab";
        System.out.println(solution383.canConstruct(ransomNote, magazine) == false);
        // 输入：ransomNote = "aa", magazine = "aab"
        // 输出：true
        ransomNote = "aa";
        magazine = "aab";
        System.out.println(solution383.canConstruct(ransomNote, magazine) == true);
    }
}
