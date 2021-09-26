package 大厂笔试题.jingdong;

import java.util.*;
import java.util.zip.DeflaterInputStream;

public class Main4 {
    private static int active = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        List<Integer>[] dependence = new List[n];
        boolean[] isActive = new boolean[n];
        for (int i = 0; i < n; i++) {
            int nums = in.nextInt();
            List<Integer> depended = new ArrayList<>();
            for (int j = 0; j < nums; j++) {
                int pid = in.nextInt();
                depended.add(pid);
            }
            dependence[i] = depended;
        }

        for (int i = 0; i < q; i++) {
            int action = in.nextInt();
            int Id = in.nextInt();
            if (action == 1) {
                int add = iAction(Id, dependence, isActive);
                int result = add+active;
                active = active+add;
                System.out.println(result);
            } else if (action == 0) {
                int de = dAction(Id, dependence, isActive);
                int result = active-de;
                System.out.println(result);
            }


        }
    }

    private static int iAction(int Id, List<Integer>[] dependence, boolean[] isActive){
        int result = 0;
        List<Integer> depended = dependence[Id - 1];
        Queue<Integer> queue = new LinkedList();
        for (Integer id : depended) {
            isActive[id-1] = true;
            queue.add(id);
            result++;
        }
        while (!queue.isEmpty()){
            int id = queue.poll();
            List<Integer> temp = dependence[id - 1];
            if (temp.size() == 0) {
                result++;
                isActive[id-1] = true;
            }
            for (Integer addid : temp) {
                queue.add(addid);
                result++;
                isActive[addid-1] = true;
            }

        }
        return result;
    }

    private static int dAction(int Id, List<Integer>[] dependence,boolean[] isActive){
        int result = 0;
        isActive[Id-1] = false;
        result++;

        for (int i = 0; i < dependence.length; i++) {
            List<Integer> temp = dependence[i];
            for (int delid : temp) {
                if (delid == Id) {
                    if (isActive[i]){
                        isActive[i] = false;
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
