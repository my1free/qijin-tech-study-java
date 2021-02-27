package tech.qijin.study.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * [7. 整数反转](https://leetcode-cn.com/problems/reverse-integer/) 🔥
 * 关键点：
 * 1. x % 10, x / 10
 * 2. 不需要用queue，一次遍历
 */
public class Solution7 {
    public int reverse(int x) {
        Queue<Integer> queue = new LinkedList<>();
        while (x != 0) {
            queue.offer(x % 10);
            x = x / 10;
        }
        int ans = 0;
        while (!queue.isEmpty()){
            int value = queue.poll();
            if ( (value > 0 && (Integer.MAX_VALUE - value) / 10 < ans) || (value < 0 && (Integer.MIN_VALUE - value) / 10 > ans)) {
                System.out.println("sd");
                return 0;
            }
            ans = ans * 10 + value;
        }
        return ans;
    }

    public static void main(String[] args) {
        int x = 123;
        Solution7 solution7 = new Solution7();
        System.out.println(solution7.reverse(x));
        x = -123;
        System.out.println(solution7.reverse(x));
        x = 120;
        System.out.println(solution7.reverse(x));
        x = 0;
        System.out.println(solution7.reverse(x));
    }
}
