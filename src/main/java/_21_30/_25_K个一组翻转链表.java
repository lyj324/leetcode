package _21_30;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/9/11 16:06
 */

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _25_K个一组翻转链表 {
    public static void main(String[] args) {
        ListNode listNode1_1 = new ListNode(1);
        ListNode listNode1_2 = new ListNode(2);
        ListNode listNode1_3 = new ListNode(3);
        ListNode listNode1_4 = new ListNode(4);
        ListNode listNode1_5 = new ListNode(5);
        listNode1_1.next=listNode1_2;
        listNode1_2.next=listNode1_3;
        listNode1_3.next=listNode1_4;
        listNode1_4.next=listNode1_5;
        PrintList(reverseKGroup(listNode1_1,2));
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        //为原节点添加虚节点
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        //添加已处理节点的最后一位节点，它的下一个节点就是倒置节点的第一位
        ListNode pre=dummy;
        //添加倒置节点的最后一位
        ListNode end=dummy;
        //当end为到最后时一直执行
        while (end.next!=null){
            //end向后移动k位，需要保证end不为空
            for (int i = 0; i < k && end!=null; i++) {
                end=end.next;
            }
            //最后一次移动end有可能变为空，此时说明剩下的未处理数小于k值，不用倒置，直接跳出
            if(end==null){
                break;
            }
            //添加还未处理的节点，即end后的节点
            ListNode next =end.next;
            //添加倒置起始节点
            ListNode start =pre.next;
            //打断end与未处理节点的连接
            end.next=null;
            //在已处理节点后添加此次倒置后的节点
            pre.next=reverse(start);
            //现在start是处理完的最后一个节点，把它连接上next未处理节点
            start.next=next;
            //已处理节点后移
            pre=start;
            end=pre;
        }
        return dummy.next;
    }
    //翻转整个链表
    public static ListNode reverse(ListNode head){
        //建立一个链表存储以倒置的节点
        ListNode pre=null;
        //当未倒置节点非空继续操作
        while (head!=null){
            //把未倒置节点除第一个节点，放入next链表
            ListNode next =head.next;
            //把未倒置节点的第一个节点添加到pre链表前，并把值赋给pre完成倒置节点的添加
            head.next=pre;
            pre=head;
            //把未倒置节点next写回head，继续操作
            head=next;
        }
        return pre;
    }
    public static void PrintList(ListNode head){
        if (head == null) {
            return;
        }
        System.out.print(head.val);
        while (head.next!=null){
            System.out.print("->"+head.next.val);
            head=head.next;
        }
        System.out.println();
    }
}
