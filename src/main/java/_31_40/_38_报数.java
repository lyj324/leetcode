package _31_40;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/9/16 11:34
 */

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 *
 * 注意：整数顺序将表示为一个字符串。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "1211"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-and-say
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _38_报数 {
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
    public static String countAndSay(int n) {
        String[] result=new String[n];
        result [0]="1";
        for (int i = 1; i <n ; i++) {
            result[i] = countAndSay(result[i - 1]);
        }
        return result[n-1];
    }

    /**
     *
     * @param s
     * @return
     * 1.输入字符串s
     * 2.读取s的除最后一位的每一位字字符。
     * 3.1如果s的第i位，与i+1位相同，计数符count（初始值为1）自增。
     * 3.2如果s的第i位，与i+1位不同，说明读取到此字符的最后一位，记录计数字符count，与表意字符
     * s[i].
     * 4最后以String形式返回。
     */
    public static String countAndSay(String s){
        StringBuilder builder = new StringBuilder();
        int count=1;
        for (int i = 0; i < s.length(); i++) {
            if(i<s.length()-1&&s.charAt(i)==s.charAt(i+1)){
                count++;
            }else {
                builder.append(count).append(s.charAt(i));
                count=1;
            }
        }
        return builder.toString();
    }
}
