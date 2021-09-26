package 大厂笔试题.阿里笔试;

import java.math.BigInteger;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        long mod = 1000000007;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }

        int len = n-1;
        while (len > 0) {
            for (int i = 0; i < len; i++) {
                array[i] = (array[i + 1] - array[i] + mod)%mod;
            }
            len--;
        }
        System.out.println((array[0]+mod)%mod);

    }


//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int N = Integer.parseInt(scanner.nextLine());
//        BigInteger bigInteger1 = new BigInteger("1000000007");
//        BigInteger[] nums = new BigInteger[N];
//        String next = scanner.nextLine();
//        String[] s = next.split(" ");
//        for(int i = 0 ; i < N ; i++){
//            BigInteger bigInteger = new BigInteger(s[i]);
//            nums[i] = bigInteger;
//        }
//        for(int j = nums.length - 1; j > 0 ; j--){
//            for(int k = 0 ; k < j ; k++){
//                nums[k] = (nums[k + 1].subtract(nums[k])).mod(bigInteger1);
//            }
//        }
//        System.out.println(nums[0]);
//    }


}
