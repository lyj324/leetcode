package _41_50;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/9/16 16:30
 */

/**
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 说明:
 *
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _41_缺失的第一个正数 {
    public static void main(String[] args) {
        int[] nums={3,4,-1,-2,1,5,16,0,2,0};
        System.out.println(firstMissingPositive(nums,1));
    }

    /**
     *
     * @param nums
     * @return
     * 检查 1 是否存在于数组中。如果没有，则已经完成，1 即为答案。
     * 如果 nums = [1]，答案即为 2 。
     * 将负数，零，和大于 n 的数替换为 1 。
     * 遍历数组。当读到数字 a 时，替换第 a 个元素的符号。
     * 注意重复元素：只能改变一次符号。由于没有下标 n ，使用下标 0 的元素保存是否存在数字 n。
     * 再次遍历数组。返回第一个正数元素的下标。
     * 如果 nums[0] > 0，则返回 n 。
     * 如果之前的步骤中没有发现 nums 中有正数元素，则返回n + 1。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/first-missing-positive/solution/que-shi-de-di-yi-ge-zheng-shu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static int firstMissingPositive(int[] nums) {
        int n=nums.length;
        //标记1是否出现在数组中
        boolean flag=true;
        for (int i = 0; i < n ; i++) {
            //如果出现1，flag置否。跳出循环
            if(nums[i]==1){
                flag=false;
                break;
            }
        }
        //未出现1
        if (flag){
            return 1;
        }
        //出现1，但数组长度为1，即nums=[1]
        if(n==1){
            return 2;
        }
        //用替换负、0、大于n的数.
        for (int i = 0; i <n ; i++) {
            if(nums[i]<=0||nums[i]>n){
                nums[i]=1;
            }
        }
        //遍历数组。当读到数字 a 时，替换第 a 个元素的符号。
        for (int i = 0; i < n ; i++) {
            //nums[i]可能已经被替换过，所以用绝对值
            int a=Math.abs(nums[i]);
            if(a==n){
                nums[0]=-Math.abs(nums[0]);
            }else {
                nums[a]=-Math.abs(nums[a]);
            }
        }
        for (int i = 1; i < n ; i++) {
            if(nums[i]>0){
                return i;
            }
        }
        if(nums[0]>0){
            return n;
        }
        return n+1;
    }
    /**
     * 3,4,-1,-2,1,5,16,0,2,0
     * 1.判断数字1是否出现，如果没有出现，返回1
     *  1.2.判断数组长度是否为1，如果为1，结合1未出现，可知数组为{1}，返回2
     * 2.极端情况如数组{1,2,3,4}返回n+1,也就是说大于n的数和负数、0不需要考虑
     *  2.1因为已经保证1会出现,将>n,<=0的数置位1
     *          3,4,-1,-2,1,5,16,0,2,0
     *  变化为： 3,4, 1, 1,1,5, 1,1,2,1
     * 3.遍历新数组，将出现数字的绝对值的下标的数置为负数（如果出现数字n，将下标0的数置负）
     *           3, 4,1, 1, 1, 5,1,1,2,1
     *  变化1:   3, 4, 1,-1, 1, 5,1,1,2,1
     *                   ↑
     *  变化2:   3, 4, 1,-1,-1, 5,1,1,2,1
     *                      ↑
     *  变化3:   3,-4, 1,-1,-1, 5,1,1,2,1
     *             ↑
     *  变化4:   3,-4, 1,-1,-1, 5,1,1,2,1
     *             ↑
     *  变化5:   3,-4, 1,-1,-1, 5,1,1,2,1
     *             ↑
     *  变化6:   3,-4, 1,-1,-1,-5,1,1,2,1
     *                         ↑
     *  变化7:   3,-4, 1,-1,-1,-5,1,1,2,1
     *              ↑
     *  变化8:   3,-4, 1,-1,-1,-5,1,1,2,1
     *              ↑
     *  变化9:   3,-4,-1,-1,-1,-5,1,1,2,1
     *                ↑
     *  变化10:  3,-4,-1,-1,-1,-5,1,1,2,1
     *             ↑
     * 4.现在值为负的数的下标就是出现的数，遍历1-n和0（0代表了数字n）的数字，第一个正数的下标就是返回值
     * 5.如果所有数都是负数，返回n+1
     */

    /**
     *
     * @param nums
     * @param i
     * @param j
     * 利用位运算交换数组实现排序
     *               3, 4,-1,-2, 1, 5,16,0, 2,0
     * 变化1：       -1, 4, 3,-2, 1, 5,16,0, 2,0
     * 变化2：       -1,-2, 3, 4, 1, 5,16,0, 2,0
     * 变化3：        1,-2, 3, 4,-1, 5,16,0, 2,0
     * 变化4：        1, 5, 3, 4,-1,-2,16,0, 2,0
     * 变化4：        1, 2, 3, 4,-1,-2,16,0, 5,0
     * 变化4：        1, 2, 3, 4, 5,-2,16,0,-1,0
     * 返回第一个非正数或大于n的数的下标i+1
     * 如果全都符合，返回len+1
     */
    public static void swap(int[] nums,int i,int j){
        if(i==j){
            return;
        }
        nums[i]=nums[i]^nums[j];
        nums[j]=nums[i]^nums[j];
        nums[i]=nums[i]^nums[j];
    }
    public static int firstMissingPositive(int[] nums, int a){
        int len=nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] - 1 != i) {
                return i + 1;
            }
        }
        return len + 1;
    }
}
