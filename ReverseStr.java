package lucas.algorithm.week10;

/**
 * https://leetcode-cn.com/problems/reverse-string-ii/
 * 541. 反转字符串 II
 */
public class ReverseStr {
    public String reverseStr(String s, int k) {
        int length = s.length();
        char[] src = s.toCharArray();
        for (int i = 0; i < length; i += 2 * k) {
            reverse(src, i, Math.min(i + k, length) - 1);
        }

        return new String(src);
    }

    private void reverse(char[] src, int left, int right) {
        while (left < right) {
            char temp = src[left];
            src[left] = src[right];
            src[right] = temp;
            left++;
            right--;
        }
    }
}
