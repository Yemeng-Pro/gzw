package 二分;

public class 有效的完全平方数 {
    public boolean isPerfectSquare(int num) {
// [1, num]之间选择平⽅等于num的数
        int low = 1;
        int high = num;
        while (low <= high) {
            int mid = low + (high-low)/2;
// 1. mid^2==num return true
// 2. mid^2>num high=mid-1
// 3. mid^2<num low=mid+1
            long mid2 = (long)mid*mid;
            if (mid2 == num) {
                return true;
            } else if (mid2 > num) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return false;
    }
}
