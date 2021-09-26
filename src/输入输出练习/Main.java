package 输入输出练习;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String[] s = in.nextLine().split(" ");
            Long sum = 0L;
            for (int i = 0; i < s.length; i++) {
                sum += Long.valueOf(s[i]);
            }
            System.out.println(sum);
        }
    }
}

//import java.util.*;
//public class Main{
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//    }
//}