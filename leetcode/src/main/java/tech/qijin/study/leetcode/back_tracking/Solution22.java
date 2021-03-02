package tech.qijin.study.leetcode.back_tracking;

import java.util.ArrayList;
import java.util.List;

/**
 * [22. 括号生成](https://leetcode-cn.com/problems/generate-parentheses/) 🔥🔥
 */
public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        int l = 0; int r = 0;
        dfs(n, "(", "", ans, l+1, r);
        return ans;
    }

    private void dfs(int n, String a, String path, List<String> ans, int l, int r) {
        if (l > n) return;
        if (r > l) return;
        path = path + a;
        if (path.length() >= 2 * n){
            ans.add(path);
            return;
        }
        dfs(n, "(", path, ans, l+1, r);
        dfs(n, ")", path, ans, l, r+1);
    }

    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        System.out.println(solution22.generateParenthesis(3));
    }
}
