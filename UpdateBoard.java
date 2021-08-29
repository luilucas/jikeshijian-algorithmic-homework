package lucas.algorithm.week04;

/**
 * 529. 扫雷游戏
 * https://leetcode-cn.com/problems/minesweeper/description/
 */
public class UpdateBoard {
    int[] dirX = {0, 1, 0, -1, 1, 1, -1, -1};
    int[] dirY = {1, 0, -1, 0, 1, -1, 1, -1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else {
            scan(board, x, y);
        }

        return board;
    }

    private void scan(char[][] board, int r, int c) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int x = r + dirX[i];
            int y = c + dirY[i];
            if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
                continue;
            }
            if (board[x][y] == 'M') {
                count++;
            }
        }
        if (count > 0) {
            board[r][c] = (char) (count + '0');
        } else {
            board[r][c] = 'B';
            for (int i = 0; i < 8; i++) {
                int x = r + dirX[i];
                int y = c + dirY[i];
                if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != 'E') {
                    continue;
                }
                scan(board, x, y);
            }
        }
    }
}
