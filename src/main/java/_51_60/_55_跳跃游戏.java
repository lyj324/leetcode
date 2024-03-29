package _51_60;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/10/9 17:56
 */

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _55_跳跃游戏 {
    public static void main(String[] args) {
        int[] nums={0};
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        int maxStep=0;
        int end=0;
        for (int i = 0; i < nums.length; i++) {
            //更新到最远距离前的区间中的点所能跳到的最远距离
            maxStep=Math.max(maxStep,nums[i]+i);
            if(i==end){
                //更新最远距离
                end=maxStep;
            }
        }
        if(end<nums.length-1) {
            return false;
        }
        return true;
    }
}
