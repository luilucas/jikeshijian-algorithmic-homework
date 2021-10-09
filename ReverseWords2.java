package lucas.algorithm.week10;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 * 557. 反转字符串中的单词 III
 */
public class ReverseWords2 {
    public String reverseWords(String s) {
        StringBuffer res = new StringBuffer();
        int length = s.length();
        int i = 0;
        while (i < length) {
            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            for (int j = start; j < i; j++) {
                res.append(s.charAt(start + i - 1 - j));
            }
            while (i < length && s.charAt(i) == ' ') {
                i++;
                res.append(' ');
            }
        }
        return res.toString();
    }
}
