package _1_10; /**
 * @author lyj
 * @version 1.0
 * @date 2019/9/6 16:17
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _6_Z字形变换 {
    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        String result = "";
        //如果只有一行，直接返回结果
        if (numRows == 1) {
            return s;
        }
        //创建一个关于行的列表，最多会有min(s.length(),numRows)行
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            //给每行添加string行
            rows.add(new StringBuilder());
        }
        //定义当前行
        int curRow = 0;
        //判断是否到底与需要改变方向
        boolean goingDown = false;
        //把s从左向右遍历
        for (char c : s.toCharArray()) {
            //从0行开始添加字母
            //如果一共3行，则curRow的变化为0,1,2,1,0,1,2,1,0.....
            rows.get(curRow).append(c);
            //如果回到0行或者最后一行，表示需要改变方向
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            //当goingDown为true时向下，为false时向上
            curRow += goingDown ? 1 : -1;
        }
        //把每一行StringBuilder添加到一个StringBuilder中，转变为string，返回结果
        StringBuilder stringBuilder = new StringBuilder();
        for (StringBuilder row : rows) {
            stringBuilder.append(row);
        }
        result = stringBuilder.toString();
        return result;
    }
}
