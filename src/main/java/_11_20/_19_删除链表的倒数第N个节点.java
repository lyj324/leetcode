package _11_20;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/9/11 9:00
 */

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _19_删除链表的倒数第N个节点 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        PrintList(removeNthFromEnd(listNode1,1));
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //在头结点前添加空节点
        ListNode pre = new ListNode(0);
        pre.next=head;
        //定义两个指针,注意此时first，second，pre是一个对象
        ListNode first=pre;
        ListNode second=pre;
        //1号指针向右移动n+1格，与2号指正保持n+1格差距
        for (int i = 0; i <n+1 ; i++) {
            first=first.next;
        }
        //1,2号指针同时向后移动直到1号指针移动到末尾，即空节点
        while (first!=null){
            first=first.next;
            second=second.next;
        }
        //此时2号指正后一位就是要被删除的节点,跳过该节点则它被删除了
        second.next=second.next.next;
        //返回头结点
        return pre.next;
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
    }
}
