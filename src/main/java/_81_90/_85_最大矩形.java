package _81_90;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/10/20 9:10
 */

import java.util.Arrays;

/**
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * ['1','0','1','0','0'],
 * ['1','0','1','1','1'],
 * ['1','1','1','1','1'],
 * ['1','0','0','1','0']
 * ]
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _85_最大矩形 {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximalRectangle(matrix));
    }

    /**
     * 遍历每一层，以当前遍历层为底层，记录以‘1’构成的塔的高度int[] heights
     * 以84题的方法计算最大矩形
     * 更新最大高度
     * @param matrix
     * @return
     */
    public static int maximalRectangle(char[][] matrix) {
        int result=0;
        if(matrix.length==0) {
            return result;
        }
        for (int i = 0; i < matrix.length; i++) {
            int[] heights = new int[matrix[0].length];
            for (int j = 0; j < matrix[0].length; j++) {
                int k=i;
                while (k>=0) {
                    if(matrix[k][j]=='0') {
                        k=-1;
                        continue;
                    }
                    heights[j]+=(matrix[k--][j]-'0');
                }
            }
            result=Math.max(result,largestRectangleArea(heights));
        }
        return result;
    }

    public static int largestRectangleArea(int[] heights) {
        int result = 0;
        //按序遍历外层数组，确定外层左边起点
        for (int i = 0; i < heights.length; i++) {
            //重置最小高度
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                //确定左右区间内最小高度
                minHeight = Math.min(minHeight, heights[j]);
                //确定最后结果
                result = Math.max(result, minHeight * (j - i + 1));
            }
        }
        return result;
    }
}
