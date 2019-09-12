package _21_30;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/9/11 20:25
 */

import java.util.*;

/**
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 * <p>
 * 输入：
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * 输出：[]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _30_串联所有单词的子串 {
    public static void main(String[] args) {
        String[] words = {"dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty","modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb"};
        String s="pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";
        List<Integer> substring = findSubstring(s, words);
        System.out.println(substring.toString());
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int wordNum = words.length;
        if (wordNum == 0) {
            return res;
        }
        int wordLen = words[0].length();
        //存放所有words出现次数
        HashMap<String,Integer> map1=new HashMap<>();
        for (String word:words) {
            //如果word还不在map1中设置默认值为0，如果存在去除value的值
            Integer value = map1.getOrDefault(word, 0);
            //把key为word的value+1
            map1.put(word,value+1);
        }
        //滑块滑动字符串s，一次判断words[]所有单词长度的数
        //需要执行s的长度-所有单词的长度+1
        for (int i = 0; i < s.length()-wordLen*wordNum+1; i++) {
            //HashMap2 存当前扫描的字符串含有的单词
            HashMap<String, Integer> map2 = new HashMap<>();
            //记录所有单词遍历到第几个
            int num = 0;
            //当单词没有遍历完
            while (num<wordNum){
                //此时滑块已经移动到s的第i位
                //把第s的第i位以后的字符串的第num个单词截取出来
                String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                //判断这个单词是否在map1中
                if (map1.containsKey(word)) {
                    //在map2中记录这个单词出现的次数
                    int value = map2.getOrDefault(word, 0);
                    map2.put(word, value + 1);
                    //判断当前单词的 value 和 HashMap1 中该单词的 value
                    if (map2.get(word) > map1.get(word)) {
                        //如果这个单词比map1出现次数还多，说明这个滑块目前所在位置不对
                        break;
                    }
                } else {
                    //说明这个单词不存在于map1，此滑块目前位置不对
                    break;
                }
                //查看下一个单词长度的字符串
                num++;
            }
            //判断是不是所有的单词都符合条件
            if (num == wordNum) {
                res.add(i);
            }
        }
        return res;
    }

    /**
     * 单词个数太多会超时
     */
//    private static List<String> allString=new ArrayList<>();
//    public static List<Integer> findSubstring(String s, String[] words) {
//        List<Integer> res = new ArrayList<>();
//        if (s == null || s.length() == 0 || words == null || words.length == 0) {
//            return res;
//        }
//        allString.clear();
//        listAll(Arrays.asList(words), "");
//        for (String s1:allString) {
//            int i=0;
//            while (i!=-1){
//                i = s.indexOf(s1,i);
//                if(i==-1){
//                    break;
//                }
//                res.add(i);
//                i++;
//            }
//        }
//        return res;
//    }
//    public static void listAll(List candidate, String prefix) {
//        if (candidate.isEmpty()) {
//            if(!allString.contains(prefix)) {
//                allString.add(prefix);
//            }
//        }
//        for (int i = 0; i < candidate.size(); i++) {
//            List temp = new ArrayList(candidate);
//            Object remove = temp.remove(i);
//            listAll(temp, prefix + remove);
//        }
//    }
}
