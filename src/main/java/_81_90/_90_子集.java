package _81_90;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/10/20 11:36
 */

import java.util.*;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _90_子集 {
    public static void main(String[] args) {
        int[] nums = {4,4,4,1,4};
        subsetsWithDup(nums).forEach(System.out::println);
    }
    //在78题的基础上去重
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<Integer> integers;
        ArrayList<List<Integer>> result = new ArrayList<>();
        int pow = (int) (Math.pow(2, nums.length));
        for (int i = 0; i < pow; i++) {
            String s = Integer.toBinaryString(i);
            //补齐前面的0
            StringBuilder builder = new StringBuilder();
            while (s.length() != nums.length) {
                builder.append("0");
                builder.append(s);
                s = builder.toString();
                builder.delete(0, builder.length());
            }
            integers = new ArrayList<>();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    integers.add(nums[j]);
                }
            }
            Collections.sort(integers);
            if (!result.contains(integers)) {
                result.add(integers);
            }
        }
        return result;
    }
}
