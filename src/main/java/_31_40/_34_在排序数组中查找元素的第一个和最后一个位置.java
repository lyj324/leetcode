package _31_40;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/9/16 8:43
 */

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _34_在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        int[]nums={5,7,7,8,8,10};
        int target=8;
        int[] ints = searchRange(nums, target);
        System.out.println("["+ints[0]+","+ints[1]+"]");
    }

    /**
     *
     * @param nums
     * @param target
     * @return
     * 采用两次二分查找，分别找出最左边界位置，与最右边界位置
     * 如果没有找到最左边界也就没有必要去寻找最右边界
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] result={-1,-1};
        int left=0,right=0;
        if(nums.length==0){
            return result;
        }
        int low=0,high=nums.length;
        while (low<high){
            int mid=(low+high)>>1;
            //如果mid>=target就左移区间
            if(nums[mid]>=target){
                high=mid;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
        }
        if(low==nums.length){
            return result;
        }
        if(nums[low]==target){
            left=low;
            low=0;
            high=nums.length;
            while (low<high){
                int mid=(low+high)>>1;
                if(nums[mid]>target){
                    high=mid;
                }
                else if(nums[mid]<=target){
                    low=mid+1;
                }
            }
            right=low-1;
        }else {
            return result;
        }
        result=new int[]{left,right};
        return result;
    }
}
