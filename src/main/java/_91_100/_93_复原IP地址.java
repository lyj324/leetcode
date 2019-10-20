package _91_100;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/10/20 15:32
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _93_复原IP地址 {
    public static void main(String[] args) {
        String s="25525511135";
        restoreIpAddresses(s).forEach(System.out::println);
    }
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        backtrack(0, "", 4, s, res, n);
        return res;
    }
    private static void backtrack(int i, String tmp, int flag, String s, List<String> res, int n) {
        if (i == n && flag == 0) {
            res.add(tmp.substring(0, tmp.length() - 1));
            return;
        }
        if (flag < 0) {
            return;
        }
        for (int j = i; j < i + 3; j++) {
            if (j < n) {
                if (i == j && s.charAt(j) == '0') {
                    backtrack(j + 1, tmp + s.charAt(j) + ".", flag - 1, s, res, n);
                    break;
                }
                if (Integer.parseInt(s.substring(i, j + 1)) <= 255) {
                    backtrack(j + 1, tmp + s.substring(i, j + 1) + ".", flag - 1, s, res, n);
                }
            }
        }
    }
}
