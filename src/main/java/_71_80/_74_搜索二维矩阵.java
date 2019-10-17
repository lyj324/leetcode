package _71_80;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/10/14 18:01
 */

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _74_搜索二维矩阵 {
    public static void main(String[] args) {
        int[][] matrix = {
        };
        int target = 13;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        for (int i = 0, j = matrix[0].length - 1; i < matrix.length && j >= 0; ) {
            if (matrix[i][j] < target) {
                i++;
            } else if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] == target) {
                return true;
            }
        }
        return false;
    }
}
