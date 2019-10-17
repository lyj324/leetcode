package _71_80;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/10/14 11:32
 */

/**
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 * <p>
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2:
 * <p>
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _72_编辑距离 {
    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(minDistance(word1, word2));
    }

    public static int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] D = new int[n1 + 1][n2 + 1];
        for (int i = 1; i < n2 + 1; i++) {
            D[0][i] = D[0][i - 1] + 1;
        }
        for (int i = 1; i < n1 + 1; i++) {
            D[i][0] = D[i - 1][0] + 1;
        }
        for (int i = 1; i < n1 + 1; i++) {
            for (int j = 1; j < n2 + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    D[i][j] = D[i - 1][j - 1];
                } else {
                    D[i][j] = Math.min(Math.min(D[i - 1][j - 1], D[i - 1][j]), D[i][j - 1]) + 1;
                }
            }
        }
        return D[n1][n2];
    }

    public static void printMap(int[][] map) {
        for (int[] ints : map) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
