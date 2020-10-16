/**
 * @author yangxing
 * @version 1.0
 * @date 2020/10/13 0013 11:09
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
 */
public class ReverseKGroup4 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null && head.next != null){
            ListNode first = head;
            int count = 1;
            while (head != null && head.next != null && count < k){
                head = head.next;
                count++;
            }
            if (count == k){
                ListNode next = head.next;
                head.next = null;
                ListNode reverseFirst = helper(first);
                pre.next = reverseFirst;
                first.next = next;
                pre = first;
                head = next;
            }else {
                break;
            }
        }
        return dummy.next;
    }

    private ListNode helper(ListNode node) {
        if (node == null || node.next == null) return node;
        ListNode p = helper(node.next);
        node.next.next = node;
        node.next = null;
        return p;
    }

}
