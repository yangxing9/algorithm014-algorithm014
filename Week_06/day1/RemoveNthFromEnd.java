/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/14 0014 16:4719. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 */
public class RemoveNthFromEnd {

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
        System.out.println(new RemoveNthFromEnd().removeNthFromEnd2(a,2));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        int index = 0;
        ListNode node1 = head;
        while (node1 != null){
            index++;
            node1 = node1.next;
        }
        int targetIndex = index - n;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (targetIndex > 0) {
            targetIndex--;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode second = dummy;
        int index = 0;
        while (head != null) {
            index++;
            if (index > n){
                second = second.next;
            }
            head = head.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

}
