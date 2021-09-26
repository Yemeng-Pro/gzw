package 大厂笔试题.美团4_18;

import java.util.*;

/**
 * @author shkstart
 * @create 2021-04-17 22:26
 */
public class Main {
    public static List<String> res  = new ArrayList<>();
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        for (int i = 0; i < N; i++) {
            String temp = in.nextLine();
            if ("query".equals(temp)) {
                //排序操作,根据value进行排序
                List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
                list.sort(((Map.Entry<Integer, Integer> o1,Map.Entry<Integer, Integer> o2)->o2.getValue() - o1.getValue())
//                    @Override
//                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                        return o2.getValue() - o1.getValue();
//                    }
                );
                if (map.size() >= 10) {
                    int num = 1;
                    String out = "";
                    for (Map.Entry<Integer, Integer> entry : list) {
                        if (num <= 10) {
                            out = out + entry.getKey() + " ";
                            num++;
                        }
                    }
                    res.add(out);

                } else if (map.size() == 0) {
                    res.add("null");
                }else{
                    String out = "";
                    for (Map.Entry<Integer, Integer> entry : list) {
                        out = out + entry.getKey() + " ";
                    }
                    res.add(out);
                }
            }else{//添加新闻热度
                String[] append = temp.split(" ");
                int xinwen = Integer.parseInt(append[1]);
                int redu = Integer.parseInt(append[2]);
                if (map.containsKey(xinwen)){
                    int tempredu = map.get(xinwen);
                    redu += tempredu;
                    map.put(xinwen, redu);
                }else{
                    map.put(xinwen, redu);
                }

            }
        }
        for (String str : res) {
            System.out.println(str);
        }
    }
}
