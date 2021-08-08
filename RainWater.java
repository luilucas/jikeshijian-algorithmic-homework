/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * 42. 接雨水
 */

public class RainWater {
    public int trap(int[] height) {
        int result = 0;
        int i = 0;
        Stack<Integer> stack = new Stack<Integer>();
        while (i < height.length) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int wid = i - left - 1;
                int hig = Math.min(height[i], height[left]) - height[top];

                result += wid * hig;
            }
            stack.push(i++);
        }
        return result;
    }
}
