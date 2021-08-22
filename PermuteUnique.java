package lucas.algorithm.week03;

import java.util.*;

/**
 * 全排列 II
 * https://leetcode-cn.com/problems/permutations-ii/
 */
public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        if (length == 0) {
            return res;
        }
        Arrays.sort(nums);
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
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            stack.addLast(nums[i]);
            visited[i] = true;
            generate(nums, length, depth + 1, stack, visited, res);
            stack.removeLast();
            visited[i] = false;
        }
    }
}
