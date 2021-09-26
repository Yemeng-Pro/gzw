package 双指针;

/**
 * @author Yemeng
 * @create 2020-12-16-18:56
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 *
 * 解题思路：
 *
 *
 */
public class 和为s的连续正数序列 {

    /**
     * 枚举+数学优化
     * 剑指offer57.2
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> vec = new ArrayList<int[]>();
        int limit = (target - 1) / 2; // (target - 1) / 2 等效于 target / 2 下取整
        for (int x = 1; x <= limit; ++x) {
            long delta = 1 - 4 * (x - (long) x * x - 2 * target);
            if (delta < 0) {
                continue;
            }
            int delta_sqrt = (int) Math.sqrt(delta + 0.5);
            if ((long) delta_sqrt * delta_sqrt == delta && (delta_sqrt - 1) % 2 == 0) {
                int y = (-1 + delta_sqrt) / 2; // 另一个解(-1-delta_sqrt)/2必然小于0，不用考虑
                if (x < y) {
                    int[] res = new int[y - x + 1];
                    for (int i = x; i <= y; ++i) {
                        res[i - x] = i;
                    }
                    vec.add(res);
                }
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }

    /**
     * 双指针法
     * @param target
     * @return
     * 一共有三种情况：
     * 如果 \textit{sum}<\textit{target}sum<target 则说明指针 rr 还可以向右拓展使得 sumsum 增大，此时指针 rr 向右移动，即 r+=1
     * 如果 sum>targetsum>target 则说明以 ll 为起点不存在一个 rr 使得 sum=targetsum=target ，此时要枚举下一个起点，指针 ll 向右移动，即l+=1
     * 如果 \textit{sum}==\textit{target}sum==target 则说明我们找到了以 ll 为起点得合法解 [l,r][l,r] ，我们需要将 [l,r][l,r] 的序列放进答案数组，且我们知道以 ll 为起点的合法解最多只有一个，所以需要枚举下一个起点，指针 ll 向右移动，即 l+=1
     * 终止条件即为 l>=rl>=r 的时候，这种情况的发生指针 rr 移动到了\lfloor\frac{\textit{target}}{2}\rfloor+1⌊
     * 2
     * target
     * ​
     *  ⌋+1 的位置，导致 l<rl<r 的时候区间和始终大于 targettarget 。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/mian-shi-ti-57-ii-he-wei-sde-lian-xu-zheng-shu-x-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int[][] findContinuousSequence2(int target) {
        List<int[]> vec = new ArrayList<int[]>();
        for (int l = 1, r = 2; l < r;) {
            int sum = (l + r) * (r - l + 1) / 2;
            if (sum == target) {
                int[] res = new int[r - l + 1];
                for (int i = l; i <= r; ++i) {
                    res[i - l] = i;
                }
                vec.add(res);
                l++;
            } else if (sum < target) {
                r++;
            } else {
                l++;
            }
        }
        return vec.toArray(new int[vec.size()][]);
    }

}
