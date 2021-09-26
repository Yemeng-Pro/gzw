package 栈队列堆;


import java.util.Stack;

//实现一个基本的计算器来计算简单的表达式字符串。
//
//表达式字符串只包含非负整数，算符 +、-、*、/ ，左括号 ( 和右括号 ) 。整数除法需要 向下截断 。
//
//你可以假定给定的表达式总是有效的。所有的中间结果的范围为 [-231, 231 - 1] 。
public class 基本计算器 {
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int i = 0;
        int n = s.length();

        while (i < n) {
            char c = s.charAt(i);
            if (c == ' ') { // 跳过空格
                i++;
            } else if (isDigit(c)) { //数字
                int number = 0;
                while (i < n && isDigit(s.charAt(i))) {
                    number = number*10+(s.charAt(i)-'0');
                    i++;
                }
                nums.push(number);
            } else if (c == '(') {
                ops.push(c);
                i++;
            } else if (c == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') {
                    fetchAndCal(nums, ops);
                }
                ops.pop(); // 弹出'('
                i++;
            } else { // 运算符
                if (ops.isEmpty() || prior(c, ops.peek())) {
                    ops.push(c);
                } else {
                    while (!ops.isEmpty() && !prior(c, ops.peek())) {
                        fetchAndCal(nums, ops);
                    }
                    ops.push(c);
                }
                i++;
            }
        }
        while (!ops.isEmpty()) {
            fetchAndCal(nums, ops);
        }
        return nums.pop();

    }


    private void fetchAndCal(Stack<Integer> nums, Stack<Character> ops) {
        int number2 = nums.pop();
        int number1 = nums.pop();
        char op = ops.pop();
        int ret = cal(op, number1, number2);
        nums.push(ret);
    }
    private boolean prior(char a, char b) {
        if ((a == '*' || a == '/')
                && (b == '+' || b == '-')) {
            return true;
        }
        if (b == '(') return true;
        return false;
    }
    private int cal(char op, int number1, int number2) {
        switch(op) {
            case '+': return number1+number2;
            case '-': return number1-number2;
            case '*': return number1*number2;
            case '/': return number1/number2;
        }
        return -1;
    }
    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
