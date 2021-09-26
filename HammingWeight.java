package lucas.algorithm.week08;

/**
 * https://leetcode-cn.com/problems/number-of-1-bits/
 * 191. 位1的个数
 */
public class HammingWeight {
    public int hammingWeight(int n) {
        int result = 0;
        while(n!=0){
            n &=n-1;
            result++;
        }
        return result;
    }
}
