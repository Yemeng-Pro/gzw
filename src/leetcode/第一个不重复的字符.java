package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shkstart
 * @create 2021-03-29 22:36
 */
public class 第一个不重复的字符 {
    private int[] cnts = new int[128];
    private Queue<Character> queue = new LinkedList<>();
    public char firstUniqChar(String s) {
        char[] a = s.toCharArray();
        for (char cha : a) {
            insert(cha);
        }
        return queue.isEmpty() ? ' ' : queue.peek();
    }

    private void insert(char ch) {
        cnts[ch]++;
        queue.add(ch);
        while (!queue.isEmpty() && cnts[queue.peek()] > 1) {
            queue.poll();
        }
    }

}
