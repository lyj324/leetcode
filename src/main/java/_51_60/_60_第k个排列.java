package _51_60;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/10/9 19:51
 */

import java.util.Arrays;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _60_第k个排列 {
    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3));
    }
    public static String getPermutation(int n, int k) {
        String s = "";
        int[] nums = new int[n];
        for (int i = 0; i < n; ) {
            nums[i]=++i;
        }
        for (int i = 0; i < k-1; i++) {
            nextPermutation(nums);
        }
        for (int num:nums) {
            s+=Integer.toString(num);
        }
        return s;
    }
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
