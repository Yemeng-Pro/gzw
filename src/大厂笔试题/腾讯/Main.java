package 大厂笔试题.腾讯;


import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int bossn = in.nextInt();
        int[] happy = new int[n+1];
        for (int i = 1; i < n; i++) {
            happy[i] = in.nextInt();
        }
        Node boss = new Node(bossn);
        Map<Integer, Node> hashmap = new HashMap<>();
        hashmap.put(bossn, new Node(happy[bossn], new ArrayList<>()));
        for (int i = 0; i < n - 1; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            if (hashmap.containsKey(a)) {
                Node bossorstaff = hashmap.get(happy[a]);
                bossorstaff.children.add(new Node(b,new ArrayList<Node>()));
                hashmap.put(a,bossorstaff);
            }else{
                ArrayList<Node> child = new ArrayList<Node>();
                child.add(new Node(b));
                hashmap.put(a,new Node(happy[a],child));
            }
        }
    }
    //N叉树打家劫舍
    private int[] postorder(Node root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < root.children.size(); i++) {
            int[] temp = postorder(root.children.get(i));
            res.add(temp);
        }
        int[] money = new int[2];
        int stay = 0;
        for (int i = 0; i < root.children.size(); i++) {
            int[] temp = res.get(i);
            stay += Math.max(temp[0],temp[1]);
        }
        int go = root.val;
        for (int i = 0; i < root.children.size(); i++) {
            int[] temp = res.get(i);
            go += temp[0];
        }
        money[0] = stay;
        money[1] = go;
        return money;
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};