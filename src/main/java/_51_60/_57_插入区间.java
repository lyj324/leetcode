package _51_60;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/10/9 18:59
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 示例 2:
 *
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _57_插入区间 {
    public static void main(String[] args) {
        int[][] intervals ={
                {1,2},
                {3,5},
                {6,7},
                {8,10},
                {12,16}
        };
        int[] newInterval = {4,8};
        print(insert(intervals,newInterval));
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        if(newInterval.length == 0){
            return intervals;
        }
        List<int[]> allInterval = new ArrayList<>(Arrays.asList(intervals));
        allInterval.add(newInterval);
        int[][] ints = allInterval.toArray(new int[0][]);
        //按区间left升序排序
        Arrays.sort(ints, Comparator.comparingInt(a -> a[0]));
        int i = 0;
        //指针向后移动，更新left与right
        while (i < ints.length) {
            int left = ints[i][0];
            int right = ints[i][1];
            //当存在下一个数,且下一个数left在已有范围内,说明需要更新right的值
            while (i < ints.length - 1 && ints[i + 1][0] <= right) {
                i++;
                //更新right的值
                right = Math.max(right, ints[i][1]);
            }
            //更新结果集
            res.add(new int[]{left, right});
            i++;
        }
        return res.toArray(new int[0][]);
    }
    private static void print(int[][] intervals) {
        for (int[] ints : intervals) {
            System.out.print("{" + ints[0] + "," + ints[1] + "} ");
        }
        System.out.println("");
    }
}
