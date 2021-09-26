package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shkstart
 * @create 2021-04-06 9:44
 */
public class test1 {
    public static void main(String[] args) {
//        int[] a = {4,3,2,7,8,2,3,1};
//        test1 test1 = new test1();
//        test1.findDisappearedNumbers(a);
        Map<String,String> map = new HashMap<>();
        String s1 = "a";
        String s2 = "b";
        map.put(s1,s2);
        System.out.println(map.get(s2));
    }
    @Test
    public void test(){
        int[] a = {4,3,2,7,8,2,3,1};
        findDisappearedNumbers(a);


    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        // int[] x = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if(nums[Math.abs(nums[i] - 1)]>0){
                nums[Math.abs(nums[i] - 1)] *= (-1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;

    }

    private int binarySearch(int[] nums, int K) {
        int l = 0, h = nums.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= K)
                h = m;
            else
                l = m + 1;
        }
        return l;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int a = nums1.length;
        int b = nums2.length;
        int sum = a+b;
        List<Integer> res = new ArrayList<>();
        int j = 0, k = 0;
        for(int i = 0;i<sum;i++){
            while(j<a||k<b){
                if(j>=a){
                    res.add(nums2[k++]);
                }else if(k>=a){
                    res.add(nums1[j++]);
                }else if(nums1[i]<=nums2[j]){
                    res.add(nums1[i++]);
                }else if(nums1[i]>nums2[j]){
                    res.add(nums2[j++]);
                }
            }

        }
        int mid = sum/2;

        return (double) res.get(mid);


    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0;
        for(int j = 0; j < s.length(); j++) {
            if(dic.containsKey(s.charAt(j)))
                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
            dic.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }
    public double[] dicesProbability(int n) {
        int[][] dp=new int[n+1][6*n+1];   //横轴为骰子数、纵轴为n个筛子的和
        double[] ans=new double[5*n+1];   //骰子点数总和情况
        double all=Math.pow(6,n);		  //骰子点数情况
        for(int i=1;i<=6;i++)
            dp[1][i]=1;
        for(int i=1;i<=n;i++)   //行
            for(int j=i;j<=6*n;j++){  //列
                for(int k=1;k<=6;k++){
                    dp[i][j] += j>=k ? dp[i-1][j-k] : 0;  //这里注意，j-k要大于0
                    if(i==n)
                        ans[j-i]=dp[i][j]/all;
                }
            }

        return ans;
    }

    public int[] multiply(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        for (int i = 0, product = 1; i < n; product *= A[i], i++)       /* 从左往右累乘 */
            B[i] = product;
        for (int i = n - 1, product = 1; i >= 0; product *= A[i], i--)  /* 从右往左累乘 */
            B[i] *= product;
        return B;
    }
}
