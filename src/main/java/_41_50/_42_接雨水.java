package _41_50;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/9/16 18:40
 */

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _42_接雨水 {
    public static void main(String[] args) {
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

    /**
     *
     * @param height
     * @return
     * 1.设定双指针分别指向，数组开头和结尾，定义左侧最大值，右侧最大值
     * 2.如果两个指针没有相遇，继续循环
     * 3.如果左指针上的数小于右指针上的数，说明接水凹槽左侧较矮
     *  3.1如果左侧最大值<=左侧目前值，更新左侧最大值，此时接不到水
     *  3.2如果左侧最大值>左侧目前值,更新结果,此时能接到左侧最大值-左侧目前值的水
     *  3.3指针右移
     * 4.如果左指针上的数大于等于右指针上的数，说明接水凹槽右侧较矮
     *  4.1如果右侧最大值<=右侧目前值，更新右侧最大值，此时接不到水
     *  4.2如果右侧最大值>右侧目前值,更新结果,此时能接到右侧最大值-右侧目前值的水
     *  4.3指针左移
     */
    public static int trap(int[] height) {
        int left=0,right=height.length-1;
        int res=0;
        int left_max = 0, right_max = 0;
        while (left < right) {
           if(height[left]<height[right]){
               if(height[left]>=left_max){
                   left_max=height[left];
               }else {
                   res+=(left_max-height[left]);
               }
               ++left;
           }else {
               if(height[right]>=right_max){
                   right_max=height[right];
               }else {
                   res+=(right_max-height[right]);
               }
               --right;
           }
        }
        return res;
    }
}
