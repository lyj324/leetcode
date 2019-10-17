package _71_80;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/10/14 18:24
 */

import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _75_颜色分类 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        sortColors(nums);
        Arrays.stream(nums).forEach(n -> System.out.print(n + " "));
    }

    public static void sortColors(int[] nums) {
        //左指针指向数组开头
        int p1 = 0;
        //右指针指向数组结尾
        int p2 = nums.length - 1;
        //指向当前操作数
        int now = 0;
        //当当前操作数在右指针左边
        while (now <= p2) {
            //如果当前数为0，把它放到尽量左的位置，即左指针的位置
            if (nums[now] == 0) {
                //交换当前位置值与左指针位置值
                swap(nums, p1, now);
                //当前数右移
                now++;
                //做指正右移
                p1++;
                //如果当前数为1，不必改变他的值，当前值右移
            } else if (nums[now] == 1) {
                now++;
                //如果当前数为2，把它放到尽量右的位置，即右指针的位置
            } else if (nums[now] == 2) {
                //交换当前位置值与右指针位置值
                swap(nums, p2, now);
                //右指针左移
                p2--;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }
}
