package _41_50;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/9/17 9:27
 */

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _45_跳跃游戏II {
    public static void main(String[] args) {
        int[] nums={2,3,1,1,4};
        System.out.println(jump(nums));
    }
    public static int jump(int[] nums) {
        int maxStep=0,end=0,steps=0;
        int n=nums.length-1;
        for (int i = 0; i < n; i++) {
            //更新跳到的最远距离
            maxStep=Math.max(maxStep,nums[i]+i);
            //最远距离更新到最右边界，重新设置最右边界为最远距离，此时步数+1
            if(i==end){
                end=maxStep;
                steps++;
            }
        }
        return steps;
    }
}
