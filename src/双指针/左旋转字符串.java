package 双指针;

/**
 * @author Yemeng
 * @create 2020-12-17-14:21
 */
public class 左旋转字符串 {
    /**
     * 题目描述：
     * 将字符串 S 从第 K 位置分隔成两个子字符串，并交换这两个子字符串的位置。
     * Input:
     * S="abcXYZdef"
     * K=3
     * Output:
     * "XYZdefabc"
     *
     * 解题思路：
     * 先将“abc”和“XYZdef"分别翻转，得到”cbafedZYX“，然后再把整个字符串翻转得到”XYZdefabc"
     *
     */
     private void reverse(char[] chars, int i, int j) {
         while (i < j) {
             swap(chars, i++, j--);
         }
     }
     private void swap(char[] chars, int i, int j) {
         char t = chars[i];
         chars[i] = chars[j];
         chars[j] = t;
     }

    public String LeftRotateString(String str, int n) {
        if (n >= str.length()) {
            return str;
        }
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars,0, chars.length - 1);
        String s = new String(chars);
        return s;
    }

}
