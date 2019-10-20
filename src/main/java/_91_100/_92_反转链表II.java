package _91_100;

/**
 * @author lyj
 * @version 1.0
 * @date 2019/10/20 14:45
 */

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _92_反转链表II {
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
        int m=2;
        int n=4;
        PrintList(reverseBetween(listNode1,m,n));
    }
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(m > n || m < 1 || n < 1) {
            return head;
        }
        ListNode cur = head;
        ListNode top = null, end = null;
        int len = 0;
        // 找到前一个节点 top，和后一个节点 end
        while(cur != null) {
            len++;
            top = (len == (m - 1)) ? cur : top;
            end = (len == (n + 1)) ? cur : end;
            cur = cur.next;
        }

        if(len == 1) {
            return head;
        }
        ListNode nodeH = top == null ? head : top.next, next = null;
        len = n - m;
        // 进行正常的链表反转
        while(len >= 0) {
            next = nodeH.next;
            // 将反转后的链表的最后一个节点链接到 end 上
            nodeH.next = end;
            end = nodeH;
            nodeH = next;
            len--;
        }
        // 将反转后的链表链接到 top 上
        if(top == null) {
            return end;
        } else {
            top.next = end;
        }
        return head;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
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
        System.out.println("");
    }
}
