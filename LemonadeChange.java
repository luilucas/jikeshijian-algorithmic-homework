package lucas.algorithm.week04;

/**
 * 860. 柠檬水找零
 * https://leetcode-cn.com/problems/lemonade-change/description/
 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int fiveCount = 0, tenCount = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveCount++;
            } else if (bills[i] == 10) {
                if (fiveCount < 1) {
                    return false;
                }
                fiveCount--;
                tenCount++;
            } else if (bills[i] == 20) {
                if (fiveCount >= 1 && tenCount >= 1) {
                    fiveCount--;
                    tenCount--;
                } else if (fiveCount >= 3) {
                    fiveCount -= 3;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
