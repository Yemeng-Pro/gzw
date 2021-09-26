package 大厂笔试题.笔试360;

import java.util.Scanner;

/**
 * @author shkstart
 * @create 2021-04-17 16:11
 */
public class Main2 {
    private static int res;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        char[] str = string.toCharArray();
        int numofb = 0;
        for (int i = string.length()-1; i >= 0; i--) {
            if (str[i] == 'b') {
                numofb += 1;
            } else if (str[i] == 'a') {
                res += numofb;
                numofb *= 2;
                numofb %= 1000000007;
            }

        }
        System.out.println(res);

//        Scanner in = new Scanner(System.in);
//        String string = in.nextLine();
//        char[] str = string.toCharArray();
//        int index = 0;
//        while(index < str.length - 1){
//            if (str[index] == 'a' && str[index+1] == 'b') {
//                string = string.substring(0,index) + "bba" + string.substring(index+2,string.length());
//                str = string.toCharArray();
//                res++;
//                res = res%1000000007;
//                index = 0;
//            }
//            index++;
//        }
//        System.out.println(res);
    }
}
