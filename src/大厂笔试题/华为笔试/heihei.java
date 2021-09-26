package 大厂笔试题.华为笔试;


import org.junit.Test;

/**
 * @author shkstart
 * @create 2021-04-14 22:16
 */
public class heihei {
    @Test
    public void test() {
        int x = 10;
        System.out.println(isPalindrome(x));
    }
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        char[] b = Integer.toString(x).toCharArray();
        if (b.length == 1) {
            return true;
        } else if (b.length % 2 == 0) {
            int i = (b.length-1)/2;
            int j = i + 1;
            while (i >= 0 && j < b.length) {
                if (b[i] != b[j]) {
                    return false;
                }
                i--;
                j++;
            }
            return true;
        } else {
            int i = b.length / 2;
            int j = i - 1;
            int k = i + 1;
            while (j >= 0 && k < b.length) {
                if (b[j] != b[k]) {
                    return false;
                }
                j--;
                k++;
            }
            return true;
        }



    }
}
