package tech.qijin.study.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * [13. 罗马数字转整数](https://leetcode-cn.com/problems/roman-to-integer/) 🔥
 * 关键点：找到规律 - 前面小，则减。否则加
 */
public class Solution13 {
    public int romanToInt(String s) {
        /**
         * 字符          数值
         * I             1
         * V             5
         * X             10
         * L             50
         * C             100
         * D             500
         * M             1000
         */
        Map<Character, Integer> map = new HashMap<Character, Integer>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int ans = 0;
        char pre = '\0';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            ans += map.get(c);
            if (pre != '\0'){
                if (((c == 'V' || c == 'X') && pre == 'I')
                || ((c == 'L' || c == 'C') && pre == 'X')
                || ((c == 'D' || c == 'M') && pre == 'C')){
                    ans = ans - 2 * map.get(pre);
                }
            }
            pre = c;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        String s = "MCMXCIV";
        System.out.println(solution13.romanToInt(s));
        s = "IX";
        System.out.println(solution13.romanToInt(s));
        s = "LVIII";
        System.out.println(solution13.romanToInt(s));
        s = "MCMXCIV";
        System.out.println(solution13.romanToInt(s));
    }
}
