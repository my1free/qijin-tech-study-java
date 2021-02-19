package tech.qijin.study.leetcode.bit;

/**
 * [231. 2的幂](https://leetcode-cn.com/problems/power-of-two/) 🔥
 */
public class Solution231 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }
}
