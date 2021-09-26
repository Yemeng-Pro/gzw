package 二分;

public class 猜数字大小 {
    private int ans = 1;

    private int guess(int num) {
        if (num == ans) {
            return 0;
        } else if (num > ans) {
            return -1;
        } else {
            return 1;
        }
    }
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low+(high-low)/2;
            int ret = guess(mid);
            if (ret == 0) {
                return mid;
            } else if (ret == -1) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
}
