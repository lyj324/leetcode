package _81_90;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/10/20 10:47
 */

import java.util.Arrays;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _88_合并两个有序数组 {
    public static void main(String[] args) {
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        int m=3;
        int n=3;
        merge(nums1,m,nums2,n);
        Arrays.stream(nums1).forEach(a->System.out.print(a+" "));
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m,j=0; i < nums1.length; i++,j++) {
                nums1[i]=nums2[j];
        }
        Arrays.sort(nums1);
    }
}
