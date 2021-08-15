package lucas.algorithm;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (heap.size() == k) {
                int top = heap.peek()[1];
                if (top < count) {
                    heap.poll();
                    heap.offer(new int[]{num, count});
                }
            } else {
                heap.offer(new int[]{num, count});
            }
        }
        int[] res = new int[k];
        int min = Math.min(k, heap.size());
        for (int i = 0; i < min; i++) {
            res[i] = heap.poll()[0];
        }

        return res;
    }
}
