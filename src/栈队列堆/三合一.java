package 栈队列堆;

import leetcode.ListNode;

public class 三合一 {
    //描述如何只用一个数组来实现三个栈。

}
class TripleInOne {

    private int[] array;
    private int n;
    private int[] top; //保存每个栈的栈顶下标
    public TripleInOne(int stackSize) {
        array = new int[3*stackSize];
        n = 3*stackSize;
        top = new int[3];
        top[0] = -3;
        top[1] = -2;
        top[2] = -1;
    }

    public void push(int stackNum, int value) {
        if (top[stackNum] + 3 >= n) {
            return;
        }
        top[stackNum] += 3;
        array[top[stackNum]] = value;
    }

    public int pop(int stackNum) {
        if (top[stackNum] < 0) {
            return -1;
        }
        int ret = array[top[stackNum]];
        top[stackNum] -= 3;
        return ret;
    }

    public int peek(int stackNum) {
        if (top[stackNum] < 0) {
            return -1;
        }
        return array[top[stackNum]];
    }

    public boolean isEmpty(int stackNum) {
        return top[stackNum] < 0;
    }
}