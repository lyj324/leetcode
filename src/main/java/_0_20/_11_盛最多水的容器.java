package _0_20; /**
 * @author lyj
 * @version 1.0
 * @date 2019/9/7 10:06
 */

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 *
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 *  
 *
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _11_盛最多水的容器 {
    public static void main(String[] args) {
        int[] ints = {2,3,4,5,18,17,6};
        System.out.println(maxArea(ints));
    }
    public static int maxArea(int[] height) {
        int start=0,end=height.length-1,area=0;
        int maxArea=(end-start)*Math.min(height[start],height[end]);
        //短的那边向中心移动
        //如果左边比较短
        while (start!=end){
            if(height[start]<=height[end]){
                start++;
            }else {
                end--;
            }
            maxArea=Math.max((end-start)*Math.min(height[start],height[end]),maxArea);
        }
        return maxArea;
    }
}
