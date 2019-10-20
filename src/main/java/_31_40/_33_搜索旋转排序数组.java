package _31_40;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/9/12 15:18
 */

import java.util.Arrays;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _33_搜索旋转排序数组 {
    public static void main(String[] args) {
        int[] nums={4,5,6,7,0,1,2};
        int target=0;
        System.out.println(search(nums, target));
    }

    /**
     *
     * @param nums
     * @param target
     * @return
     * 采用二分查找
     * 1.定义三个指针，low指向查找数组开头，high指向查找数组结尾，mid为high与low的平均值
     * 2.当low<high时执行二分查找
     * 3.计算mid的值
     * 4.现在查找的范围是[low,mid]
     *  4.1如果nums[low]<=nums[mid]，说明查找范围是完全升序的，即没有发生旋转
     *      4.1.1此时如果target比nums[low]小，或者target比nums[mid]大，说明不在这段上，向后查找
     *      4.1.2向后查找low重新指向mid+1，查找后半段
     *  4.2如果nums[low]>nums[mid]，此时查找范围有一部分发生旋转，
     *  只有当同时满足target比nums[low]小，比nums[mid]大，
     *  才能判断不在这段上，需要向后查找
     *      4.2.1向后查找low重新指向mid+1，查找后半段
     *  4.3此时说明在本段，继续二分查找high=mid
     *  5.如果能查到必然满足
     *      5.1low==hight
     *      5.2low<nums.length
     *      5.3nums[low]==target
     *  6.如果满足5则返回low，否则返回-1
     */
    public static int search(int[] nums, int target) {
       int low=0,high=nums.length;
       while (low<high){
           int mid=(low+high)>>1;
           //前半段升序
           if(nums[low]<=nums[mid]&&(target<nums[low]||target>nums[mid])){
               low=mid+1;
           }else if(target<nums[low]&&target>nums[mid]){
               low=mid+1;
           }else {
               high=mid;
           }
       }
       if(low==high&&low<nums.length){
           if(nums[low]==target){
               return low;
           }
       }
       return -1;
    }
}
