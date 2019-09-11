package _21_30;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/9/11 18:51
 */

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _29_两数相除 {
    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1));
    }
    public static int divide(int dividend, int divisor) {
        long y=Math.abs(((long)dividend));
        long x=Math.abs(((long)divisor));
        long result=0;
        while (y>=x){
            int i=1;
            while (y-(x<<i)>0){
                i++;
            }
            y-=(x<<(i-1));
            result += (1 << (i-1));
        }
        if(dividend > 0 ^ divisor > 0) {
            result = -result;
        }
        if(result >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if(result <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)result;
    }
}
