package _81_90;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/10/20 10:23
 */

/**
 * 给定一个字符串 s1，我们可以把它递归地分割成两个非空子字符串，从而将其表示为二叉树。
 *
 * 下图是字符串 s1 = "great" 的一种可能的表示形式。
 *
 *     great
 *    /    \
 *   gr    eat
 *  / \    /  \
 * g   r  e   at
 *            / \
 *           a   t
 * 在扰乱这个字符串的过程中，我们可以挑选任何一个非叶节点，然后交换它的两个子节点。
 *
 * 例如，如果我们挑选非叶节点 "gr" ，交换它的两个子节点，将会产生扰乱字符串 "rgeat" 。
 *
 *     rgeat
 *    /    \
 *   rg    eat
 *  / \    /  \
 * r   g  e   at
 *            / \
 *           a   t
 * 我们将 "rgeat” 称作 "great" 的一个扰乱字符串。
 *
 * 同样地，如果我们继续交换节点 "eat" 和 "at" 的子节点，将会产生另一个新的扰乱字符串 "rgtae" 。
 *
 *     rgtae
 *    /    \
 *   rg    tae
 *  / \    /  \
 * r   g  ta  e
 *        / \
 *       t   a
 * 我们将 "rgtae” 称作 "great" 的一个扰乱字符串。
 *
 * 给出两个长度相等的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。
 *
 * 示例 1:
 *
 * 输入: s1 = "great", s2 = "rgeat"
 * 输出: true
 * 示例 2:
 *
 * 输入: s1 = "abcde", s2 = "caebd"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/scramble-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _87_扰乱字符串 {
    public static void main(String[] args) {
        String s1="great";
        String s2="rgeat";
        System.out.println(isScramble(s1, s2));
    }

    /**
     * 如果两个字符串可以扰乱，他们所包含的英文字母种类个数相同
     * 否则返回false；
     * 如果可以分割
     * 必然存在字符串s1 [A1,B1] s2[A2,B2] 其中A1为A2的扰乱字符，B1为B2的扰乱字符
     * 或者存在字符串s1 [A1,B1] s2[B2,A2] 其中A1为A2的扰乱字符，B1为B2的扰乱字符
     * 列举每种切割方法，比较s1 s2是否存在扰乱字符
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        int[] letters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) {
                return false;
            }
        }
        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) {
                return true;
            }
        }
        return false;
    }
}
