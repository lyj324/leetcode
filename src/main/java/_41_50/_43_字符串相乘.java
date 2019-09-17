package _41_50;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/9/16 19:16
 */

import java.math.BigInteger;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _43_字符串相乘 {
    public static void main(String[] args) {
        String num1="123";
        String num2="456";
        System.out.println(multiply(num1, num2));
        System.out.println(multiply2(num1, num2));
    }
    public static String multiply(String num1, String num2) {
        if("0".equals(num1)|| "0".equals(num2)){
            return "0";
        }
        int n1 = num1.length();
        int n2 = num2.length();
        StringBuilder builder = new StringBuilder();
        //设置结果集长度为n1+n2，并全部置0
        for (int i = 0; i < n1+n2; i++) {
            builder.append('0');
        }
        for (int i = n1-1; i >=0 ; i--) {
            for (int j = n2-1; j >=0 ; j--) {
                //计算当前位乘积
                int temp=builder.charAt(i+j+1)-'0'+(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                //设置当前位的值
                builder.setCharAt(i+j+1, (char) (temp%10+'0'));
                //设置进位值
                builder.setCharAt(i+j, (char) (builder.charAt(i+j)+temp/10));
            }
        }
        //去除开头的0
        String s = builder.toString();
        while (s.startsWith("0")){
            s=s.substring(s.indexOf("0")+1);
        }
        return s;
    }

    public static String multiply2(String num1, String num2) {
        BigInteger bigInteger1 = new BigInteger(num1);
        BigInteger bigInteger2 = new BigInteger(num2);
        BigInteger bigInteger3 = bigInteger1.multiply(bigInteger2);
        return bigInteger3.toString();
    }
}
