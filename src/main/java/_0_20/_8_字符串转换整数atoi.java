package _0_20; /**
 * @author lyj
 * @version 1.0
 * @date 2019/9/6 17:39
 */

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 *
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * 说明：
 *
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *
 * 示例 1:
 *
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 *
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 *
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 *
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。
 * 示例 5:
 *
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _8_字符串转换整数atoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("+"));
    }
    public static int myAtoi(String str) {
        if (str == null || (str = str.trim()).isEmpty()) {
            return 0;
        }
        int result=0;
        //正负号
        boolean sign =true;
        int start=0;
        char firstChar = str.charAt(0);
        if(firstChar=='+'){
            //从第二位开始
            start++;
        }
        else if(firstChar=='-'){
            //改变符号位
            sign=false;
            //从第二位开始
            start++;
        }
        //若果第一个字符不是数字,+,-
        else if(!Character.isDigit(firstChar)){
            return 0;
        }
        StringBuilder builder=new StringBuilder();
        //向后遍历字符串
        for (int i = start; i < str.length(); i++) {
            //如果不是数字，跳出循环
            if(!Character.isDigit(str.charAt(i))){
                break;
            }
            //添加入StringBuilder
            builder.append(str.charAt(i));
        }
        try {
            String s = builder.toString();
            //防止只有1个符号位，或者符号位后面紧接着跟着非数字
            if(s.length()==0){
                return 0;
            }
            //负数添加负号
            if(!sign){
                s="-"+s;
            }
            //字符串转数字，抛出异常时表示溢出，根据符号返回最大或最小int
            result=Integer.parseInt(s);
        }catch (Exception e){
            return sign?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        return result;
    }
}
