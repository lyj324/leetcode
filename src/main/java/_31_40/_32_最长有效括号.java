package _31_40;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/9/12 11:42
 */

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _32_最长有效括号 {
    public static void main(String[] args) {
        String s=")()())";
        System.out.println(longestValidParentheses(s));
    }

    /**
     *
     * @param s
     * @return
     * ())((())
     * 1.用left，right记录读取到的左右括号，maxLength记录最大字符串长度
     * 2.从左向右读取括号
     *  2.1读取到'('时left增加1
     *  2.2读取到')'时right增加1
     *      2.2.1判断left与right的值是否相等，如果相等说明括号成对，需要记录是否更新maxLength
     *      2.2.2如果此时left<right，即右括号个数多。但是从左向右查询时，
     *      左括号必然大于等于右括号个数，此时这个子字符串已经不满足配对括号，重置left与right的值。
     * 示例：())((())      用{}表示已读取的括号
     * {))((())             left=1      right=0     maxLen=0    满足2.1
     * {})((())             left=1      right=1     maxLen=2    满足2.2.1
     * {}}((())             left=0      right=0     maxLen=2    满足2.2.2
     * {}}{(())             left=1      right=0     maxLen=2    满足2.1
     * {}}{{())             left=2      right=0     maxLen=2    满足2.1
     * {}}{{{))             left=3      right=0     maxLen=2    满足2.1
     * {}}{{{})             left=3      right=1     maxLen=2    满足2.2
     * {}}{{{}}             left=3      right=2     maxLen=2    满足2.2
     *
     * 3.同理从右往左扫描一遍得出最后的个数
     */
    public static int longestValidParentheses(String s) {
        int left=0,right=0,maxLength=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                left++;
            }else {
                right++;
                if(left==right){
                    maxLength=Math.max(maxLength,left<<1);
                }else if(right>left){
                    right=left=0;
                }
            }
        }
        right=left=0;
        for (int i = s.length()-1; i >-1 ; i--) {
            if(s.charAt(i) == ')'){
                right++;
            }else {
                left++;
                if(left==right){
                    maxLength=Math.max(maxLength,left<<1);
                }else if(left>right){
                    right=left=0;
                }
            }
        }
        return maxLength;
    }
}
