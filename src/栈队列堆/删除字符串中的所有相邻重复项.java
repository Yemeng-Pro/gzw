package 栈队列堆;

import java.util.Stack;

public class 删除字符串中的所有相邻重复项 {
    public String removeDuplicates(String s) {
        StringBuilder str = new StringBuilder();
        char[] chars = s.toCharArray();
        int top = -1;//定义一个指针指向栈顶元素
        for (int i = 0; i < chars.length; i++) {
            if (top >= 0 && str.charAt(top) == chars[i]) {
                str.deleteCharAt(top);
                top--;
            } else {
                str.append(chars[i]);
                top++;
            }
        }
        return String.valueOf(str);
    }
}
