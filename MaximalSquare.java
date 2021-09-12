package lucas.algorithm.week06;

/**
 * 221. 最大正方形
 * https://leetcode-cn.com/problems/maximal-square/
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        if (matrix == null || m == 0 || n == 0) {
            return max;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        int result = max * max;
        return result;
    }
}
