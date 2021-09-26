package 纯编程题;

import org.junit.Test;

public class 翻转单次顺序 {
    //两次翻转，先翻转句子，再翻转单词
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int n = trim(chars);
        int l = 0;
        for (int i = 0; i <= n; i++) {
            if (i == n||chars[i] == ' '){
                reverse(chars, l, i - 1);
                l = i + 1;
            }
        }
        reverse(chars,0,n-1);
        char[] newChar = new char[n];
        for (int i = 0; i < n; i++) {
            newChar[i] = chars[i];
        }
        return String.valueOf(newChar);
    }

    public void reverse(char[] s,int i,int j){
        while(i < j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    // 原地删除前置空格和后置空格，以及内部多于的空格，返回新字符串⻓度
    private int trim(char[] str) {
        int i = 0;
        int n = str.length;
        int k = 0; //记录删除多余空格之后的数组⻓度
        while (i < n && str[i] == ' ') {
            i++;
        }
        while (i < n) {
            if (str[i] == ' ') { // 删除内部多于的空格和末尾空格
                if (i+1 < n && str[i+1] != ' ') {
                    str[k++] = ' ';
                }
            } else {
                str[k++] = str[i];
            }
            i++;
        }
        return k;
    }


}
