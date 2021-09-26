package 纯编程题;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import java.sql.Ref;
import java.util.Stack;

public class 验证回文串 {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j){
            if (!isAlpha(s.charAt(i))){
                i++;
                continue;
            }
            if (!isAlpha(s.charAt(j))) {
                j--;
                continue;
            }
            if (toLower(s.charAt(i)) != toLower(s.charAt(j))) {
                return false;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }


    //判断是否是有效字符
    private boolean isAlpha(char sb) {
        if (sb>='a' && sb<='z') return true;
        if (sb>='A' && sb<='Z') return true;
        if (sb>='0' && sb<='9') return true;
        return false;
    }
    //字符串统一转小写
    // ⼤写转⼩写
    private char toLower(char c) {
        if (c >= 'a' && c <= 'z') return c;
        if (c >= '0' && c <= '9') return c;
        //⼤写A~Z 65~90，⼩写a~z 97~122
        return (char)((int)c+32);
    }

    public boolean isPalindrome2(String s){
        //出栈
        Stack<Character> stack=new Stack<>();
        StringBuilder str=new StringBuilder(s.length());

        for(char s2:s.toLowerCase().toCharArray()){
            if ((s2 >= '0' && s2 <= '9') || (s2 >= 'a' && s2 <= 'z')) {
                str.append(s2);
                stack.push(s2);
            }
        }
        for(char s2: str.toString().toCharArray()){
            if (s2!=stack.pop())
                return false;
        }
        return true;
    }

}
