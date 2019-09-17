package _41_50; /**
 * @author lyj
 * @version 1.0
 * @date 2019/9/16 20:25
 */

/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 *
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例 4:
 *
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 示例 5:
 *
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输入: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wildcard-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _44_通配符匹配 {
    public static void main(String[] args) {
        String s="abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb";
        String p="**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";
        System.out.println(isMatch(s, p));
    }
    public static boolean isMatch(String s, String p) {
        //去除p中连续的*
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < p.length(); i++) {
            String substring = null;
            if(i!=0) {
                substring = builder.substring(builder.length()-1);
            }
            if(!("*".equals(substring)&&p.charAt(i)=='*')) {
                builder.append(p.charAt(i));
            }
        }
        p=builder.toString();
        int sL=0,pL=0,match=0,start=-1;
        //遍历整个字符串
        while (sL<s.length()){
            // 一对一匹配，两指针同时后移。
            //pL<p.length()保证不溢出
            //p.charAt(pL)=='?'时匹配任意一个字符
            //p.charAt(pL)==s.charAt(sL)时匹配指定字符
            if(pL<p.length()&&(p.charAt(pL)=='?'||p.charAt(pL)==s.charAt(sL))){
                pL++;
                sL++;
            }
            // 碰到 *，假设它匹配空串，并且用 start 记录 * 的位置，记录当前字符串的位置，p 后移
            else if(pL<p.length()&&p.charAt(pL)=='*'){
                start=pL;
                match=sL;
                pL++;
            }
            // 当前字符不匹配，并且也没有 *，回退
            // p 回到 * 的下一个位置
            // match 更新到下一个位置
            // s 回到更新后的 match
            // 这步代表用 * 匹配了一个字符
            //start!=-1表示可以回退
            else if(start!=-1){
                pL=start+1;
                sL=++match;
            }else {
                return false;
            }
        }
        //将末尾多余的 * 直接匹配空串 例如 s = ab, p = a*******
        while (pL < p.length() && p.charAt(pL) == '*') {
            pL++;
        }
        return pL == p.length();
    }

    /**
     * 过于复杂的会超时
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch2(String s, String p) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < p.length(); i++) {
            String substring = null;
            if(i!=0) {
                substring = builder.substring(builder.length()-1);
            }
            if(!("*".equals(substring)&&p.charAt(i)=='*')) {
                builder.append(p.charAt(i));
            }
        }
        p=builder.toString();
        p=p.replaceAll("\\*",".*").replaceAll("\\?",".");
        return s.matches(p);
    }
}
