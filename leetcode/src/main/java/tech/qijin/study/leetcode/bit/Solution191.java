package tech.qijin.study.leetcode.bit;

/**
 * [191. 位1的个数](https://leetcode-cn.com/problems/number-of-1-bits/) 🔥
 */
public class Solution191 {
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n = n & (n - 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution191 solution191 = new Solution191();
        System.out.println(solution191.hammingWeight(3) == 2);
    }
}
