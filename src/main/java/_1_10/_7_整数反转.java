package _1_10; /**
 * @author lyj
 * @version 1.0
 * @date 2019/9/6 16:55
 */

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _7_整数反转 {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
    public static int reverse(int x) {
        int restult =0;
        while (x!=0){
            //出栈x的最高位，用pop记录
            int pop=x%10;
            x/=10;
            //判断是否溢出
            /**
             * 1.正数时restult=pop*10+restult>Integer.MAX_VALUE时会溢出
             *  1.1 pop>Integer.MAX_VALUE/10时一定溢出
             *  1.2 pop=Integer.MAX_VALUE/10时可以计算
             *  Integer.MAX_VALUE-Integer.MAX_VALUE/10*10=7
             *  即pop>7时会溢出
             * 2.负数时restult=pop*10+restult<-Integer.MIN_VALUE时会溢出
             *  2.1 pop<Integer.MIN_VALUE/10时一定溢出
             *  2.2 pop=Integer.MIN_VALUE/10时可以计算
             *  -(-Integer.MIN_VALUE+Integer.MIN_VALUE/10*10)=-8
             *  即pop<-8时会溢出
             */
            if(restult>Integer.MAX_VALUE/10||restult<Integer.MIN_VALUE/10||(restult==Integer.MAX_VALUE/10&&pop> Integer.MAX_VALUE % 10)||(restult==Integer.MIN_VALUE/10&&pop<Integer.MIN_VALUE % 10)){
                return 0;
            }
            //入栈到result中
            restult=pop+restult*10;
        }
        return restult;
    }
}
