package _0_20; /**
 * @author lyj
 * @version 1.0
 * @date 2019/9/7 17:00
 */

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _16_最接近的三数之和 {
    public static void main(String[] args) {
        int[] nums={1,1,1,1};
        System.out.println(threeSumClosest(nums, 0));
    }
    public static int threeSumClosest(int[] nums, int target) {
        int result=Integer.MAX_VALUE;
        int temp=Integer.MAX_VALUE;
        //把元素从小到大排列
        Arrays.sort(nums);
        int L,R;
        for (int i = 0; i < nums.length-2; i++) {
            L=i+1;
            R=nums.length-1;
            while (L<R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum==target){
                    return target;
                }else if(sum>target){
                    if (sum - target < temp) {
                        temp = sum - target;
                        result = sum;
                    }
                    R--;
                }else {
                    if (target - sum < temp) {
                        temp = target - sum;
                        result = sum;
                    }
                    L++;
                }
            }
        }
        return result;
    }
}
