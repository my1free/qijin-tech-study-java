package tech.qijin.study.leetcode.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * [56. 合并区间](https://leetcode-cn.com/problems/merge-intervals/) 🔥🔥
 */
public class Solution56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (ans.size() == 0) {
                ans.add(intervals[i]);
                continue;
            }
            if (intervals[i][0] <= ans.get(ans.size() - 1)[1]) {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], intervals[i][1]);
            }else{
                ans.add(intervals[i]);
            }
        }
        return ans.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        // 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
        // 输出：[[1,6],[8,10],[15,18]]
        // 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6]

        Solution56 solution56 = new Solution56();
        int[][] intervals = new int[4][];
        intervals[0] = new int[]{1, 3};
        intervals[1] = new int[]{2, 6};
        intervals[2] = new int[]{8, 10};
        intervals[3] = new int[]{15, 18};
        for (int[] i : solution56.merge(intervals)) {
            for (int ii : i){
                System.out.println(ii);
            }
            System.out.println("===");
        }
    }
}
