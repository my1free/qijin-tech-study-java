package tech.qijin.study.leetcode.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * [202. 快乐数](https://leetcode-cn.com/problems/happy-number/) 🔥
 * 关键点：用哈希存储sum是否存在过，如果存在过，则不是快乐数
 */
public class Solution202 {
    public boolean isHappy(int n) {
        Set<Integer> hash = new HashSet<>();
        while (true) {
            int sum = 0;
            while (n > 0) {
                sum += (n % 10) * (n % 10);
                n = n / 10;
            }
            if (sum == 1) return true;
            if (hash.contains(sum)){
                return false;
            }else {
                n = sum;
                hash.add(sum);
            }
        }
    }

    public static void main(String[] args) {
        //输入：19
        //输出：true
        //解释：
        //1² + 9² = 82
        //8² + 2² = 68
        //6² + 8² = 100
        //1² + 0² + 0² = 1
        Solution202 solution202 = new Solution202();
        System.out.println(solution202.isHappy(19));

        // 输入：n = 2
        // 输出：false
        System.out.println(solution202.isHappy(2));
    }
}
