package tech.qijin.study.leetcode.bit;

/**
 * [338. 比特位计数](https://leetcode-cn.com/problems/counting-bits/) 🔥🔥
 */
public class Solution338 {
    public int[] countBits(int num) {
//        return method1(num);
        return method2(num);
    }

    private int[] method1(int num) {
        int[] ans = new int[num+1];
        for (int i = 0; i<=num; i++){
            ans[i] = countBit(i);
        }
        return ans;
    }

    private int[] method2(int num) {
        int[] ans = new int[num+1];
        ans[0] = 0;
        for (int i = 1; i <= num; i++) {
            ans[i] = ans[i & (i-1)] +1;
        }
        return ans;
    }

    private int countBit(int n){
        if (n == 0) return 0;
        int sum = 0;
        while((n = (n & (n-1))) != 0) sum++;
        return sum+1;
    }

    public static void main(String[] args) {
        int n = 5;
        Solution338 solution338 = new Solution338();
        for (int i : solution338.countBits(n)) {
            System.out.println(i);
        }
    }
}
