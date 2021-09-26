package 排序;

import java.util.Arrays;

public class 判断能否形成等差数列 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int dif = arr[1] - arr[0];
        for(int i = 2;i<arr.length;i++){
            if((arr[i] - arr[i-1]) != dif){
                return false;
            }
        }
        return true;
    }
}
