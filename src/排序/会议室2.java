package 排序;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.TransferQueue;

public class 会议室2 {
    @Test
    public void test() {
        int[][] intervals = {{3,5}, {2, 9}};
        System.out.println(minMeetingRooms(intervals));

    }
    //排序
    //分别将开始时间和结束时间存进两个数组。
    //分别对开始时间和结束时间进行排序。请注意，这将打乱开始时间和结束时间的原始对应关系。它们将被分别处理。
    //考虑两个指针：s_ptr 和 e_ptr ，分别代表开始指针和结束指针。开始指针遍历每个会议，结束指针帮助我们跟踪会议是否结束。
    //当考虑 s_ptr 指向的特定会议时，检查该开始时间是否大于 e_ptr 指向的会议。若如此，则说明 s_ptr 开始时，已经有会议结束。于是我们可以重用房间。否则，我们就需要开新房间。
    //若有会议结束，换而言之，start[s_ptr] >= end[e_ptr] ，则自增 e_ptr 。
    //重复这一过程，直到 s_ptr 处理完所有会议。
    //

    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i=0;i<intervals.length;i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int rooms=0, activeMeeting = 0;
        int i=0,j=0;
        while(i<intervals.length && j<intervals.length){
            if(start[i]<end[j]){
                activeMeeting++;
                i++;
            }else{
                activeMeeting--;
                j++;
            }
            rooms = Math.max(rooms,activeMeeting);
        }
        return rooms;
    }
    //按照 开始时间 对会议进行排序。
    //
    //初始化一个新的 最小堆，将第一个会议的结束时间加入到堆中。我们只需要记录会议的结束时间，告诉我们什么时候房间会空。
    //
    //对每个会议，检查堆的最小元素（即堆顶部的房间）是否空闲。
    //
    //若房间空闲，则从堆顶拿出该元素，将其改为我们处理的会议的结束时间，加回到堆中。
    //若房间不空闲。开新房间，并加入到堆中。
    //处理完所有会议后，堆的大小即为开的房间数量。这就是容纳这些会议需要的最小房间数。
    //

    public int minMeetingRooms2(int[][] intervals) {
        // Check for the base case. If there are no intervals, return 0
        if (intervals.length == 0) {
            return 0;
        }
        // Min heap
        PriorityQueue<Integer> allocator = new PriorityQueue<Integer>(intervals.length,
                        new Comparator<Integer>() {
                            public int compare(Integer a, Integer b) {
                                return a - b;
                            }
                        });
        // Sort the intervals by start time
        Arrays.sort(
                intervals,
                new Comparator<int[]>() {
                    public int compare(final int[] a, final int[] b) {
                        return a[0] - b[0];
                    }
                });
        // Add the first meeting
        allocator.add(intervals[0][1]);

        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            // If the room due to free up the earliest is free, assign that room to this meeting.
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }

            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with updated end time.
            allocator.add(intervals[i][1]);
        }

        // The size of the heap tells us the minimum rooms required for all the meetings.
        return allocator.size();
    }
}


