package lucas.algorithm.week07;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(0, 0, n, new StringBuilder(), result);

        return result;
    }

    private void generate(int left, int right, int max, StringBuilder sb, List<String> result) {
        if (left == max && right == max) {
            result.add(sb.toString());
        }
        if (left < max) {
            generate(left + 1, right, max, sb.append("("), result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            generate(left, right + 1, max, sb.append(")"), result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
