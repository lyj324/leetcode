package _71_80;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/10/14 18:47
 */

import java.util.*;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _76_最小覆盖子串 {
    public static void main(String[] args) {
        String S="AA";
        String T="AA";
        S="aaaaaaaaaaaabbbbbcdd";
        T="abcdd";
        System.out.println(minWindow(S, T));
    }
    public static String minWindow(String s, String t) {
        Map<Character, Integer> lookup = new HashMap<>();
        //把s中的字符写入lookup，key为单词，值为0
        for (char c : s.toCharArray()) {
            lookup.put(c, 0);
        }
        //检查t中单词是否存在于lookup，存在把值置为当前值+1(用于记录需要出现多少次)。有一个单词不存在，返回""
        for (char c : t.toCharArray()) {
            if (lookup.containsKey(c)) {
                lookup.put(c, lookup.get(c) + 1);
            } else {
                return "";
            }
        }
        //start用于缩小范围
        int start = 0;
        //end用于扩大范围
        int end = 0;
        //min_len用于记录最小长度
        int min_len = Integer.MAX_VALUE;
        //counter用于记录start-end范围内已经放入的单词>0时需要扩大范围(end右移)，=0时尝试缩小范围(start右移)
        int counter = t.length();
        String res = "";
        //当end还未到s末尾时循环
        while (end < s.length()) {
            //读取end位置单词用于扩大范围
            char c1 = s.charAt(end);
            if (lookup.get(c1) > 0) {
                counter--;
            }
            lookup.put(c1, lookup.get(c1) - 1);
            end++;
            //知道counter==0时全部单词已在范围内,尝试缩小范围
            while (counter == 0) {
                //更新最小长度与最小长度的字串
                if (min_len > end - start) {
                    min_len = end - start;
                    res = s.substring(start, end);
                }
                char c2 = s.charAt(start);
                //如果已经缩小范围到极限,本次执行完后需要尝试向右重新扩大范围
                if (lookup.get(c2) == 0) {
                    counter++;
                }
                lookup.put(c2, lookup.get(c2) + 1);
                start++;
            }
        }
        return res;
    }
}
