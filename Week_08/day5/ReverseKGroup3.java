/**
 * 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 *
 *
 * 说明：
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 1 -> 2 -> 3 -> 4 -> 5
 */
public class ReverseKGroup3 {
    public static void main(String[] args) {
        ReverseKGroup3 reverseKGroup3 = new ReverseKGroup3();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode res = reverseKGroup3.reverseKGroup(a,3);
        System.out.println(res);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null && head.next != null){
            int count = 1;
            ListNode tmp = head;
            while (head != null && head.next != null && count < k){
                count++;
                head = head.next;
            }
            ListNode next = head.next;
            head.next = null;
            if (count == k){
                ListNode s = reverse(tmp);
                pre.next = s;
                tmp.next = next;
                pre = tmp;
                head = next;
            }else {
                break;
            }
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode node){
        if (node == null || node.next == null){
            return node;
        }
        ListNode p = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return p;
    }

}
