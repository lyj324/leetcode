package _1_10; /**
 * @author lyj
 * @version 1.0
 * @date 2019/9/4 11:07
 */

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _2_两数相加 {
    public static <listNode> void main(String[] args) {
        ListNode listNode1_1 = new ListNode(5);
//        ListNode listNode1_2 = new ListNode(4);
//        ListNode listNode1_3 = new ListNode(3);
//        listNode1_1.next=listNode1_2;
//        listNode1_2.next=listNode1_3;
        ListNode listNode2_1 = new ListNode(5);
//        ListNode listNode2_2 = new ListNode(6);
//        ListNode listNode2_3 = new ListNode(4);
//        listNode2_1.next=listNode2_2;
//        listNode2_2.next=listNode2_3;
        ListNode listNodeResult=addTwoNumbers(listNode1_1,listNode2_1);
        System.out.println(listNodeResult.val+"->"+listNodeResult.next.val);
    }

    public static class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1,l2,null);
    }
    /**
     *
     * @param l1 当前链表1
     * @param l2 当前链表2
     * @param prev 当前链表前节点(前节点以计算完毕)
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2, ListNode prev) {
        //当前链表1下一节点值
        ListNode next1 = null;
        //当前链表2下一节点值
        ListNode next2 = null;
        //当前链表1的值
        int val1 = 0;
        //当前链表2的值
        int val2 = 0;
        if(l1!=null){
            val1=l1.val;
            next1=l1.next;
        }
        if(l2!=null){
            val2=l2.val;
            next2=l2.next;
        }
        //当前节点和的节点
        ListNode newNode=new ListNode(val1+val2);
        //如果存在前置节点
        if (prev != null) {
            //如果前置节点需要进位
            if (prev.val >= 10) {
                //进位操作
                prev.val %= 10;
                newNode.val += 1;
            }
        }
        //如果存在后继节点
        if(next1!=null||next2!=null){
            //递归操作后继节点
            newNode.next=addTwoNumbers(next1,next2,newNode);
        }
        //如果均不存在后继节点，但是最后一位有进位
        else if(newNode.val>=10){
            newNode.next=addTwoNumbers(next1,next2,newNode);
        }
        return newNode;
    }
}
