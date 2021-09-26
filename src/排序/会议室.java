package 排序;

import java.util.Arrays;
import java.util.Comparator;

public class 会议室 {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (int[] i1, int[] i2) -> {return (i1[0] - i2[0]);});

        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] < intervals[i-1][1]) return false;
        }
        return true;
    }
}
