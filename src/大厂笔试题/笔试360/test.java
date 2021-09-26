package 大厂笔试题.笔试360;

/**
 * @author shkstart
 * @create 2021-04-17 16:25
 */
public class test {
    public static void main(String[] args) {
        String a = "12345";
//        System.out.println(a.substring(0,1));
        char[] b = a.toCharArray();
        for (char num : b) {
            System.out.println((int)num);
        }
    }
}
