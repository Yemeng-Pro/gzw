package 大厂笔试题.腾讯;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Lenka
 * @create 2021-04-18 21:48
 */
public class Tecent3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[2*n];
        for (int i = 0; i < 2*n; i++) {
            str[i] = sc.next();
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(str[i].length()%2==1){
                res.add("NO");
            }
            else{
                if(isEqual(str[2*i],str[2*i+1])) res.add("YES");
                else{res.add("NO");}
            }
            i++;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(res.get(i));
        }
    }

    static boolean isEqual(String str1,String str2){
        if(str1.length()%2==1){
            return str1.equals(str2);
        }
        boolean flagS1 = isEqual(str1.substring(0,str1.length()/2-1),str2.substring(0,str1.length()/2-1)) && isEqual(str1.substring(str2.length()/2),str2.substring(str2.length()/2));
        boolean flagS2 = isEqual(str1.substring(0,str2.length()/2-1),str2.substring(str2.length()/2)) && isEqual(str1.substring(str1.length()/2),str2.substring(0,str1.length()/2-1));
        boolean flag = flagS1||flagS2;
        return flag;
    }
}
