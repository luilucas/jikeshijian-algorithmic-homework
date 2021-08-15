package lucas.algorithm;

import java.util.HashMap;

public class IsAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("rat", "car"));

    }

    public static boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) {
//            return false;
//        }
//        HashMap<Character, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            map.put(ch, map.getOrDefault(ch, 0) + 1);
//        }
//        for (int i = 0; i < t.length(); i++) {
//            char ch = s.charAt(i);
//            map.put(ch, map.getOrDefault(ch, 0) - 1);
//            if (map.get(ch) < 0) {
//                return false;
//            }
//        }
//
//        return true;

        if (s.length() != t.length()) {
            return false;
        }

        int[] list = new int[26];
        for (int i = 0; i < s.length(); i++) {
            list[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            list[t.charAt(i) - 'a']--;
            if (list[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
