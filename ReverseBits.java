package lucas.algorithm.week08;

/**
 * https://leetcode-cn.com/problems/reverse-bits/solution/dian-dao-er-jin-zhi-wei-by-leetcode-solu-yhxz/
 * 190. 颠倒二进制位
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            result |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return result;
    }
}
