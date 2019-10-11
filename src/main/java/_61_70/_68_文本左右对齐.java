package _61_70;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/10/11 10:01
 */

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 *
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 *
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 *
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 *
 * 说明:
 *
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * 示例:
 *
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * 示例 2:
 *
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。
 *      第二行同样为左对齐，这是因为这行只包含一个单词。
 * 示例 3:
 *
 * 输入:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/text-justification
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _68_文本左右对齐 {
    public static void main(String[] args) {
        String[] words={"This", "is", "an", "example", "of", "text", "justification."};
        words= new String[]{ "Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        int maxWidth = 16;
        maxWidth=20;
        List<String> list = fullJustify(words, maxWidth);
        for (String s:list) {
            System.out.println(s);
        }
    }
    public static List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> result = new ArrayList<>();
        int nowWordsNum=0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if(nowWordsNum==0){
                nowWordsNum+=words[i].length();
                builder.append(words[i]);
            }else {
                nowWordsNum++;
                nowWordsNum+=words[i].length();
                if(nowWordsNum<=maxWidth){
                    builder.append(" "+words[i]);
                }else {
                    StringBuilder e = new StringBuilder(builder.toString());
                    String[] s = e.toString().split(" ");
                    int k=0;
                    int space=maxWidth-e.length()+s.length-1;
                    for (int j = 0; j < space; j++) {
                        s[k]+=" ";
                        k++;
                        if(k>s.length-2){
                            if(s.length-1!=0){
                                k%=(s.length-1);
                            }else {
                                k--;
                            }
                        }
                    }
                    e.delete(0,e.length());
                    for (int j = 0; j < s.length; j++) {
                        e.append(s[j]);
                    }
                    result.add(e.toString());
                    builder.delete(0,builder.length());
                    nowWordsNum=0;
                    i--;
                }
            }
        }
        String s = builder.toString();
        while (s.length()<maxWidth){
            s+=" ";
        }
        result.add(s);
        return result;
    }
}
