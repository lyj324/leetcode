package _71_80;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/10/15 8:42
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _77_组合 {
    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 3);
        for (List<Integer> list:combine) {
            for (int i:list) {
                System.out.print(i );
            }
            System.out.println("");
        }
    }

    /**
     * 字典序
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> nums = new LinkedList<>();
        for (int i = 1; i < k+1; ++i) {
            nums.add(i);
        }
        nums.add(n + 1);
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        int j = 0;
        /**
         * 设置k+1位数字
         * 1,2,3,...,k,n+1
         * 1.一次从左向右比较两个数，如果是连续+1的自然数，把左边的数设置为自然数位置，
         * 右边的数+1，右移循环1
         * 2.如果出现不是连续的数左边的数+1，重新移动
         * 如n=4,k=3
         * [1,2],3,5->1,2,3,5           1.
         * 1,[2,3],5->1,2,3,5           1.
         * 1,2,[3,5]->1,2,4,5           2.
         * [1,2],4,5->1,2,4,5           1.
         * 1,[2,4],5->1,3,4,5           2.
         * [1,3],4,5->2,3,4,5           2.
         * [2,3],4,5->1,3,4,5           1.
         * 1,[3,4],5->1,2,4,5           1.
         * 1,2,[4,5]->1,2,3,5           1.
         * 如果移动到最右边还执行1，则退出外层循环
         */
        while (j<k){
            output.add(new LinkedList(nums.subList(0, k)));
            j = 0;
            while ((j < k) && (nums.get(j + 1) == nums.get(j) + 1)){
                nums.set(j, j++ + 1);
            }
            nums.set(j, nums.get(j) + 1);
        }
        return output;
    }
}
