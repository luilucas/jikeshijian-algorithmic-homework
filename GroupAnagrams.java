package lucas.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 字母异位词分组
 * https://leetcode-cn.com/problems/group-anagrams/
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> res = new HashMap<>();
        for (String str : strs) {
            int temp[] = new int[26];
            for (int i = 0; i < str.length(); i++) {
                temp[str.charAt(i) - 'a']++;
            }

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (temp[i] != 0) {
                    sb.append(i + 'a');
                    sb.append(temp[i]);
                }
            }
            String key = sb.toString();
            List<String> list = res.getOrDefault(key, new ArrayList<>());
            list.add(str);
            res.put(key, list);
        }

        return new ArrayList<>(res.values());

    }
}
