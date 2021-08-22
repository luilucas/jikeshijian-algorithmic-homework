package lucas.algorithm.week03;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 全排列
 * https://leetcode-cn.com/problems/permutations/
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        if (length == 0) {
            return res;
        }
        Deque<Integer> stack = new ArrayDeque();
        boolean[] visited = new boolean[length];
        generate(nums, length, 0, stack, visited, res);
        return res;
    }

    private void generate(int[] nums, int length, int depth, Deque<Integer> stack, boolean[] visited, List<List<Integer>> res) {
        if (length == depth) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                stack.addLast(nums[i]);
                visited[i] = true;
                generate(nums, length, depth + 1, stack, visited, res);
                stack.removeLast();
                visited[i] = false;
            }
        }
    }
}
