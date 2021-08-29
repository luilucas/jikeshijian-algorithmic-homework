package lucas.algorithm.week04;

/**
 * 55. 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        int max = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i <= max) {
                max = Math.max(max, i + nums[i]);
                if (max >= length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
