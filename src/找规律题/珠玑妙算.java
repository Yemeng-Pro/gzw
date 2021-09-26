package 找规律题;

import java.util.BitSet;

public class 珠玑妙算 {
    public int[] masterMind(String solution, String guess) {
        int count = 0;
        int count2 = 0;

        BitSet solu = new BitSet(solution.length());
        BitSet gus = new BitSet(solution.length());
        for(int i = 0;i<solution.length();i++){
            if(solution.charAt(i) == guess.charAt(i)) {
                count++;
                solu.set(i);
                gus.set(i);
            }

        }
        for(int i = 0;i<solution.length();i++){
            if (gus.get(i)) continue;
            for(int j = 0; j<solution.length();j++){
                if (solution.charAt(j) == guess.charAt(i) && !solu.get(j)){
                    count2++;
                    solu.set(j);
                    break;
                }
            }
        }
        return new int[]{count,count2};
    }

//    public int[] masterMind(String solution, String guess) {
//        int n = solution.length();
//        boolean[] hited = new boolean[n];//guess中哪些字符已经猜中了
//        boolean[] used = new boolean[n];//solution中哪些字符已经被匹配⽤掉了
//// 先计算猜中的
//        int hitCount = 0;
//        for (int i = 0; i < n; ++i) {
//            if (solution.charAt(i) == guess.charAt(i)) {
//                hited[i] = true;
//                used[i] = true;
//                hitCount++;
//            }
//        }
//// 再计算伪猜中的
//        int fakeHitCount = 0;
//        for (int i = 0; i < n; ++i) {
//            if (hited[i]) continue;
//// 拿每个guess中的字符到solution中查找
//            for (int j = 0; j < n; ++j) {
//                if (solution.charAt(j) == guess.charAt(i) && !used[j]) {
//                    used[j] = true;
//                    fakeHitCount++;
//                    break;
//                }
//            }
//        }
//        return new int[] {hitCount, fakeHitCount};
//    }
}
