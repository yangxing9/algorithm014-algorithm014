import java.util.HashSet;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/2 0002 16:50
 */
public class HasCycle2 {

    /**
     * 141. 环形链表
     * 给定一个链表，判断链表中是否有环。
     *
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        HashSet<ListNode> cache = new HashSet<>();
        while (head != null) {
            if (cache.contains(head)) {
                return true;
            }
            cache.add(head);
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
