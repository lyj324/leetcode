package _1_20; /**
 * @author lyj
 * @version 1.0
 * @date 2019/9/4 10:31
 */


import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _1_两数之和 {
    public static void main(String[] args) {
        int num[]={3,3};
        int target=6;
        Solution solution = new Solution();
        System.out.println(solution.twoSum(num,target)[0]+""+solution.twoSum(num,target)[1]);
    }
    static class Solution {
        /**
         * 1.遍历nums[],写入hashmap，key为num[i],value为i
         * 2.遍历nums[],查看hashmap中是否存在key为target-nums[i]的元素
         *  2.1如果存在，写入结果ints[0],ints[1]
         *  2.2判断ints[0],ints[1]是否相同，不同则跳出循环，相同则重复执行2
         * 3.返回结果
         * @param nums
         * @param target
         * @return
         */
        public int[] twoSum(int[] nums, int target) {
            int[] ints = new int[2];
            HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<Integer, Integer>();
            for (int i=0;i<nums.length;i++) {
                integerIntegerHashMap.put(nums[i],i);
            }
            for (int i=0;i<nums.length;i++) {
                int num=target-nums[i];
                if(integerIntegerHashMap.containsKey(num))
                {
                    ints[0]=i;
                    ints[1]=integerIntegerHashMap.get(num);
                    if(ints[0]==ints[1]){
                        continue;
                    }
                    else{
                        break;
                    }
                }
            }
            return ints;
        }
    }
}
