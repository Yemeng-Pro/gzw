package 大厂笔试题.网易互联网;

import java.util.Scanner;

public class Main3 {
    private static int result = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] num = input.split(" ");
        String str = num[0];
        int m = Integer.parseInt(num[1]);
        dfs(str, m, 1, false,1);
        System.out.println(result);
    }

    private static void dfs(String str, int m,int index,boolean used,int step) {
        if (index == str.length() - 1) {
            char cur = str.charAt(index);
            char pre = str.charAt(index - 1);
            int move1 = Math.abs(cur - pre);
            int move2 = 26 - Math.abs(cur - pre);
            int move = Math.min(move1, move2);
            step += move;
            step++;
            result = Math.min(result, step);
            return;
        }
        if (used) {
            if (m > 0) {
                dfs(str, m - 1, index + 1, true, step + 2);
                return;
            } else {
                used = false;
            }
        }
        //不用魔法按键
        //先移动到指定位置,
        char cur = str.charAt(index);
        char pre = str.charAt(index - 1);
        int move1 = Math.abs(cur - pre);
        int move2 = 26 - Math.abs(cur - pre);
        int move = Math.min(move1, move2);
        int newstep = step;
        newstep += move;
        //再按确定键
        newstep++;
        dfs(str, m, index + 1, used, newstep);
        //使用魔法按键
        dfs(str, m - 1, index + 1, true, step + 2);
    }
}
