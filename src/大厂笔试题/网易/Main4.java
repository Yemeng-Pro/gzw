package 大厂笔试题.网易;


import java.util.HashMap;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int L1 = in.nextInt();
        int L2 = in.nextInt();
        int M = in.nextInt();
        in.nextLine();
        String board = in.nextLine();
        String hand = in.nextLine();
        System.out.println(findMinStep(board,hand,M));
    }

    public static int findMinStep(String board, String hand, int M) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < hand.length(); i++)
            map.put(hand.charAt(i), map.getOrDefault(hand.charAt(i), 0) + 1);
        for (int i = 0; i < board.length(); i++)
            if (!map.containsKey(board.charAt(i))) map.put(board.charAt(i), 0);
        return dfs(board, map,M);
    }

    public static int dfs(String board, HashMap<Character, Integer> map,int M) {
        if (board.length() == 0) return 0;
        StringBuilder sb = new StringBuilder(board);
        int res = 0;
        int i = 0;
        while (i < board.length()) {
            char c = board.charAt(i);
            int j = i + 1;
            while (j < board.length() && c == board.charAt(j)) j++;
            int need = M - (j - i);
            if (map.get(c) >= need) {
                need = Math.max(need, 0);
                map.put(c, map.get(c) - need);
                int tmp = dfs(sb.substring(0, i) + sb.substring(j), map, M);
                res = Math.max(res, M + tmp);
                map.put(c, map.get(c) + need);
            }
            i = j;
        }
        return res;
    }
}
