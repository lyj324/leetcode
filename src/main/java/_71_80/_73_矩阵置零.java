package _71_80;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/10/14 15:11
 */

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 * <p>
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * 进阶:
 * <p>
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _73_矩阵置零 {
    public static void main(String[] args) {
        int[][] matrix = {
                {-4, -2147483648, 6, -7, 0},
                {-8, 6, -8, -6, 0},
                {2147483647, 2, -9, -6, -10}
        };
        setZeroes(matrix);
        printMap(matrix);
    }

    public static void setZeroes(int[][] matrix) {
        boolean flag1 = false, flag2 = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0 && j == 0) {
                        flag1 = true;
                        flag2 = true;
                    } else if (i == 0) {
                        flag1 = true;
                    } else if (j == 0) {
                        flag2 = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = matrix.length == 1 ? 0 : 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = matrix[0].length == 1 ? 0 : 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if (flag1) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        if (flag2) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void printMap(int[][] map) {
        for (int[] ints : map) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
