package lucas.algorithm.week04;

import java.util.Arrays;

/**
 * 455. 分发饼干
 * https://leetcode-cn.com/problems/assign-cookies/description/
 */
public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        int result = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int gLength = g.length;
        int sLength = s.length;
        for (int i = 0, j = 0; i < gLength && j < sLength; i++, j++) {
            while (j < sLength && g[i] > s[j]) {
                j++;
            }
            if (j < sLength) {
                result++;
            }
        }
        return result;
    }
}
