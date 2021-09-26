package leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author shkstart
 * @create 2021-04-08 20:13
 */
public class 美团第一题 {
    public static void main(String[] args) {
        //读取数据
        Scanner input = new Scanner(System.in);
        String[] s = input.nextLine().split(" ");
        int n = Integer.parseInt(s[0]); //考试人数
        int x=Integer.parseInt(s[1]);   //人数区间下限
        int y=Integer.parseInt(s[2]);   //人数区间上限
        int[] arr = new int[n]; //输入分数
        s = input.nextLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(arr);
        //x,y应该满足的条件：n>=2x&&n<=2y
        if (n<2*x||n>2*y){
            System.out.println(-1);
            return;
        }

        //二分排序
        int left = x;
        int right = y+1;
        while (left < right) {
            int mid = (left + right) / 2; //mid作为分区点，左边的一定在[x,y]中间
            if (n-mid>=x||n-mid<=y){    //右边的区间也得满足[x,y]
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(arr[left-1]);
    }
}
