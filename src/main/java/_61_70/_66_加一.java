package _61_70;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/10/11 8:45
 */

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _66_加一 {
    public static void main(String[] args) {
        int[] digits={9};
        Arrays.stream(plusOne(digits)).forEach(System.out::print);
    }
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >-1 ; i--) {
            digits[i]++;
            if(digits[i]<10){
                break;
            }else {
                digits[i]%=10;
            }
        }
        if(digits[0]==0){
            int[] res = new int[digits.length+1];
            res[0]=1;
            for (int i = 1; i < digits.length+1; i++) {
                res[i]=digits[i-1];
            }
            return res;
        }
        return digits;
    }
}
