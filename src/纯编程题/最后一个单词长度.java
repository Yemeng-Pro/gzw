package 纯编程题;

public class 最后一个单词长度 {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int i = n - 1;
        while (i >= 0 && s.charAt(i) == ' '){
            i--;
        }
        if (i<0)return 0;
        int res = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            res++;
            i--;
        }
        return res;
    }
}
