package BFS和DFS;

import org.junit.Test;

import java.util.*;

public class 打开转盘锁 {
    public static void main(String[] args) {
        char[] str = new char[]{' ', '1', '2'};
        String a = new String(str);
        String b = "12";

        System.out.println(a.equals(b));
        System.out.println(a);
        System.out.println(b);
    }
    public int openLock(String[] deadends, String target) {
        HashSet<String> deadset = new HashSet();
        for (String d: deadends) {
            deadset.add(d);
        }
        if (deadset.contains("0000")) return -1;
        Queue<String> queue = new LinkedList();
        Set<String> visited = new HashSet();
        queue.offer("0000");
        visited.add("0000");
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int k = 0;
            while (k < size) {
                String node = queue.poll();
                k++;
                if (node.equals(target)) {
                    return depth;
                }
                List<String> newnodes = genNewNode(node);
                for (String newnode : newnodes) {
                    if (visited.contains(newnode)
                            || deadset.contains(newnode)) {
                        continue;
                    }
                    queue.add(newnode);
                    visited.add(newnode);
                }
            }
            depth++;
        }
        return -1;
    }


    private List<String> genNewNode(String node) {
        List<String> newnodes = new ArrayList<>();
        int[] change = {-1, 1};
        for (int i = 0; i < 4; ++i) {
            for (int k = 0; k < 2; ++k) {
                char[] newNode = new char[4];
                for (int j = 0; j < i; ++j) {
                    newNode[j] = node.charAt(j);
                }
                for (int j = i+1; j < 4; ++j) {
                    newNode[j] = node.charAt(j);
                }
                String newC = (((node.charAt(i)-'0') + change[k] + 10) % 10) + "";
                newNode[i] = newC.charAt(0);
                newnodes.add(new String(newNode));
            }
        }
        return newnodes;
    }
}
