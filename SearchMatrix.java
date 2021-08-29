package lucas.algorithm.week04;

/**
 * 74. 搜索二维矩阵
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rnum = matrix.length;
        int cnum = matrix[0].length;
        int left = 0, right = rnum * cnum - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int midValue = matrix[mid / cnum][mid % cnum];
            if (midValue == target) {
                return true;
            }
            if (midValue > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
