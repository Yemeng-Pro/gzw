package 大厂笔试题.小红书;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //数据录入
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] RC = input.split(" ");
        int R = Integer.parseInt(RC[0]);
        int C = Integer.parseInt(RC[1]);
        char[][] matrix = new char[R][C];
        for (int i = 0; i < R; i++) {
            String temp = in.nextLine();
            char[] chars = temp.toCharArray();
            matrix[i] = chars;
        }
        int n = Integer.parseInt(in.nextLine());
        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String caozuo = in.nextLine();
            String[] caozuo2 = caozuo.split("  ");
            list.add(caozuo2);
        }
        //开始计算
        int[] result = new int[2];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 'R') {
                    result = func(matrix, i, j, list);
                }
            }
        }
        System.out.println(result[0] + " " + result[1]);
    }

    private static int[] func(char[][] matrix, int i, int j,List<String[]> list) {
        int beginR = i;
        int beginC = j;
        int curR = i;
        int curC = j;
        String pre = "up";
        String statenow = null;
        for (int k = 0; k < list.size(); k++) {
            String[] caozuo = list.get(k);
            if (caozuo[0].equals("Turn")) {
                String leftorright = caozuo[1];
                if (pre == "up") {
                    if (leftorright == "left") {
                        statenow = "left";
                        pre = "left";
                    } else if (leftorright == "right") {
                        statenow = "right";
                        pre = "right";
                    }
                } else if (pre == "down") {
                    if (leftorright == "right") {
                        statenow = "left";
                        pre = "left";
                    } else if (leftorright == "left") {
                        statenow = "right";
                        pre = "right";
                    }
                } else if (pre == "left") {
                    if (leftorright == "left") {
                        statenow = "down";
                        pre = "down";
                    } else if (leftorright == "right") {
                        statenow = "up";
                        pre = "up";
                    }
                } else {
                    if (leftorright == "right") {
                        statenow = "down";
                        pre = "down";
                    } else if (leftorright == "left") {
                        statenow = "up";
                        pre = "up";
                    }
                }
            } else if ("Forward".equals(caozuo[0])){
                int stepSum = Integer.parseInt(caozuo[1]);
                for (int l = 0; l < stepSum; l++) {
                    if (statenow == "up") {
                        if (curR > 0 && curR < matrix.length-1 && matrix[curR][curC] != 'O') {
                            curR--;
                        } else if (matrix[curR][curC] != 'O') {
                            curR++;
                            break;
                        }
                    }else if(statenow == "down"){
                        if (curR > 0 && curR < matrix.length-1 && matrix[curR][curC] != 'O') {
                            curR++;
                        } else if (matrix[curR][curC] != 'O') {
                            curR--;
                            break;
                        }
                    } else if (statenow == "left") {
                        if (curC > 0 && curC < matrix[0].length-1 && matrix[curR][curC] != 'O') {
                            curC--;
                        } else if (matrix[curR][curC] != 'O') {
                            curC++;
                            break;
                        }
                    } else {
                        if (curC > 0 && curC < matrix[0].length-1 && matrix[curR][curC] != 'O') {
                            curC++;
                        } else if (matrix[curR][curC] != 'O') {
                            curC--;
                            break;
                        }
                    }
                }
            }
        }
        return new int[]{curR - beginR, curC - beginC};
    }
}
