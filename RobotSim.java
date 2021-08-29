package lucas.algorithm.week04;

import java.util.HashSet;

/**
 * 874. 模拟行走机器人
 * https://leetcode-cn.com/problems/walking-robot-simulation/description/
 */
public class RobotSim {
    public int robotSim(int[] commands, int[][] obstacles) {
        int result = 0;
        int[] dirX = new int[]{0, 1, 0, -1};
        int[] dirY = new int[]{1, 0, -1, 0};
        int curX = 0, curY = 0;
        int curDire = 0;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            set.add(obstacles[i][0] + "," + obstacles[i][1]);
        }
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -1) {
                curDire = (curDire + 1) % 4;
            } else if (commands[i] == -2) {
                curDire = (curDire + 3) % 4;
            } else {
                for (int j = 0; j < commands[i]; j++) {
                    int x = curX + dirX[curDire];
                    int y = curY + dirY[curDire];
                    if (!set.contains(x + "," + y)) {
                        curX = x;
                        curY = y;
                        result = Math.max(result, x * x + y * y);
                    } else {
                        break;
                    }
                }
            }
        }
        return result;
    }
}
