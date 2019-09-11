package _1_20;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/9/10 18:17
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _18_四数之和 {
    public static void main(String[] args) {
        int[] nums={1,0,-1,0,-2,2};
        //-2,-1,0,0,1,2
        int target=0;
       System.out.println(fourSum(nums, target));
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }else {
            int len=nums.length;
            if(len<4){
                return result;
            }
        }
        //把元素从小到大排列
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int tempTarget=target-nums[i];
            int[] tempNums = new int[nums.length-1];
            boolean flag=false;
            for (int j = 0; j < nums.length-1;j++) {
                if(j!=i){
                    if(flag){
                        tempNums[j]=nums[j+1];
                    }
                    else {
                        tempNums[j]=nums[j];
                    }
                }else {
                    tempNums[j]=nums[j+1];
                    flag=true;
                }
            }
//            for (int n:tempNums) {
//                System.out.print(n+" ");
//            }
//            System.out.println("");
//            System.out.println(tempTarget);
            List<List<Integer>> lists = threeSum(tempNums, tempTarget,nums[i]);
            for (List<Integer> list:lists) {
                if(!result.contains(list)){
                    result.add(list);
                }
            }
        }
        return result;
    }
    public static List<List<Integer>> threeSum(int[] nums,int target,int num) {
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
            //如果当前数和前一个数相等说明已经判断过了
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            L=i+1;
            R=nums.length-1;
            while (L<R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum==target){
                    if(nums[i]>num){
                        result.add(Arrays.asList(num,nums[i],nums[L],nums[R]));
                    }
                    else if(nums[i]<=num&&nums[L]>num){
                        result.add(Arrays.asList(nums[i],num,nums[L],nums[R]));
                    }else if(nums[L]<=num&&nums[R]>num){
                        result.add(Arrays.asList(nums[i],nums[L],num,nums[R]));
                    }else {
                        result.add(Arrays.asList(nums[i],nums[L],nums[R],num));
                    }
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
                }else if(sum>target){
                    R--;
                }else {
                    L++;
                }
            }
        }
        return result;
    }
}
