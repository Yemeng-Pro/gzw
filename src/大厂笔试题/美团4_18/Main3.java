package 大厂笔试题.美团4_18;

import java.util.*;

/**
 * @author shkstart
 * @create 2021-04-17 22:26
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();//操作数
        List<List<Integer>> list = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String str = in.nextLine();
            String[] split = str.split(" ");
            int a = Integer.parseInt(split[0]);
            if (a == 1) {
                int b = Integer.parseInt(split[1]);
                String c = split[2];
                if (map.containsKey(c)) {
                    map.get(c).add(b);
                } else {
                    List<Integer> arraylist = new ArrayList<>();
                    arraylist.add(b);
                    map.put(c, arraylist);
                    list.add(arraylist);
                }
            }else {
                String b = split[1];
                String c = split[2];
                List<Integer> b_list = map.get(b);
                List<Integer> c_list = map.get(c);

                int index_b = 0;
                int index_c = 0;
                for(int j = 0; j < list.size(); j++){
                    if(list.get(j) == b_list) index_b = j;
                    if(list.get(j) == c_list) index_c = j;
                }
                list.remove(index_b);
                list.add(index_b, c_list);
                list.remove(index_c);
                list.add(index_c, b_list);
            }
        }
        for(List<Integer> list1 : list){
            for(int num : list1){
                System.out.print(num + " ");
            }
        }


    }
}
