import apple.laf.JRSUIUtils;

import java.util.*;

public class Mian {
    public int GetMinTimeCost (TreeNode root, int failId, int[] timeCost) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        TreeNode cur;
        queue1.offer(root);
        int floor = 0;

        int floorCost = Integer.MAX_VALUE;
        int ans = 0;

        while (!(queue1.isEmpty() && queue2.isEmpty())) {
            while (!queue1.isEmpty()) {
                cur = queue1.poll();
                map.put(cur.val, floor);
                floorCost = Math.min(floorCost, timeCost[cur.val]);
                if (cur.left != null) {
                    queue2.offer(cur.left);

                }
                if (cur.right != null) {
                    queue2.offer(cur.right);
                }
            }
            queue1 = queue2;
            queue2 = new LinkedList<>();
            list.add(floorCost);
            floor++;
            floorCost = Integer.MAX_VALUE;
        }

        int floorIndex =  map.get(failId);
        for (int i = floorIndex; i < floor-1; i++) {
            ans += list.get(i);
        }
        return ans;
    }
}
