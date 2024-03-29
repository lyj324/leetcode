package _21_30;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/9/11 18:21
 */

/**
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 1:
 *
 * 给定 nums = [3,2,2,3], val = 3,
 *
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 *
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 *
 * 注意这五个元素可为任意顺序。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 说明:
 *
 * 为什么返回数值是整数，但输出的答案是数组呢?
 *
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 * 你可以想象内部操作如下:
 *
 * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 * int len = removeElement(nums, val);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _27_移除元素 {
    public static void main(String[] args) {
        int[] nums={3,2,2,3};
        int val=3;
        System.out.println(removeElement(nums, val));
    }
    //双指针
//    public static int removeElement(int[] nums, int val) {
//        int i=0;
//        for (int j = 0; j < nums.length; j++) {
//            if(nums[j]!=val){
//                nums[i]=nums[j];
//                i++;
//            }
//        }
//        return i;
//    }
    //交换元素
    public static int removeElement(int[] nums, int val) {
        int i=0;
        int n=nums.length;
        while (i<n){
            if(nums[i]==val){
                //如果这一位书需要移除，把最后一位交换过来
                nums[i]=nums[n-1];
                n--;
            }else {
                i++;
            }
        }
        return i;
    }
}
