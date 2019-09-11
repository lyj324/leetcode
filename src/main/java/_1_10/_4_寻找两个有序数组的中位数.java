package _1_10; /**
 * @author lyj
 * @version 1.0
 * @date 2019/9/4 16:29
 */

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _4_寻找两个有序数组的中位数 {
    public static void main(String[] args) {
        int[] nums1={1,3};
        int[] nums2={2};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    /**
     * 1.比较数组，把短的数组作为1，长的作为2
     * 2.把两个数组都分成左右两部分，确保左部长度等于右部（总个数为偶数时），左部长度比右部大一（总个数为奇数）
     * 3.当数组1左部最大值小于等于，数组2右部最小值；同时数组2左部最大值小于等于数组1右部最小值
     * 即可找出中位数。
     *           left_part          |        right_part
     *     A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
     *     B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
     *
     *  3.1，使m<=n，此时j=（m+n+1）/2-i;即i+j=m-i+j-n+1
     * 4.在范围[0,m]（[imin,imax]）搜索，采用二分查找。
     *  4.1使i=(imin+imax)/2,j随i改变;
     *  4.2 出现B[j−1]≤A[i] 且 A[i−1]≤B[j],查找结束
     *  4.3 出现B[j−1]>A[i]时i太小,调整范围为[i+1,imax],需要确保i<imin
     *  4.4 出现A[i−1]>B[j]时i太大,调整范围为[imin,i-1],需要确保i>imax
     * 5结束4的循环后，分m+n为奇数与偶数两种情况
     *  5.1 奇数：max(A[i−1],B[j−1])
     *  5.2 偶数：(max(A[i−1],B[j−1])+min(A[i],B[j]))/2
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length,n=nums2.length;
        //确保数组1长度小于等于(<=)数组2
        if(m>n){
            int[] temp=nums1;
            nums1=nums2;
            nums2=temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int imin=0,imax=m;
        int halfLen=(m+n+1)/2;
        //当范围有效时进行计算
        while (imin<=imax){
            int i=(imin+imax)/2;
            int j=halfLen-i;
            //4.3 范围太靠左
            if(i<imax&&nums2[j-1]>nums1[i]){
                imin=i+1;
            }
            //4.4 范围太靠右
            else if(i>imin&&nums1[i-1]>nums2[j]){
                imax=i-1;
            }
            //满足结果，找到合适的分组方式
            else {
                //设置左部最大值
                int maxLeft=0;
                //num1左部为空
                if(i==0){
                    maxLeft=nums2[j-1];
                }
                //num2左部为空
                else if(j==0){
                    maxLeft=nums1[i-1];
                }
                else {
                    maxLeft=Math.max(nums1[i-1],nums2[j-1]);
                }
                //左个数为奇数时，直接返回左部最大值
                //应为左部比右部长1，最大值即为中位数
                if((m+n)%2==1){
                    return maxLeft;
                }
                //执行到此步说明为偶数
                int minRight=0;
                //num1右部为空
                if(i==m){
                    minRight=nums2[j];
                }
                //num2右部为空
                else if(j==n){
                    minRight=nums1[i];
                }
                else {
                    minRight=Math.min(nums1[i],nums2[j]);
                }
                //把int 转变为 double
                return (maxLeft+minRight)/2.0;
            }
        }
        //没找到
        return 0.0;
    }
}
