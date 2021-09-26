package lucas.algorithm.week08;

/**
 * https://leetcode-cn.com/problems/power-of-two/
 * 231. 2 的幂
 */
public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n>0&&(n&(n-1))==0;
    }
}
