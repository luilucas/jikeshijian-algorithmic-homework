package lucas.algorithm.week04;

import java.util.*;

/**
 * 127. 单词接龙
 * https://leetcode-cn.com/problems/word-ladder/description/
 */
public class LadderLength {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int count = 0;
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        boolean[] visited = new boolean[wordList.size()];
        int index = wordList.indexOf(beginWord);
        if (index != -1) {
            visited[index] = true;
        }
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            ++count;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String start = queue.poll();
                for (int j = 0; j < wordList.size(); j++) {
                    if (visited[j]) {
                        continue;
                    }
                    String temp = wordList.get(j);
                    if (!CanConvert(start, temp)) {
                        continue;
                    }
                    if (temp.equals(endWord)) {
                        return count + 1;
                    }
                    visited[j] = true;
                    queue.offer(temp);
                }
            }
        }
        return 0;
    }

    private boolean CanConvert(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }
}
