package leetcode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author shkstart
 * @create 2021-04-12 11:10
 */
public class 美团第三题 {
    public static void main(String[] args) throws IOException {

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//        int T = Integer.parseInt(reader.readLine());
//        for (int i = 0; i < T; i++) {
//            int N = Integer.parseInt(reader.readLine());
//            String tables = reader.readLine();
//            int M = Integer.parseInt(reader.readLine());
//            String enters = reader.readLine();
//
//            int[] res = solve(tables, enters);
//            for (int r : res) {
//                writer.write(Integer.toString(r));
//                writer.newLine();
//            }
//        }
//        writer.flush();
        Scanner reader = new Scanner(System.in);
        int T = reader.nextInt();
        reader.nextLine();
        for (int i = 0; i < T; i++) {
            String N =  reader.nextLine();
            String tables = reader.nextLine();
            String M =  reader.nextLine();
            String enters = reader.nextLine();
            int[] res = solve(tables, enters);
            for (int r : res) {
                System.out.println(Integer.toString(r));
            }
        }
    }

    private static int[] solve(String tables, String enters) {
        List<PriorityQueue<Integer>> pqs = new ArrayList<>(3);
        pqs.add(new PriorityQueue<>());
        pqs.add(new PriorityQueue<>());
        pqs.add(new PriorityQueue<>());
        for (int i = 0; i < tables.length(); i++) {
            pqs.get(tables.charAt(i) - '0').add(i);
        }
        int[] res = new int[enters.length()];
        for (int i = 0; i < enters.length(); i++) {
            int table;
            if (enters.charAt(i) == 'M') {
                if (pqs.get(1).isEmpty()) {
                    table = pqs.get(0).poll();
                    pqs.get(1).add(table);
                } else {
                    table = pqs.get(1).poll();
                    pqs.get(2).add(table);
                }
            } else {
                if (!pqs.get(0).isEmpty()) {
                    table = pqs.get(0).poll();
                    pqs.get(1).add(table);
                } else {
                    table = pqs.get(1).poll();
                    pqs.get(2).add(table);
                }
            }
            res[i] = table + 1;
        }

        return res;
    }
}