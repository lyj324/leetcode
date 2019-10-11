package _61_70;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/10/11 9:11
 */

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _67_二进制求和 {
    public static void main(String[] args) {
        String a="10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b="110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        a="10";
        b="10";
        System.out.println(addBinary(a, b));
    }
    public static String addBinary(String a, String b) {
//        直接运算
//        BigInteger bigIntegerA = new BigInteger(a, 2);
//        BigInteger bigIntegerB = new BigInteger(a, 2);
//        String s = bigIntegerA.add(bigIntegerB).toString(2);
//        return s;
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for(int i = a.length() - 1, j = b.length() - 1;i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }
}
