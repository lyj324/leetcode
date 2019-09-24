package _41_50;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/9/23 19:03
 */

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _50_Pow {
    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 8));
    }
    public static double myPow(double x, int n) {
        long N = n;
        //判断n的正负，如果n为负数，将pow（x,n）转变为pow（1/x，-n）
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double current_product = x;
        //折半计算，每两个数相乘
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                //如果出现乘数剩余个数为奇数，单独乘一次，
                //无论乘多少次，最后一次i一定等于1，会进入这个if
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
        }
        return ans;
        //return Math.pow(x,n);
    }
}
