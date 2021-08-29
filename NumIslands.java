package lucas.algorithm.week04;

/**
 * 200. 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/
 */
public class NumIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int result = 0;
        int rnum = grid.length;
        int cnum = grid[0].length;
        for (int i = 0; i < rnum; i++)
            for (int j = 0; j < cnum; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    scan(grid, i, j);
                }
            }

        return result;
    }

    private void scan(char[][] grid, int r, int c) {
        int rnum = grid.length;
        int cnum = grid[0].length;
        if (r < 0 || c < 0 || r >= rnum || c >= cnum || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        scan(grid, r + 1, c);
        scan(grid, r - 1, c);
        scan(grid, r, c + 1);
        scan(grid, r, c - 1);
    }
}
