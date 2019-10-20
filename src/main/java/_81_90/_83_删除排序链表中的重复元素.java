package _81_90;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/10/18 11:36
 */
public class _83_删除排序链表中的重复元素 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        PrintList(deleteDuplicates(listNode1));
    }
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
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
