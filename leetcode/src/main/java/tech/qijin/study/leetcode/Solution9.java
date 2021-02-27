package tech.qijin.study.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * [9. 回文数](https://leetcode-cn.com/problems/palindrome-number/) 🔥
 * 方法一：stack辅助存储。时间复杂度O(N)，空间复杂度O(N)
 * 方法二：其实不需要全部遍历，只需要遍历一半就行。翻转的一半和未翻转的一半进行对比。
 * 关键点：需要时间复杂度 O(logN) 空间复杂度O(1)
 */
public class Solution9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        Deque<Integer> stack = new LinkedList<>();
        int t = x;
        while (t != 0) {
            stack.push(t % 10);
            t = t / 10;
        }
        while (x != 0){
            if (stack.pop() != x % 10) return false;
            x = x / 10;
        }
        return true;
    }

    public static void main(String[] args) {
        // 输入：x = 121
        // 输出：true
        Solution9 solution9 = new Solution9();
        int x = 121;
        System.out.println(solution9.isPalindrome(x) == true);
        x = -121;
        System.out.println(solution9.isPalindrome(x) == false);
        x = 10;
        System.out.println(solution9.isPalindrome(x) == false);
        x = 0;
        System.out.println(solution9.isPalindrome(x) == true);
    }
}
