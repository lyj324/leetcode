package _91_100;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/10/20 14:12
 */

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _91_解码方法 {
    public static void main(String[] args) {
        String s="12";
        System.out.println(numDecodings(s));
    }
    public static int numDecodings(String s) {
        //如果字符串以0开头说明不能组成字母（0出现的情况仅为10k/20u）
        if(s.charAt(0)=='0'){
            return 0;
        }
        //dp[-1] = dp[0] = 1
        //这是一个有限制条件的f（n）=f（n-1）+f(n-2)的数列
        int pre = 1, curr = 1;
        for (int i = 1; i < s.length(); i++) {
            //暂时赋值tmp为f(n-1)
            int tmp = curr;
            //如果出现0，且满足0前一位是1或者2
            //应为0需要和前一位一起组合所以f(n)=f(n-2)
            //       (n-2)  (n-1)   0
            //       pre    cuur
            //修改为         cuur   pre
            //即此时交换了cuur与pre的值
            //执行了    ①tmp = curr
            //          ② curr = pre
            //          ③pre = tmp
            if(s.charAt(i)=='0'){
                if(s.charAt(i-1)=='1'||s.charAt(i-1)=='2'){
                    curr = pre;
                }
                else {
                    //否则0无法组成字母解码失败返回0
                    return 0;
                }
            }
            //如果当前数字不是0，只要满足前一位是1，或者前一位是2，当前位为1-6
            //f(n)=f(n-1)+f(n-2)
            //执行了
            //①tmp = curr
            //②curr = curr + pre
            //③pre = tmp
            //       (n-2)        (n-1)             n
            //       pre          cuur
            //修改为               cuur           pre+cuur
            else if(s.charAt(i-1)=='1'||(s.charAt(i-1)=='2'&&s.charAt(i)>='1'&&s.charAt(i)<='6')){
                curr = curr + pre;
            }
            pre = tmp;
        }
        return curr;
    }
}
