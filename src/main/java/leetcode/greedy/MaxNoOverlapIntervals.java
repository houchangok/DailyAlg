package leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MaxNoOverlapIntervals {


    public int maxNoOverlapIntervals(int[][] intervals) {
        //按照end升序排列
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int count = 1;
        int x_end = intervals[0][1];
        for (int[] interval : intervals) {
            int start = interval[0];
            //特殊情况的边界处理/**/
            if (start >= x_end) {
                count++;
                x_end = interval[1];
            }
        }
        return count;

    }
}
