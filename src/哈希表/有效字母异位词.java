package 哈希表;

public class 有效字母异位词 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] nums1 = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            nums1[c-'a']++;
        }
        int[] nums2 = new int[26];
        for (int i = 0; i < t.length(); ++i) {
            char c = t.charAt(i);
            nums2[c-'a']++;
        }
        for (int i = 0; i < 26; ++i) {
            if (nums1[i] != nums2[i]) {
                return false;
            }
        }
        return true;
    }
}
