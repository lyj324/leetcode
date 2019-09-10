package _0_20; /**
 * @author lyj
 * @version 1.0
 * @date 2019/9/4 14:23
 */


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _3_无重复字符的最长子串 {
    public static void main(String[] args) {
        //String s="wobgrovw";
        String s="abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        //s为字符串长度，result为结果
        int n=s.length(),result=0;
        //hashmap存储 '字符' ，所在位置
        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
        //遍历所有字符
        for (int j = 0, i = 0; j < n; j++) {
            //如果map中个存在此字符
            if (characterIntegerHashMap.containsKey(s.charAt(j))) {
                //设置i为此字符最后出现的位置，即新的起点。
                i = Math.max(characterIntegerHashMap.get(s.charAt(j)), i);
            }
            //结果为为原result 与 此时所在位置 j 减去 起始位置 i  加1 比较取大值
            result = Math.max(result, j - i + 1);
            characterIntegerHashMap.put(s.charAt(j), j + 1);
        }
        return result;
    }
}
