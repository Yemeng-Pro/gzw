package leetcode;

import java.util.Scanner;

/**
 * @author shkstart
 * @create 2021-04-08 23:07
 */
public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String a = scanner.nextLine();
            System.out.println(a);
        }
//        int input = 0;
//        while(true){
//            if(scanner.hasNextInt()){
//                input = scanner.nextInt();
//                break;
//            }else{
//                System.out.println("请输入数字");
//                scanner.next();
//            }
//        }
//        System.out.println("输入的数字是："+input);



//        Scanner scan = new Scanner(System.in);
//        // 从键盘接收数据
//        // next方式接收字符串
//        System.out.println("next方式接收：");
//        // 判断是否还有输入
////        boolean hasnext = scan.hasNext();
////        System.out.println(hasnext);
//        if (scan.hasNext()) {
//            System.out.println("请输入");
//            Integer str1 = scan.nextInt();
//            Integer str2 = scan.nextInt();
//            System.out.println("输入的数据为：" + str1);
//            System.out.println("输入的数据为：" + str2);
//        }
//        scan.close();
//        Integer str1 = scan.nextInt();
//        Integer str2 = scan.nextInt();
//        System.out.println(str1 + str2);
//        Scanner scan = new Scanner(System.in);
//        String input;
//        input = scan.next();
////        scan.nextLine();
//        System.out.println(input);
//        input = scan.next();
//        System.out.println(input);
//        scan.close();
//        System.out.println(input.length());
    }
}
