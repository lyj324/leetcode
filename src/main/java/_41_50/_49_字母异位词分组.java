package _41_50;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/9/23 18:38
 */

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _49_字母异位词分组 {
    public static void main(String[] args) {
        String[] strs={"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    /**
     * 不能直接用char的ascll码
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s:strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String value = String.valueOf(chars);
            if (!map.containsKey(value)) {
                map.put(value,new ArrayList<>());
            }
            map.get(value).add(s);
        }
        return new ArrayList(map.values());
    }
}
