package _71_80;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/10/15 11:25
 */

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _78_子集 {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        subsets(nums).forEach(System.out::println);
    }
    public static List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<List<Integer>> result = new ArrayList<>();
        int pow =(int)(Math.pow(2, nums.length));
        for (int i = 0; i < pow; i++) {
            String s = Integer.toBinaryString(i);
            while (s.length()!=nums.length){
                s="0"+s;
            }
            integers=new ArrayList<>();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j)=='1') {
                    integers.add(nums[j]);
                }
            }
            result.add(integers);
        }
        return result;
    }
}
