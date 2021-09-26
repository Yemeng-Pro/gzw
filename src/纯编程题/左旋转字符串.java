package 纯编程题;

public class 左旋转字符串 {
    //旋转
    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        reverse(chars, 0, len - 1);
        reverse(chars, 0, len - n - 1);
        reverse(chars, len - n, len - 1);
        return String.valueOf(chars);
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

    // 往左移动n位
    public String reverseLeftWords2(String s, int n) {
        char[] str = s.toCharArray();
        for (int i = 0; i < n; ++i) { // 移动n次,每次左移1位
            char tmp = str[0];
            for (int j = 1; j < str.length; ++j) {
                str[j-1] = str[j];
            }
            str[str.length-1] = tmp;
        }
        return new String(str);
    }

    // 往左移动n位
    public String reverseLeftWords3(String s, int n) {
        char[] tmp = new char[s.length()];
        // 数组分为[0~n~len),先把0~n-1放到tmp后⾯
        for (int i = 0; i < n; ++i) {
            tmp[i+(s.length()-n)] = s.charAt(i);
        }
        // 再把n~len-1放到tmp的前⾯
        for (int i = n; i < s.length(); i++) {
            tmp[i-n] = s.charAt(i);
        }
        return new String(tmp);
    }
}
