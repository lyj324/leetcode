package _51_60;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/10/9 19:18
 */

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _58_最后一个单词的长度 {
    public static void main(String[] args) {
        String s = "a ";
        System.out.println(lengthOfLastWord(s));
    }
    public static int lengthOfLastWord(String s) {
        s = s.trim();
        int i=0;
        for (int j = s.length()-1; j >=0 ; j--) {
            if(s.charAt(j)!=' '){
                i++;
            }else {
                break;
            }
        }
        return i;
    }
}
