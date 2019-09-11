package _21_30;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/9/11 15:30
 */

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _24_两两交换链表中的节点 {
    public static void main(String[] args) {
        ListNode listNode1_1 = new ListNode(1);
        ListNode listNode1_2 = new ListNode(2);
        ListNode listNode1_3 = new ListNode(3);
        ListNode listNode1_4 = new ListNode(4);
        listNode1_1.next=listNode1_2;
        listNode1_2.next=listNode1_3;
        listNode1_3.next=listNode1_4;
        PrintList(swapPairs(listNode1_1));
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //递归交换
    public static ListNode swapPairs(ListNode head) {
        //如果需要交换的链表不存在或者只剩下一个节点，直接返回
        if(head==null||head.next==null){
            return head;
        }
        /**
         * 1.假设现在的节点状态为
         *  1.1已处理好的节点->head->head.next->未处理的节点
         *  1.2创建新的头结点，它的值是交换节点的后一个即head.next
         * 2.现在节点状态为
         *  2.1已处理好的节点->head->head.next->未处理的节点
         *                          result->未处理的节点
         */
        ListNode result = head.next;
        /**
         * 3.使未处理的节点也进行递归操作，最终变为处理的节点。现在节点的状态为
         *  3.1已处理好的节点->head->未处理的节点
         *      head.next->未处理的节点
         *      result->未处理的节点
         */
        head.next=swapPairs(result.next);
        /**
         * 4.现在节点的状态为
         *  4.1 result->head->未处理的节点
         * 5.完成交换
         */
        result.next=head;
        return result;
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
