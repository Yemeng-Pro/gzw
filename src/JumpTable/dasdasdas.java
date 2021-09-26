package JumpTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-05-27 15:30
 */
public class dasdasdas {
    public static void main(String[] args) {
        Integer[] a1 = {1,2,3,4,5};
        Arrays.sort(a1, (o1, o2) -> Integer.compare(o2, o1));
        List list = new ArrayList();
        list.add(1);
        Integer a = 2;
        Integer b= 3;
        int c = 3;
        int d = 5;
        System.out.println(a.equals(b));
        System.out.println(Integer.compare(c,d));



    }

    public enum status {
        BUSYL,
        FREE,
        HAHA;
    }
}
