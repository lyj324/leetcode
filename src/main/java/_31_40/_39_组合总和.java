package _31_40;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/9/16 15:05
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _39_组合总和 {
    public static void main(String[] args) {
        int[] candidates = {8,7,4,3};
        int target =11;
        List<List<Integer>> lists = combinationSum(candidates, target);
        System.out.println(lists);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        //把待选数字从小到大排序
        Arrays.sort(candidates);
        //初始化结果集
        List<List<Integer>> res = new ArrayList<>();
        //开始递归，参数   剩余值， candidates遍历到的位置，储存单个结果的栈，待选数字，储存结果的list
        findCombinationSum(target, 0, new Stack<>(),candidates,res);
        return res;
    }

    private static void findCombinationSum(int residue, int start, Stack<Integer> pre, int[] candidates,List<List<Integer>> res) {
        //剩余值小于0，说明这条分支无法得到结果
        if(residue<0){
            return;
        }
        //说明的到了结果，储存
        if(residue==0){
            ArrayList<Integer> integers = new ArrayList<>(pre);
            if(!res.contains(integers)){
                res.add(integers);
            }
        }
        for (int i = start; i < candidates.length&&residue>=candidates[i]; i++) {
            pre.add(candidates[i]);
            findCombinationSum(residue-candidates[i],i,pre,candidates,res);
            pre.pop();
        }
    }
}
