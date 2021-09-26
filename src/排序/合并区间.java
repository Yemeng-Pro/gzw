package 排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        Arrays.sort(intervals,(int[] interval1, int[] interval2)-> interval1[0] - interval2[0]);
        List<int[]> result = new ArrayList<int[]>();
        int curLeft = intervals[0][0];
        int curRight = intervals[0][1];
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] <= curRight) {
                if (intervals[i][1] > curRight) {
                    curRight = intervals[i][1];
                }
            } else {
                result.add(new int[]{curLeft, curRight});
                curLeft = intervals[i][0];
                curRight = intervals[i][1];
            }
        }
        result.add(new int[]{curLeft, curRight});
        return result.toArray(new int[result.size()][]);
    }
}
