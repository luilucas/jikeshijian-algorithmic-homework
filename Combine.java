package lucas.algorithm.week03;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 组合
 * https://leetcode-cn.com/problems/combinations/
 */
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n < k) {
            return result;
        }
        Stack<Integer> stack = new Stack<>();
        generate(n, k, 1, stack, result);
        return result;
    }

    private void generate(int n, int k, int start, Stack<Integer> stack, List<List<Integer>> result) {
        if (stack.size() == k) {
            result.add(new ArrayList<>(stack));
            return;
        }

        for (int i = start; i <= n; i++) {
            stack.add(i);
            generate(n, k, i + 1, stack, result);
            stack.pop();
        }
    }
}
