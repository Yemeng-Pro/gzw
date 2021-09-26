package 二分;

public class 稀疏数组的搜索 {
    //稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置
    public int findString(String[] words, String s) {
        int low = 0;
        int high = words.length-1;
        while (low <= high) {
            int mid = (low+high)/2;
            if (words[mid].equals(s)) {
                return mid;
            } else if (words[mid].equals("")) {
                if (words[low].equals(s)) return low;
                else low++;
            } else if (words[mid].compareTo(s) < 0) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
}
