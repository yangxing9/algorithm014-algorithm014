package day3;

/**
 * @author yangxing
 * @version 1.0
 * @date 2021/2/2 0002 14:22
 */
public class SwapPairs5 {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode result = swapPairs2(a);
        System.out.println(result.val);
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode second = head.next;
        ListNode last = swapPairs(second.next);
        second.next = head;
        head.next = last;
        return second;
    }

    public static ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null){
            ListNode second = cur.next;
            cur.next = second.next;
            second.next = cur;
            pre.next = second;
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
