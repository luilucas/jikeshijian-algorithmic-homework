package lucas.algorithm.week08;

/**
 * https://leetcode-cn.com/problems/number-of-provinces/
 * 547. 省份数量
 */
public class FindCircleNum {
    public int findCircleNum(int[][] isConnected) {
        int length = isConnected.length;
        int[] provinces = new int[length];
        for (int i = 0; i < length; i++) {
            provinces[i] = i;
        }
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (isConnected[i][j] == 1) {
                    merge(provinces, i, j);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (provinces[i] == i) {
                result++;
            }
        }
        return result;
    }

    private void merge(int[] provinces, int x, int y) {
        provinces[find(provinces, x)] = find(provinces, y);
    }

    private int find(int[] provinces, int index) {
        if (provinces[index] != index) {
            provinces[index] = find(provinces, provinces[index]);
        }
        return provinces[index];
    }
}
