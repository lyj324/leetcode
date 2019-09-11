package _11_20; /**
 * @author lyj
 * @version 1.0
 * @date 2019/9/7 11:17
 */

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _14_最长公共前缀 {
    public static void main(String[] args) {
        String[] strs={"aa","aa","aa"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null||strs.length==0) {
            return "";
        }
        String Prefix="";
        String result="";
        int start=0,end=0,mid=0;
        int maxPrefixLen=Integer.MAX_VALUE;
        for (String s:strs) {
            maxPrefixLen=Math.min(s.length(),maxPrefixLen);
        }
        Prefix=strs[0].substring(0,maxPrefixLen);
        //substring包前不包后
        end=Prefix.length()+1;
        String temp = null;
        boolean flag=true;
        while (true){
            mid=(start+end)/2;
            //截取前一半
            temp=Prefix.substring(start,mid);
            for (String s:strs) {
                //如果有任意一个字符串不是temp开头的，flag置false
                if(!s.startsWith(result+temp)){
                    flag=false;
                }
            }
            //说明左部分全部在公共前缀上，抛弃左部分（把结果记录），从右部分二分查找
            if(flag){
                //全部加入结果集
                result+=temp;
                //计算后半段
                start=mid;
            }
            //说明左部分不是公共前缀，可能左部分取得太长，抛弃右部分，对左部分继续二分查找
            else {
                end=mid;
                flag=true;
            }
            //遍历完毕
            if(end-start==1){
                break;
            }
        }
        return result;
    }
}
