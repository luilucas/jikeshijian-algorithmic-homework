package lucas.algorithm.week04;

/**
 * 45. 跳跃游戏 II
 * https://leetcode-cn.com/problems/jump-game-ii/
 */
public class Jump {
    public int jump(int[] nums) {
        int result = 0;
        int max = 0;
        int jumpIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == jumpIndex) {
                jumpIndex = max;
                result++;
            }
        }
        return result;
    }
}
