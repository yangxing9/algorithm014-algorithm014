/**
 * @author yangxing
 * @version 1.0
 * @date 2020/10/13 0013 10:00
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapPairs3 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode p = swapPairs(next.next);
        head.next = p;
        next.next = head;
        return next;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null && head.next != null){
            ListNode tmp = head.next.next;
            pre.next = head.next;
            head.next.next = head;
            head.next = tmp;
            pre = head;
            head = head.next;
        }
        return dummy.next;
    }

}
