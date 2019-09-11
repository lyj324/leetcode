package _1_20; /**
 * @author lyj
 * @version 1.0
 * @date 2019/9/7 14:52
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _15_三数之和 {
    public static void main(String[] args) {
        int[] nums={-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        if (nums == null) {
            return result;
        }else {
            int len=nums.length;
            if(len<3){
                return result;
            }
        }
        //把元素从小到大排列
        Arrays.sort(nums);
        int L,R;
        for (int i = 0; i < nums.length-2; i++) {
            //如果最左边一个数已经大于0,三个大于0的数的和不可能等于0
            if(nums[i]>0){
                break;
            }
            //如果当前数和前一个数相等说明已经判断过了
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            L=i+1;
            R=nums.length-1;
            while (L<R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum==0){
                    result.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    //去除重复元素
                    while (L<R&&nums[L]==nums[L+1]){
                        L++;
                    }
                    //去除重复元素
                    while (L<R&&nums[R]==nums[R-1]){
                        R--;
                    }
                    L++;
                    R--;
                }else if(sum>0){
                    R--;
                }else {
                    L++;
                }
            }
        }
        return result;
    }
}
