package _0_20;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/9/11 9:41
 */

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _20_有效的括号 {
    public static void main(String[] args) {
        String s="([)]";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c=='('||c=='['||c=='{'){
                //入栈
                stack.push(c);
            }else {
                if(stack.empty()){
                    return false;
                }
                //   ()的ASCII差1，{}[]的ASCII差2
                Character poll = stack.pop();
                if(poll!=c-1&&poll!=c-2){
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
