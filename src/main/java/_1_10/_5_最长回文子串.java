package _1_10; /**
 * @author lyj
 * @version 1.0
 * @date 2019/9/5 18:33
 */

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _5_最长回文子串 {
    public static void main(String[] args) {
        String s="babad";
        System.out.println(longestPalindrome(s));
    }
    //Manacher算法

    /**
     * 1.以一个特殊字符切分原字符串
     * 2.
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null||s.length()==0) {
            return "";
        }
        String result = "";
        //1.添加分隔符
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append("陆");
            stringBuilder.append(s.charAt(i));
        }
        stringBuilder.append("陆");
        String resultChars=stringBuilder.toString();
        char[] chars = stringBuilder.toString().toCharArray();
        int[] radius =new int[chars.length];
        int R=-1,C=-1;
        int max=0;
        for (int i = 0; i < chars.length ; i++) {
            /**
             * 计算半径的位置
             * 1.当R<=i,即当前位置i在最右边界R上或R右边时，设置半径radius[i]为1，同时向外扩展
             * 同时重新设置R，与C的值。
             * 2.当R>i,即i在内时会有两种情况，比较i与它相对C的对称点的距离-和-i与R的距离
             *  2.1：i与它相对C的对称点的距离较近，此时i的半径就是它对称点的半径radius[2*C-i];中括号内是对称点坐标
             *  2.2：i与R的距离，此时i的半径就是它与R的距离R-i+1
             */
            radius[i] = R > i ? Math.min(radius[2*C-i],R-i+1):1;
            //保证半径在字符串内可以取到值
            while(i+radius[i] < chars.length && i - radius[i] > -1){
                //如果i为中心的向左右分别radius[i]个字符相同，说明还是回文，增加半径
                if(chars[i-radius[i]] == chars[i+radius[i]]){
                    radius[i]++;
                }else {
                    break;
                }
                //更新最右边界与中心位置C
                if(i + radius[i] > R){
                    R = i + radius[i]-1;
                    C = i;
                }
                max=Math.max(max,radius[i]);
                //最大半径发生改变，找出改变后的字符串
                if(max==radius[i]){
                    result = resultChars.substring(C - radius[i] + 1, C + radius[i]);
                }
                result=result.replaceAll("陆","");
            }
        }
        return result;
    }
}
