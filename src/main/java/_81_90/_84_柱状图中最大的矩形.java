package _81_90;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/10/18 14:48
 */

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *  
 *
 *
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 *  
 *
 *
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 *  
 *
 * 示例:
 *
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _84_柱状图中最大的矩形 {
    public static void main(String[] args) {
        int[] heights={2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
    public static int largestRectangleArea(int[] heights) {
        int result=0;
        //按序遍历外层数组，确定外层左边起点
        for (int i = 0; i < heights.length; i++) {
            //重置最小高度
            int minHeight=Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                //确定左右区间内最小高度
                minHeight=Math.min(minHeight,heights[j]);
                //确定最后结果
                result=Math.max(result, minHeight * (j - i + 1));
            }
        }
        return result;
    }
}
