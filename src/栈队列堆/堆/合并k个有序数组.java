package 栈队列堆.堆;

import 排序.ListNode;

import java.util.PriorityQueue;

public class 合并k个有序数组 {
    public static class ArrayContainer{
        int[] arr;
        int index;
        public ArrayContainer(int[] arr, int index) {
            this.arr = arr;
            this.index = index;
        }
    }

    public static int[] mergeKSortedArray(int[][] arr){
        PriorityQueue<ArrayContainer> queue = new PriorityQueue<>((o1, o2)->(o1.arr[o1.index]-o2.arr[o2.index]));
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            queue.add(new ArrayContainer(arr[i], 0));
            total = total + arr[i].length;
        }
        int m=0;
        int result[] = new int[total];
        while(!queue.isEmpty()){
            ArrayContainer ac = queue.poll();
            result[m++]=ac.arr[ac.index];

            if(ac.index < ac.arr.length-1){
                queue.add(new ArrayContainer(ac.arr, ac.index+1));
            }
        }

        return result;
    }
}
