package _61_70;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/10/10 10:36
 */

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _64_最小路径和 {
    public static void main(String[] args) {
        int[][] grid={
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(minPathSum(grid));
    }
    public static int minPathSum(int[][] grid) {
        int m=grid[0].length;
        int n=grid.length;
        for (int i = 1; i < n; i++) {
            grid[i][0]+=grid[i-1][0];
        }
        for (int i = 1; i < m; i++) {
            grid[0][i]+=grid[0][i-1];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                grid[i][j]+=Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[n-1][m-1];
    }
    public static void printMap(int[][] map){
        for (int[] ints :map) {
            for (int i:ints) {
                System.out.print(i+" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
