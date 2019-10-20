package _81_90;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/10/20 9:58
 */

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _86_分隔链表 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(2);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        listNode5.next=listNode6;
        int x=3;
        partition(listNode1,x);
        PrintList(listNode1);
        PrintList(partition(listNode1,x));
    }
    public static class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
    public static ListNode partition(ListNode head, int x) {
        ListNode listNodeBig = new ListNode(x);
        ListNode pre = new ListNode(0);
        ListNode preT=pre;
        ListNode listNodeBigT=listNodeBig;
        while (head!=null){
            if(head.val<x){
                pre.next=new ListNode(head.val);
                head=head.next;
                pre=pre.next;
            }else {
                listNodeBig.next=new ListNode(head.val);
                head=head.next;
                listNodeBig=listNodeBig.next;
            }
        }
        pre.next=listNodeBigT.next;
        return preT.next;
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
        System.out.println("");
    }
}
