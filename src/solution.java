/**
 * @author Yemeng
 * @create 2021-03-10-10:15
 */
public class solution {
    public static void main(String[] args) {
        solution solution = new solution();
        System.out.println(solution.translateNum(123));
//        int a = 123;
//        String s = String.valueOf(a);
//        System.out.println(s.length());
        System.out.println(123%10);
    }



    public int translateNum(int num) {
        String s = String.valueOf(num);
        int[] ints = new int[s.length() + 1];
        ints[0] = 1;
        ints[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i-2,i);
            if (tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0){
                ints[i] = ints[i-2] + ints [i-1];
            }else {
                ints[i] = ints[i-1];
            }
        }
        return ints[s.length()];

    }


}
