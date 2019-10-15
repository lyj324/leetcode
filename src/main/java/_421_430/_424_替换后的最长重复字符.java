package _421_430;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/10/15 21:27
 */

/**
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 *
 * 注意:
 * 字符串长度 和 k 不会超过 104。
 *
 * 示例 1:
 *
 * 输入:
 * s = "ABAB", k = 2
 *
 * 输出:
 * 4
 *
 * 解释:
 * 用两个'A'替换为两个'B',反之亦然。
 * 示例 2:
 *
 * 输入:
 * s = "AABABBA", k = 1
 *
 * 输出:
 * 4
 *
 * 解释:
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _424_替换后的最长重复字符 {
    public static void main(String[] args) {
        String s="aabaabaa";
        int k=1;
        System.out.println(characterReplacement(s, k));
    }

    /**
     * dict的字典用来记录每一个字符出现的次数（在window内）
     * l，r表示window的左右边界，r< len(s),maxLen记录出现了最多次数的字符，每次更新maxLen，当（r-l+1）-maxLen 也就是window的长度-出现了最多次数的字符，与k（可以改变的字符的个数）相比，如果大于k说明，window已经不满足要求了，需要从左边缩window
     * 更新res，max（res，len（window））
     * r++不断扩window
     * @param s
     * @param k
     * @return
     */
    public static int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int l = 0, r = 0, res = 0;
        int[] dict = new int[256];
        int maxLen = 0;
        while (r < s.length()) {
            dict[s.charAt(r)]++;
            maxLen = Math.max(maxLen, dict[s.charAt(r)]);
            while ((r - l + 1 - maxLen) > k) {
                dict[s.charAt(l++)]--;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}
