package lucas.algorithm.week10;

/**
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 * 8. 字符串转换整数 (atoi)
 */
public class MyAtoi {
    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int index = 0;
        while (index < length && chars[index] == ' ') {
            index++;
        }
        if (index == length) {
            return 0;
        }
        int sign = 1;
        if (chars[index] == '-') {
            sign = -1;
            index++;
        } else if (chars[index] == '+') {
            index++;
        }

        int result = 0, last = 0;
        while (index < length) {
            char ch = chars[index++];
            if (ch < '0' || ch > '9') {
                break;
            }
            int temp = ch - '0';
            last = result;
            result = result * 10 + temp;
            if (last != result / 10) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

        }
        return result * sign;
    }
}
