package 大厂笔试题.美团4_18;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author shkstart
 * @create 2021-04-18 16:11
 */
public class test {
    public static void main(String[] args) {
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(2);
        temp.add(3);
        temp.add(4);
        List<List<Integer>> list = new ArrayList<>();
        list.add(temp);
        temp.add(10);

        List<student> list2 = new ArrayList<>();
        student shabi = new student("象拔蚌", 18);
        list2.add(shabi);
        shabi.setName("猪皮");


        for (student str : list2) {
            System.out.println(str.getName());
        }
        for (List<Integer> heihei : list) {
            for (Integer a : heihei) {
                System.out.println(a);
            }
        }


    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] nums, int k) {
        if (k > nums.length || k <= 0)
            return new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            maxHeap.add(num);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        return new ArrayList<>(maxHeap);
    }
}

class student {
    String name;
    int age;

    public student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
