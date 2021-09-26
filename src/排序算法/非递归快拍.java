package 排序算法;

/**
 * @author shkstart
 * @create 2021-06-04 20:40
 */


import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;


public class 非递归快拍 {

    @Test
    public void test(){
        int[] array = {6,5,4,3,2,1};
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));

    }
    public void quickSort(int[] a,int low,int high){
        int pivot;//定义分区点
        if(low>=high) return;

        Stack<Integer> stack = new Stack<>();
        stack.push(low);
        stack.push(high);

        while(!stack.empty()){
            high = stack.pop();
            low = stack.pop();

            pivot = partition(a,low,high);

            if(low<pivot-1){
                stack.push(low);
                stack.push(pivot-1);
            }

            if(pivot + 1<high){
                stack.push(pivot+1);
                stack.push(high);
            }
        }

    }

    //快排分区函数
    private int partition(int[] a,int low, int high){

        if(a[low]>a[high]){
            swap(a,low,high);
        }

        if(a[(low+high)/2] > a[high]){
            swap(a,(low+high)/2,high);
        }

        if(a[(low+high)/2] > a[low]){
            swap(a,(low+high)/2,low);
        }


        int pivotkey = a[low];
        while(low<high){
            while(low < high && a[high] >= pivotkey){
                high--;
            }
            a[low] = a[high];
            while(low < high && a[low] <= pivotkey){
                low++;
            }
            a[high] = a[low];
        }

        a[low] = pivotkey;
        return low;
    }

    //swap
    private void swap(int[] a,int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }

}
