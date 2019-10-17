package _71_80;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/10/15 11:48
 */

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _79_单词搜索 {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        boolean[][] staus;
        int[][] direction;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //遍历开始字符
                staus=new boolean[n][m];
                direction=new int[n][m];
            }
        }
        return false;
    }
}
