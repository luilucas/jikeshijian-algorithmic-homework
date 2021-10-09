package lucas.algorithm.week10;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 5. 最长回文子串
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int len = s.length();
        int begin = 0, maxLen = 1;

        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int j = 0; j < len; j++)
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
                if (dp[i][j]) {
                    if (maxLen < j - i + 1) {
                        maxLen = j - i + 1;
                        begin = i;
                    }
                }
            }

        return s.substring(begin, begin + maxLen);
    }
}
