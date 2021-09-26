package 大厂笔试题.华为笔试;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;

/**
 * @author shkstart
 * @create 2021-04-14 19:56
 */
public class Main2 {
    private static BitSet canput;
    private static List<Integer> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        canput = new BitSet(n);//用一个bit数组来判断当前信号的使用情况，0代表未使用，1代表已经使用过，已经提交过的就不再提交
        for (int i = 0; i < n; i++) {
            //若发生AEB，则提交AEB范围内的数
            if (isAEB(arr, i)) {
                if (i - 5 < 0 && i + 7 > arr.length - 1) {
                    for (int k : arr) {
                        res.add(k);
                    }
                } else if (i - 5 < 0 && i + 7 <= arr.length - 1) {
                    for (int j = 0; j <= i + 7; j++) {
                        if (!canput.get(j)) {
                            res.add(arr[j]);
                            canput.set(j);
                        }
                    }
                } else {
                    for (int j = i-5; j < i+7; j++) {
                        if (!canput.get(j)) {
                            res.add(arr[j]);
                            canput.set(j);
                        }
                    }
                }
            } else if (i % 60 == 1) { //就算没有发生AEB，也要判断周期提交
                if (i > 60) {
                    res.add(arr[i-60]);
                    canput.set(i);
                }
                res.add(arr[i]);
                canput.set(i);
            }

        }
        for (int i = 0; i < res.size(); i++) {
            if (i == res.size() - 1) {
                System.out.print(res.get(i)+"");
            } else {
                System.out.print(res.get(i)+",");
            }
        }


    }
    //判断当前是否发生AEB
    private static boolean isAEB(int[] arr, int i) {
        if (i + 3 < arr.length - 1 && i >= 1) {
            if (arr[i] + 9 < arr[i - 1] && arr[i + 1] + 9 < arr[i] && arr[i + 2] + 9 < arr[i + 1] && arr[i + 3] + 9 < arr[i + 2]) {
                return true;
            }
        }
        return false;
    }
}
