package _31_40;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/9/16 10:24
 */

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _35_搜索插入位置 {
    public static void main(String[] args) {
        int[] nums={1,3,5,6};
        int target=7;
        System.out.println(searchInsert(nums, target));
    }
    public static int searchInsert(int[] nums, int target) {
        int low=0,high=nums.length;
        while (low<high){
            int mid=(low+high)>>1;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                high=mid;
            }else if(nums[mid]<target){
                low=mid+1;
            }
        }
        return low;
    }
}
