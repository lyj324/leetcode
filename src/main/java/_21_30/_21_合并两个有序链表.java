package _21_30;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/9/11 10:22
 */

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _21_合并两个有序链表 {
    public static void main(String[] args) {
        ListNode listNode1_1 = new ListNode(1);
        ListNode listNode1_2 = new ListNode(2);
        ListNode listNode1_3 = new ListNode(4);
        ListNode listNode2_1 = new ListNode(1);
        ListNode listNode2_2 = new ListNode(3);
        ListNode listNode2_3 = new ListNode(4);
        listNode1_1.next=listNode1_2;
        listNode1_2.next=listNode1_3;
        listNode2_1.next=listNode2_2;
        listNode2_2.next=listNode2_3;
        PrintList(mergeTwoLists(listNode1_1,listNode2_1));
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //每次从1,2链表中取开头一个对象作为新链表的一个节点，当其中一个链表空了说明已经插入完毕了，
        //1链表全部插入2链表，或者2链表已经全部插入1链表
        //返回对应链表
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        //把两个链表中小的数拿出，它后继节点递归找出
        if(l1.val<l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next=mergeTwoLists(l2.next,l1);
            return l2;
        }
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
