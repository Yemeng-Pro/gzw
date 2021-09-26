package 纯编程题;

public class 反转字符串 {
    public void reverseString(char[] s) {
        int n = s.length;
        for (int i = 0; i < n/2; i++) {
            char temp = s[i];
            s[i] = s[n - i -1];
            s[n - i -1] = temp;
        }
    }
    public void reverseString2(char[] s) {
        int n = s.length;
        int i = 0;
        int j = n - 1;
        while(i < j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
