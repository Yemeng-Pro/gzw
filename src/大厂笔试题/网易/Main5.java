package 大厂笔试题.网易;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        //获取输入
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
//         String[][] array = new String[n][n];
        List<String[]> list = new ArrayList<>();

        for(int i = 0;i < n;i++){
            String[] temp = in.nextLine().split(" ");
            list.add(temp);
        }
        int m = list.get(0).length;
//        System.out.println(m);
        String[][] array = new String[n][m];
        for(int i = 0; i < n; i++){
            array[i] = list.get(i);
//            String[] temp = list.get(i);
//            for(int j = 0; j < m; j++){
//                array[i][j] = temp[j];
//            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(array[i]));

        }
//        //遍历每一个节点
//        int result = Integer.MIN_VALUE;
//        for(int i = 0;i < n;i++){
//            for(int j = 0; j < m; j++){
//                if("0".equals(array[i][j])){
//                    int temp2 = dfs(array,i,j,n);
////                    System.out.println(temp2);
//                    result = Math.max(result,temp2);
//                }
//            }
//        }
//        System.out.println(result);
    }

    private static int dfs(String [][] array,int x,int y,int n){
        int result = 0;
        //向上搜索敌人
        for(int i = x-1; i >= 0 ;i--){
            if(array[i][y].equals("W")){
                break;
            }
            if(array[i][y].equals("E")){
                result++;
            }
        }
        //向下搜索敌人
        for(int i = x+1; i < n; i++){
            if(array[i][y].equals("W")){
                break;
            }
            if(array[i][y].equals("E")){
                result++;
            }
        }
        //向左搜索敌人
        for(int j = y-1; j >= 0; j--){
            if(array[x][j].equals("W")){
                break;
            }
            if(array[x][j].equals("E")){
                result++;
            }
        }
        //向右搜索敌人
        for(int j = y+1; j < n; j++){
            if(array[x][j].equals("W")){
                break;
            }
            if(array[x][j].equals("E")){
                result++;
            }
        }
        return result;
    }
}
