package 二分;

public class 寻找比目标字母大的最小字母 {
    // 第⼀个⼤于target的元素
    //列表有序，查找比目标字母大的最小字母
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length-1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            char c = letters[mid];
            if (c > target) {
                if (mid == 0 || letters[mid-1] <= target) {
                    return letters[mid];
                } else {
                    high = mid-1;
                }
            } else {
                low = mid+1;
            }
        }
        return letters[0]; // 这个题⽬的特殊要求
    }
}
