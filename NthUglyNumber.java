package lucas.algorithm;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 丑数
 * https://leetcode-cn.com/problems/chou-shu-lcof/
 */
public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        int res = 0;
        PriorityQueue<Long> heap = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        int[] factors = new int[]{2, 3, 5};
        heap.offer(1L);
        set.add(1L);
        for (int i = 0; i < n; i++) {
            long curr = heap.poll();
            res = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (set.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return res;
    }
}


