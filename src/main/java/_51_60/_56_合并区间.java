package _51_60;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/10/9 18:10
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _56_合并区间 {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        print( merge(intervals));
    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if(intervals==null||intervals.length == 0 ){
            return res.toArray(new int[0][]);
        }
        //按区间left升序排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int i = 0;
        //指针向后移动，更新left与right
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            //当存在下一个数,且下一个数left在已有范围内,说明需要更新right的值
            while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
                i++;
                //更新right的值
                right = Math.max(right, intervals[i][1]);
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
