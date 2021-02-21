package day4;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yangxing
 * @version 1.0
 * @date 2021/2/2 0002 15:18
 */
public class HasCycle3 {

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if (set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }

    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (true){
            if (fast == null || fast.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (true){
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

}
