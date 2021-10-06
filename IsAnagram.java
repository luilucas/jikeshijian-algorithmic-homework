package lucas.algorithm.week09;

/**
 * https://leetcode-cn.com/problems/valid-anagram/submissions/
 * 有效的字母异位词
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i) - 'a']--;
            if (map[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
