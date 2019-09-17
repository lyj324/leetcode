package _31_40;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/9/12 10:27
 */

import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _31_下一个排列 {
    public static void main(String[] args) {
        int[] nums={1,5,8,4,7,6,5,3,1};
        nextPermutation(nums);
        for (int num:nums) {
            System.out.print(num+",");
        }
    }

    /**
     * 字典序排列数字就是nums所组成的所有数字，按从小到大排列
     * 例如nums={1,2,3}
     * 字典序123->132->213->231->312->321
     * 找到下一个字典序
     * 例如158476531->158513467
     * 1.从倒数第二个数开始向左寻找，找到一个数比右边小
     * 例如 1 5 8   4   7 6 5 3 1         |4<7
     *              ↑
     * 2.记录所在位置
     * 例如3
     * 3.从右向左找第一个比他大的数          |5>4
     * 例如 1 5 8 4 7 6   5   3 1
     *                    ↑
     * 4.记录位置j
     * 例如6
     * 5.交换ij所在位置的数
     * 例如158576431
     * 6.升序排列i之后的数
     * 例如1585               76431
     *         升序排列（倒置）13467
     * 7.得到结果158513467
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
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
            swap(nums,i,j);
        }
        //把i之后的位置升序排列
        Arrays.sort(nums,i+1,nums.length);
    }
    //交换数字
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
