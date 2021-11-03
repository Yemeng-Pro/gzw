package 大厂笔试题.B站;

public class Main {

    public static void main(String[] args) {
        String a = "abcdefg";
        String b = "bcd";
        System.out.println(strstr(a, b));
    }
    static int strstr(String a, String b) {
        return a.indexOf(b);
    }
}
