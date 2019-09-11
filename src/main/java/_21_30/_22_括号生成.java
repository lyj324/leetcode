package _21_30;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/9/11 12:28
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _22_括号生成 {
    public static void main(String[] args) {
        int n=3;
        System.out.println(generateParenthesis(n));
    }

    /**
     * @param n
     * @return
     * 1.需要生成n对括号
     * 2.生成第一对括号()，此时还剩n-1对括号
     *  2.1这n-1对括号一定在   (A)B   A,B两个位置出现
     *  2.2：A的范围是0到n-1，应为A+B=n-1，可以计算出B的范围是n-1到0
     */
    public static List<String> generateParenthesis(int n) {
        List<String> result =new ArrayList<>();
        if(n==0){
            result.add("");
        }else {
            //一共还需要填n-1对括号
            for (int i = 0; i < n; i++) {
                //递归左部分的情况
                for (String left:generateParenthesis(i)) {
                    //递归右部分的情况
                    for (String right:generateParenthesis(n-1-i)) {
                        result.add("("+left+")"+right);
                    }
                }
            }
        }
        return result;
    }
}
