package 回溯;

import java.util.ArrayList;
import java.util.List;

public class bug {
    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        a.add(1);
        res.add(new ArrayList<>(a));
        System.out.println(res.toString());
    }

}
