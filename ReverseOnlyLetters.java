package lucas.algorithm.week10;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/reverse-only-letters/
 * 917. 仅仅反转字母
 */
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuffer result = new StringBuffer();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (Character.isLetter(c)) {
                stack.push(c);
            }
        }
        for (char c : chars) {
            if (Character.isLetter(c)) {
                result.append(stack.pop());
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public String reverseOnlyLetters2(String s) {
        StringBuffer result = new StringBuffer();
        int end = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                while (!Character.isLetter(s.charAt(end))) {
                    end--;
                }
                result.append(s.charAt(end--));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
