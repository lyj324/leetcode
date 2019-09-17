package _41_50;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/9/17 9:51
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _46_全排列 {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        List<List<Integer>> permute = permute(nums);
        for (List<Integer> num:permute) {
            for (int i:num) {
                System.out.print(i+",");
            }
            System.out.println("");
        }
    }

    /**
     * 1.升序排列
     * 2.应为无重复数，所以一共有N!种可能
     * 3.利用_31_寻找下一个字典数，写入数组
     * 4.输出
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        long factorial = factorial(length)-1;
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> num=new ArrayList<>();
        Arrays.sort(nums);
        for (int n:nums) {
            num.add(n);
        }
        result.add(num);
        for (int i = 0; i < factorial; i++) {
            nextNum(nums);
            num=new ArrayList<>();
            for (int n:nums) {
                num.add(n);
            }
            result.add(num);
        }
        return result;
    }

    private static void nextNum(int[] nums) {
        int i = nums.length - 2;
        //从右往左找出第一个数，它比他右边的数小，记录他所在的位置i,如果是降序排列，i=-1
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if(i!=-1){
            //从右往左找第一个比nums[i]大的数，记录所在位置j。
            int j=nums.length-1;
            while (j >= 0 && nums[j] <= nums[i]){
                j--;
            }
            //交换位置
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        //把i之后的位置升序排列
        Arrays.sort(nums,i+1,nums.length);
    }
    public static long factorial(long number) {
        if (number <= 1) {
            return 1;
        } else {
            return number * factorial(number - 1);
        }
    }
}
